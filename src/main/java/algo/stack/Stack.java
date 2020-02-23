package algo.stack;

// Не добавляйте инструкции import, не переименовывайте существующие классы и поля, не изменяйте заголовки методов.

import java.util.*;

public class Stack<T> {

    public LinkedList<T> ll;

    public Stack() {
        ll = new LinkedList<>();
    }

    // втолкнуть на вершину
    public void push(T val) {
        ll.push(val);
    }

    // вытолкнуть с вершины (с удалением)
    public T pop() {
        return ll.pop();
    }

    // получить с вершины (без удаления)
    public T peek() {
        return ll.peek();
    }

    // размер текущего стека
    public int size() {
        return ll.size();
    }
}