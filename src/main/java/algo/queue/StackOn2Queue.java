package algo.queue;

public class StackOn2Queue<T> {

    public Queue<T> q1;
    public Queue<T> q2;

    public StackOn2Queue() {
        q1 = new Queue<>();
        q2 = new Queue<>();
    }

    // втолкнуть на вершину
    public void push(T val) {

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
