package org.example;

import org.example.tasks.Taskable;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue implements Queue<Taskable> {
    private final LinkedList<Taskable> tasks;

    public TaskQueue() {
        this.tasks = new LinkedList<>(); // Внутренний контейнер для хранения задач
    }

    // Добавляет задачу в очередь, если имеется свободное место (для неограниченных очередей всегда возвращает true)
    @Override
    public boolean offer(Taskable task) {
        return tasks.offer(task); // Добавляем задачу в конец списка
    }

    // Извлекает и удаляет первую задачу из очереди, возвращая её (если очередь пуста, возвращает null)
    @Override
    public Taskable poll() {
        return tasks.poll(); // Удаляем и возвращаем первую задачу
    }

    // Показывает первую задачу в очереди, не удаляя её (если очередь пуста, возвращает null)
    @Override
    public Taskable peek() {
        return tasks.peek(); // Возвращает первую задачу без изменений очереди
    }

    // Получает размер очереди (количество задач)
    @Override
    public int size() {
        return tasks.size(); // Возвращает количество элементов в списке
    }

    // Предоставляет итератор для последовательного обхода всех задач в очереди
    @Override
    public Iterator<Taskable> iterator() {
        return tasks.iterator(); // Возвращает итератор для прохода по списку задач
    }

    // Удаляет задачу из очереди (возвращает true, если такая задача найдена и удалена)
    @Override
    public boolean remove(Object o) {
        return tasks.remove((Taskable) o); // Удаляет указанный объект из очереди
    }

    // Проверяет, содержится ли данная задача в очереди
    @Override
    public boolean contains(Object o) {
        return tasks.contains((Taskable) o); // Проверяет наличие задачи в очереди
    }

    // Полностью очищает очередь, удаляя все задачи
    @Override
    public void clear() {
        tasks.clear(); // Очищает внутренний список задач
    }

    // Проверяет, пуста ли очередь (возвращает true, если очередь не содержит ни одной задачи)
    @Override
    public boolean isEmpty() {
        return tasks.isEmpty(); // Проверяет, пуст ли список задач
    }

    // Преобразует очередь в обычный массив объектов
    @Override
    public Object[] toArray() {
        return tasks.toArray(); // Преобразует список задач в массив
    }

    // Преобразует очередь в массив указанного типа
    @Override
    public <T> T[] toArray(T[] a) {
        return tasks.toArray(a); // Преобразует список задач в массив указанного типа
    }

    // Добавляет задачу в очередь (аналогично offer())
    @Override
    public boolean add(Taskable t) {
        return tasks.add(t); // Добавляет задачу в конец очереди
    }

    // Добавляет коллекцию задач в очередь
    @Override
    public boolean addAll(Collection<? extends Taskable> c) {
        return tasks.addAll(c); // Добавляет группу задач в очередь
    }

    // Удаляет все задачи, представленные в указанной коллекции
    @Override
    public boolean removeAll(Collection<?> c) {
        return tasks.removeAll(c); // Удаляет все задачи, присутствующие в коллекции
    }

    // Удаляет все задачи, кроме тех, которые присутствуют в указанной коллекции
    @Override
    public boolean retainAll(Collection<?> c) {
        return tasks.retainAll(c); // Оставляет только задачи, присутствующие в коллекции
    }

    // Проверяет, содержатся ли все задачи из указанной коллекции в очереди
    @Override
    public boolean containsAll(Collection<?> c) {
        return tasks.containsAll(c); // Проверяет, содержат ли все задачи очереди элементы из коллекции
    }

    // Извлекает и удаляет первую задачу из очереди (выбрасывает исключение, если очередь пуста)
    @Override
    public Taskable element() {
        return tasks.element(); // Возвращает первую задачу и удаляет её, вызывая исключение, если очередь пуста
    }

    // Извлекает и удаляет первую задачу из очереди (выбрасывает исключение, если очередь пуста)
    @Override
    public Taskable remove() {
        return tasks.remove(); // Удаляет и возвращает первую задачу, вызывая исключение, если очередь пуста
    }
}
