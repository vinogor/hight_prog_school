package algo.queue;

import algo.stack.Stack;

// очередь на основе 2х стеков
public class QueueOn2Stacks<T> {

    private Stack<T> straight;
    private Stack<T> reverse;
    private boolean isStraight;

    public QueueOn2Stacks() {
        straight = new Stack<>();
        reverse = new Stack<>();
        isStraight = true;
    }

    // втолкнуть на вершину
    public void push(T val) {
        // если очередь хранится в обратном стеке, то переложить всё в прямой
        if (!isStraight) {
            shift();
            isStraight = true;
            return;
        }
        // положить в прямой
        straight.push(val);
    }

    // переложить в другой стек
    private void shift() {

    }

    // вытолкнуть с вершины (с удалением)
    // если выталкивать нечего, возвращает налл
    public T pop() {


        return null;
    }

    // получить с вершины (без удаления)
    // если получить нечего, возвращает налл
    public T peek() {

        return null;
    }

    // размер текущего стека
    public int size() {

        return 0;
    }
}
