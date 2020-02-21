package algo.stack;

//

import algo.linkedList.LinkedList;
import algo.linkedList.Node;

public class Stack<T> {

    public LinkedList<T> ll;
    public T lastPushedValue;

    public Stack() {
        // инициализация внутреннего хранилища стека
        ll = new LinkedList<>();
    }

    // втолкнуть на вершину
    public void push(T val) {
        ll.addInTail(new Node<>(val));
    }

    // вытолкнуть с вершины (с удалением)
    public T pop() {

        // если стек пустой то выталкивать нечего
        if (ll.countPro() == 0) {
            return null;
        }

        lastPushedValue = ll.head.value;
        ll.remove(lastPushedValue);

        return lastPushedValue;
    }

    // получить с вершины (без удаления)
    public T peek() {

        return null; // если стек пустой
    }

    // размер текущего стека
    public int size() {
        // счётчик возьмём из линкед листа, он уже реализован
        return ll.countPro();
    }

}