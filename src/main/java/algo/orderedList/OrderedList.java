package algo.orderedList;

import java.util.*;

class Node<T> {

    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

// на основе идеи двусвязного списка
public class OrderedList<T> {

    public Node<T> head, tail;
    private boolean _ascending; // по возрастанию

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    // -1 если v1 < v2
    // 0 если v1 == v2
    // +1 если v1 > v2

    //  Если это числа, их можно сравнить арифметически,
    //  если это строки, то их надо перед стандартным в любом языке
    //  лексикографическом сравнением очистить от начальных и конечных пробелов.

    // ??? Пока сделайте базовый вариант этого метода, который сравнивает числовые значения.

    public int compare(T v1, T v2) {
        if (v1 instanceof Integer && v2 instanceof Integer) {
            if (v1.equals(v2)) { // так как пул
                return 0;
            } else {
                return (Integer) v1 > (Integer) v2 ? 1 : -1;
            }
        }
        return 0;
    }

    // автоматическая вставка value
    // в нужную позицию
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        // если список пуст то просто вставляем
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else
            // если вставка в самое начало
            if ((compare(head.value, value) >= 0 && _ascending)
                    || (compare(head.value, value) <= 0 && !_ascending)) {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            } else
                // если вставка в конец
                if ((compare(tail.value, value) <= 0 && _ascending)
                        || (compare(tail.value, value) >= 0 && !_ascending)) {
                    newNode.prev = tail;
                    tail.next = newNode;
                    tail = newNode;
                }
                // в остальных случаях проходимся в поисках места
                // и вставляем между узлами
                else {
                    Node<T> node = this.head;
                    while (true) { // так как хвост мы уже сравнили
                        if ((_ascending && (compare(node.value, value) <= 0) && (compare(value, node.next.value) <= 0))
                                || (!_ascending && (compare(node.value, value) >= 0) && (compare(value, node.next.value) >= 0))) {

                            // вставляем ПОСЛЕ текущей
                            newNode.prev = node;
                            newNode.next = node.next;
                            node.next.prev = newNode;
                            node.next = newNode;
                            break;
                        }
                        node = node.next;
                    }
                }
    }

    // Переделайте функцию поиска с учётом признака упорядоченности и возможности раннего прерывания поиска,
    // если найден заведомо больший или меньший элемент, нежели искомый (то есть значение по сути не найдено).
    public Node<T> find(T val) {

        Node<T> node = this.head;
        while (node != null) {

            if (compare(node.value, val) == 0) {
                return node;
            } else
                // досрочный выход
                if ((_ascending && compare(node.value, val) > 0)
                        || (!_ascending && compare(node.value, val) < 0)) {
                    return null;
                }
            node = node.next;
        }
        return null;
    }

    //
    public void delete(T val) {
        // здесь будет ваш код
    }

    public void clear(boolean asc) {
        _ascending = asc;
        // здесь будет ваш код
    }

    public int count() {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    ArrayList<Node<T>> getAll() {
        // выдать все элементы упорядоченного
        // списка в виде стандартного списка
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}