package algo.queue;

import algo.stack.Stack;

// очередь на основе 2х стеков
public class QueueOn2Stacks<T> {

    private Stack<T> straight;
    private Stack<T> reverse;

    public QueueOn2Stacks() {
        straight = new Stack<>();
        reverse = new Stack<>();
    }

    // добавить в хвост очереди
    public void enqueue(T item) {

        // если очередь хранится в обратном стеке, то переложить всё в прямой
        if (straight.size() == 0) {
            shift(reverse, straight);
        }

        // положить в прямой стек (конец очереди)
        straight.push(item);
    }

    // выдача из головы (с удалением)
    // null если очередь пустая
    public T dequeue() {

        // если очередь пуста
        if (straight.size() == 0 && reverse.size() == 0) {
            return null;
        }

        // если очередь хранится в прямом стеке, то переложить всё в обратный
        if (reverse.size() == 0) {
            shift(straight, reverse);
        }

        // собственно выталкиваем с удалением
        return reverse.peek();
    }

    // размер текущей очереди
    public int size() {
        return straight.size() + reverse.size();
    }

    // переложить в другой стек
    private void shift(Stack<T> source, Stack<T> destination) {
        while (source.size() != 0) {
            destination.push(source.pop());
        }
    }
}
