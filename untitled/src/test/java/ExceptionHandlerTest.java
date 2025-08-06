package org.example.tasks;

import org.example.TaskQueue;
import org.example.commands.Command;
import org.example.commands.Move;
import org.example.exceptionHandler.CommandExceptionHandler;
import org.example.exceptionHandler.ExceptionHandler;
import org.example.exceptionHandler.OtherExceptionHandler;
import org.example.move.MovingObjectAdapter;
import org.example.object.Object;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Тест класса ExceptionHandler ")
public class ExceptionHandlerTest {

    private final List<String> capturedLogs = new ArrayList<>();
    private Handler customHandler;
    private Logger customLogger;
    private TaskQueue queue = new TaskQueue();
    private Object object = new Object(new HashMap<String, Object>());
    private MovingObjectAdapter movingObjectAdapter = new MovingObjectAdapter(object);
    private Move move = new Move(movingObjectAdapter);
    private Command command = new Command(move);
    private StartTask startTask = new StartTask(command);

    @BeforeEach
    public void setUp() {
        // Создаем своего обработчика, собирающего сообщения
        this.customHandler = new StreamHandler(System.out, new SimpleFormatter()) {
            @Override
            public synchronized void publish(java.util.logging.LogRecord record) {
                if (record.getLevel() == Level.SEVERE) {
                    capturedLogs.add(record.getMessage() + " | " + record.getThrown().toString());
                }
            }
        };

        // Создаем отдельный логгер и подключаем обработчик
        customLogger = Logger.getLogger("testLogger");
        customLogger.addHandler(customHandler);
    }

    @AfterEach
    public void cleanUp() {
        customLogger.removeHandler(customHandler); // Убираем обработчик
        capturedLogs.clear(); // Очищаем хранящиеся логи
    }

    @Test
    @DisplayName("Тест команды, которая записывает информацию о выброшенном исключении в лог.")
    void LogTaskTest() {

        try {
            startTask.Execute(); // Попытка выполнить команду приведет к ошибке
        } catch (Exception e) {
            new LogTask(customLogger, e, startTask.getCommand()).Execute(); // Передаем в логгер

            // Получаем сообщение исключения
            String expectedMessagePart = e.getMessage();
            String expectedClassName = command.getClass().getName();

            // Проверяем, что наша информация попала в логи
            assertTrue(
                    capturedLogs.stream()
                            .anyMatch(log -> log.contains(expectedClassName) && log.contains(expectedMessagePart)),
                    "Информация не попала в логи!"
            );
        }

    }

    @Test
    @DisplayName("Тест обработчика исключения, который ставит Команду, пишущую в лог в очередь Команд.")
    public void RestartLogTaskTest() {
        try {
            startTask.Execute();
        } catch (Exception e) {
            new OtherExceptionHandler(queue, startTask.getCommand(), e, customLogger).hand();


            // Проверяем, что последний элемент в очереди имеет тип LogTask
            Taskable lastAddedTask = queue.peek(); // peek() смотрит на вершину очереди, не извлекая элемент
            assertTrue(lastAddedTask instanceof LogTask, "Последний элемент в очереди не является LogTask");
        }
    }

    @Test
    @DisplayName("Тест команды, которая повторяет Команду, выбросившую исключение.")
    public void RestartTaskTest() throws Exception {
        queue.clear();
        try {
            startTask.Execute();
        } catch (Exception e) {
            Command cmd1 = startTask.getCommand();
            new RestartTask(cmd1, queue).Execute();


            // Проверяем, что последний элемент в очереди имеет тип LogTask
            Taskable lastAddedTask = queue.peek(); // peek() смотрит на вершину очереди, не извлекая элемент
            Command cmd = (Command) lastAddedTask.getCommand();
            assertEquals(cmd, startTask.getCommand(), "Последний элемент в очереди не является StartTask");
        }
    }

    @Test
    @DisplayName("Тест обработчика исключения, который ставит в очередь Команду - повторитель команды, выбросившей исключение.")
    public void RestartingRestartTaskTest() {
        queue.clear();
        try {
            startTask.Execute();
        } catch (Exception e) {
            new CommandExceptionHandler(queue, startTask.getCommand(), e, customLogger).hand();


            // Проверяем, что последний элемент в очереди имеет тип LogTask
            Taskable lastAddedTask = queue.peek(); // peek() смотрит на вершину очереди, не извлекая элемент
            assertTrue(lastAddedTask instanceof RestartTask, "Последний элемент в очереди не является LogTask");
        }
    }

    @Test
    @DisplayName("Тест реализации следующей обработки исключений:\n" +
            "при первом выбросе исключения повторить команду, при повторном выбросе исключения записать информацию в лог.")
    void TwoExceptionsAndLogTaskTest() {
        boolean flag = true;
        boolean logFlag = false;
        queue.add(startTask);
        while (flag) {
            Taskable startTask1 = queue.poll();
            if (startTask1 instanceof LogTask){
                logFlag = true;
                break;
            }
            try {
                startTask1.Execute();
            } catch (Exception e) {
                if (startTask1.getCommand().getNumberOfCalls() < 2) {
                    queue.add(new RestartTask(startTask1.getCommand(), queue));
                } else if (startTask1.getCommand().getNumberOfCalls() == 2) {
                    queue.add(new TwoExceptionsTask(customLogger, startTask1.getCommand(), e, queue));
                } else if (queue.isEmpty()) {
                    flag = false;
                }
            }
        }
        assertTrue(logFlag, "Последний элемент в очереди не является LogTask");
    }

    @Test
    @DisplayName("Тест реализации стратегии обработки исключения - повторить два раза, потом записать в лог.")
    void StrategyTwoExceptionsAndLogTaskTest() {
        boolean flag = true;
        boolean logFlag = false;
        queue.add(startTask);
        while (flag) {
            Taskable startTask1 = queue.poll();
            if (startTask1 instanceof LogTask){
                logFlag = true;
                break;
            }
            try {
                startTask1.Execute();
            } catch (Exception e) {
                new ExceptionHandler(queue, startTask1.getCommand(), e, customLogger).hand();
            if (queue.isEmpty()) {
                    flag = false;
                }
            }
        }
        assertTrue(logFlag, "Последний элемент в очереди не является LogTask");
    }
}