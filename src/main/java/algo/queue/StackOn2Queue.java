package algo.queue;

public class StackOn2Queue<T> {

    private Queue<T> straight;
    private Queue<T> reverse;
    private boolean isStraight;

    public StackOn2Queue() {
        straight = new Queue<>();
        reverse = new Queue<>();
        isStraight = true;
    }

    // втолкнуть на вершину
    public void push(T val) {
        // если очередь хранится в обратном стеке, то переложить всё в прямой
        if (!isStraight) {
            shift();
            isStraight = true;
        }
        // положить в прямой
        straight.enqueue(val);
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
