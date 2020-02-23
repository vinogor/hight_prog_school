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
    // если выталкивать нечего, возвращает налл
    public T pop() {
        T res = null;
        try {
            res = ll.pop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
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