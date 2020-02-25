package algo.queue;

import java.util.*;

public class Queue<T> {

    private java.util.Queue<T> q;

    // инициализация внутреннего хранилища очереди
    public Queue() {
        q = new LinkedList<>();
    }

    // добавить в хвост
    public void enqueue(T item) {
        // вставка в хвост
        q.add(item);
    }

    // выдача из головы (с удалением)
    // null если очередь пустая
    public T dequeue() {
        return q.poll();
    }

    // размер очереди
    public int size() {
        return q.size();
    }

    // ДОПОЛНИТЕЛЬНО:
    // Напишите функцию, которая "вращает" очередь по кругу на N элементов.
    public T roll() {
        // если очередь пуста
        if (q.size() == 0) {
            return null;
        }

        // получим с головы
        T poll = q.poll();
        // добавим полученное в хвост
        q.add(poll);
        return poll;
    }
}