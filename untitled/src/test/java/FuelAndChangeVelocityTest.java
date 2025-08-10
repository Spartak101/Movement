import org.example.commands.*;
import org.example.dmensionalityClasses.*;
import org.example.exceptions.ObjectException;
import org.example.move.MovingObjectAdapter;
import org.example.object.Object;
import org.example.rotation.RotationObjectAdapter;
import org.example.tasks.StartTask;
import org.example.tasks.Taskable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тест классов Fuel и ChangeVelocity ")
public class FuelAndChangeVelocityTest {

    private Point point = new Point(12, 5);
    private Velocity velocity = new Velocity(-7, 3);
    private CornerCourse course = new CornerCourse(0);
    private AngularVelocity angularVelocity = new AngularVelocity(5);


    @Test
    @DisplayName("Тест на проверку топлива")
    public void CheckFuelTest() throws Exception {
        Fuel fuel = new Fuel(100);
        CheckFuel checkFuel = new CheckFuel(fuel, 1);
        checkFuel.Execute();
        int fuelQuantity = fuel.getFuel();

        assertEquals(fuelQuantity, 100, "Топливо не обнаружено");
    }

    @Test
    @DisplayName("Тест на проверку топлива, если его меньше необходимого")
    public void CheckFuelExceptionFuelIzLowTest() throws Exception {
        Fuel fuel = new Fuel(50);
        CheckFuel checkFuel = new CheckFuel(fuel, 100);
        Assertions.assertThrows(ObjectException.class, () -> {
            checkFuel.Execute();
        });
    }

    @Test
    @DisplayName("Тест на проверку топлива, если оно закончилось")
    public void CheckFuelExceptionFuelIzZeroTest() throws Exception {
        Fuel fuel = new Fuel(0);
        CheckFuel checkFuel = new CheckFuel(fuel, 1);
        Assertions.assertThrows(ObjectException.class, () -> {
            checkFuel.Execute();
        });
    }

    @Test
    @DisplayName("Тест на сжигание топлива")
    public void BrunFuelTest() throws Exception {
        Fuel fuel = new Fuel(100);
        BurnFuel burnFuel = new BurnFuel(fuel, 1);
        burnFuel.Execute();
        int fuelQuantity = fuel.getFuel();

        assertEquals(fuelQuantity, 99, "Топливо не горит");
    }

    @Test
    @DisplayName("Тест мультикоманды")
    public void MultiCommandTest() throws Exception {
        Fuel fuel = new Fuel(100);
        HashMap<String, Argumenteble> iniMap = new HashMap<>();
        iniMap.put("location", point);
        iniMap.put("velocity", velocity);
        iniMap.put("fuel", fuel);
        org.example.object.Object object = new Object(iniMap);
        MovingObjectAdapter movingObjectAdapter = new MovingObjectAdapter(object);
        Move move = new Move(movingObjectAdapter);
        CheckFuel checkFuel = new CheckFuel((Fuel) object.get("fuel"), 1);
        BurnFuel burnFuel = new BurnFuel((Fuel) object.get("fuel"), 1);
        Command checkFuelCommand = new Command(checkFuel);
        Command movingCommand = new Command(move);
        Command burnFuelCommand = new Command(burnFuel);
        ArrayList<Taskable> iniMultiCommand = new ArrayList<>();
        iniMultiCommand.add(new StartTask(checkFuelCommand));
        iniMultiCommand.add(new StartTask(movingCommand));
        iniMultiCommand.add(new StartTask(burnFuelCommand));
        MultiCommand multiCommand = new MultiCommand(iniMultiCommand);
        multiCommand.Execute();

        Point po = (Point) object.get("location");
        int coordinateOne = po.getCoordinateOne();
        int coordinateTwo = po.getCoordinateTwo();
        int expectedCoordinateOneResult = coordinateOne;
        int expectedCoordinateTwoResult = coordinateTwo;
        Fuel fu = (Fuel) object.get("fuel");
        int fuelQuantity = fu.getFuel();
        int expectedFuelQuantity = fuelQuantity;


        assertAll(
                () -> assertEquals(expectedCoordinateOneResult, 5, "Первая координата не верна"),
                () -> assertEquals(expectedCoordinateTwoResult, 8, "Вторая координата не верна"),
                () -> assertEquals(expectedFuelQuantity, 99, "Количество топлива не верно")
        );
    }

    @Test
    @DisplayName("Тест ChangeVelocity")
    public void ChangeVelocityTest() throws Exception {
        HashMap<String, Argumenteble> iniMap = new HashMap<>();
        iniMap.put("velocity", velocity);
        org.example.object.Object object = new Object(iniMap);
        ChangeVelocity changeVelocity = new ChangeVelocity((Velocity) object.get("velocity"), 5, 5);
        Command changeVelocityCommand = new Command(changeVelocity);
        changeVelocityCommand.Execute();

        Velocity ve = (Velocity) object.get("velocity");
        int componentVelocityOne = ve.getVelocityComponentOne();
        int componentVelocityTwo = ve.getVelocityComponentTwo();
        int expectedComponentVelocityOne = componentVelocityOne;
        int expectedComponentVelocityTwo = componentVelocityTwo;


        assertAll(
                () -> assertEquals(expectedComponentVelocityOne, -2, "Первая компонента скорости не верна"),
                () -> assertEquals(expectedComponentVelocityTwo, 8, "Вторая компонента скорости не верна")
        );
    }

    @Test
    @DisplayName("Тест мультикоманды")
    public void TurningAndSpeedTest() throws Exception {
        HashMap<String, Argumenteble> iniMap = new HashMap<>();
        iniMap.put("velocity", velocity);
        iniMap.put("Course", course);
        iniMap.put("AVelocity", angularVelocity);
        org.example.object.Object object = new Object(iniMap);
        RotationObjectAdapter rotationObjectAdapter = new RotationObjectAdapter(object);
        Rotation rotation = new Rotation(rotationObjectAdapter);
        ChangeVelocity changeVelocity = new ChangeVelocity((Velocity) object.get("velocity"), 5, 5);
        Command changeCommand = new Command(changeVelocity);
        Command rotatiunCommand = new Command(rotation);

        ArrayList<Taskable> iniMultiCommand = new ArrayList<>();
        iniMultiCommand.add(new StartTask(rotatiunCommand));
        iniMultiCommand.add(new StartTask(changeCommand));
        MultiCommand multiCommand = new MultiCommand(iniMultiCommand);
        multiCommand.Execute();


        Velocity ve = (Velocity) object.get("velocity");
        int componentVelocityOne = ve.getVelocityComponentOne();
        int componentVelocityTwo = ve.getVelocityComponentTwo();
        int expectedComponentVelocityOne = componentVelocityOne;
        int expectedComponentVelocityTwo = componentVelocityTwo;
        CornerCourse cc = (CornerCourse) object.get("Course");
        int cornerCourse = cc.getCourse();
        int expectedCornerCourse = cornerCourse;


        assertAll(
                () -> assertEquals(expectedComponentVelocityOne, -2, "Первая компонента скорости не верна"),
                () -> assertEquals(expectedComponentVelocityTwo, 8, "Вторая компонента скорости не верна"),
                () -> assertEquals(expectedCornerCourse, 5, "Курс не верен")
        );
    }
}
