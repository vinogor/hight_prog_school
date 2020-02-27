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
    private int counter;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        counter = 0;
    }

    // -1 если v1 < v2
    // 0 если v1 == v2
    // +1 если v1 > v2

    //  Если это числа, их можно сравнить арифметически,
    //  если это строки, то их надо перед стандартным в любом языке
    //  лексикографическом сравнением очистить от начальных и конечных пробелов.

    public int compare(T v1, T v2) {
        if (v1 instanceof Integer && v2 instanceof Integer) {
            if (v1.equals(v2)) { // так как пул
                return 0;
            } else {
                return (Integer) v1 > (Integer) v2 ? 1 : -1;
            }
        } else
            //
        if (v1 instanceof String && v2 instanceof String) {
            if (v1.equals(v2)) {
                return 0;
            } else {
                // очистим от пробелов по краям
                String s1 = ((String) v1).trim();
                String s2 = ((String) v2).trim();

                // лексикографическое сравнение строк
                return s1.compareTo(s2);
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
                    while (true) {
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
        counter++;
    }

    // Переделайте функцию поиска с учётом признака упорядоченности и возможности раннего прерывания поиска,
    // если найден заведомо больший или меньший элемент, нежели искомый (то есть значение по сути не найдено).
    public Node<T> find(T val) {

        if (head == null) {
            return null;
        }

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

    public void delete(T val) {

        // если удалять из пустого
        if (head == null) {
            return;
        } else
            // если удалять из списка в 1 элемент
            if (head == tail && (compare(head.value, val) == 0)) {
                head = null;
                tail = null;
                counter--;
            } else
                // если есть только 1 эл-т и его удалять не надо
                if (head == tail) {
                    return;
                } else
                    // если удалять с головы
                    if (compare(head.value, val) == 0) {
                        head.next.prev = null;
                        head = head.next;
                        counter--;
                    } else
                        // если удалять с хвоста
                        if (compare(tail.value, val) == 0) {
                            tail.prev.next = null;
                            tail = tail.prev;
                            counter--;
                        }
                        // если удалять из середины
                        else {
                            // последовательный перебор исключая голову и хвост
                            Node<T> node = this.head.next;
                            while (node != tail) {

                                if (compare(node.value, val) == 0) {
                                    // удаляем
                                    node.prev.next = node.next;
                                    node.next.prev = node.prev;
                                    counter--;
                                    break;
                                }

                                // досрочный выход когда понятно что точно не найдётся
                                if ((_ascending && compare(node.value, val) > 0)
                                        || (!_ascending && compare(node.value, val) < 0)) {
                                    break;
                                }

                                node = node.next;
                            }
                        }
    }

    public void clear(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        counter = 0;
    }

    public int count() {
        return counter;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = this.head;
        while (node != null) {
            sb.append(node.value).append(" ");
            node = node.next;
        }
        return sb.toString();
    }
}