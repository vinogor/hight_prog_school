package algo.deque;

import java.util.*;

public class Deque<T> {

    public LinkedList<T> ll;

    // инициализация внутреннего хранилища
    public Deque() {
        ll = new LinkedList<>();
    }

    // добавление в голову
    public void addFront(T item) {
        ll.addFirst(item);
    }

    // добавление в хвост
    public void addTail(T item) {
        ll.addLast(item);
    }

    // удаление из головы
    public T removeFront() {
        if (ll.size() == 0) {
            return null;
        }
        return ll.removeFirst();
    }

    // удаление из хвоста
    public T removeTail() {
        if (ll.size() == 0) {
            return null;
        }
        return ll.removeLast();
    }

    // размер очереди
    public int size() {
        return ll.size();
    }
}