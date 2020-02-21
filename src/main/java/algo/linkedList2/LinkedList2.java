package algo.linkedList2;

import java.util.*;

// ==== Задания ====
// + 1. Добавьте в класс LinkedList2 метод поиска первого узла по его значению.
// + 2. Добавьте в класс LinkedList2 метод поиска всех узлов по конкретному значению (возвращается список/массив найденных узлов).
// + 3. Добавьте в класс LinkedList2 метод удаления одного узла по его значению.
// + 4. Добавьте в класс LinkedList2 метод удаления всех узлов по конкретному значению.
// + 5. Добавьте в класс LinkedList2 метод вставки узла после заданного узла.
// + 6. Добавьте в класс LinkedList2 метод вставки узла самым первым элементом.
// + 7. Добавьте в класс LinkedList2 метод очистки всего содержимого (создание пустого списка).
// ++ 8. Напишите проверочные тесты для каждого из предыдущих заданий.
//
// ==== Рекомендации по тестированию ====
// Проверяйте случаи, когда список пустой, содержит много элементов и один элемент:
// как в таких ситуациях будет работать удаление, вставка, поиск.
// Особое внимание уделите корректности полей head и tail после всех этих операций,
// а также связь в обратную сторону prev.

public class LinkedList2 {
    public Node head;
    public Node tail;
    private int counter;

    public LinkedList2() {
        head = null;
        tail = null;
        counter = 0;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null; // они же и так нулл?
            this.head.prev = null; // типо подстаховака если пришёл узел с прописанными next/prev ?
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        counter++;
    }

    public Node find(int _value) {
        // начинаем поиск с головы
        Node node = this.head;
        // пока не дойдём до конца списка
        while (node != null) {
            if (node.value == _value) {
                //  или пока не найдём и вернём искомое
                return node;
            }
            node = node.next;
        }
        // если не найдём - вернём налл
        return null;
    }

    // здесь будет ваш код поиска всех узлов по заданному значению
    public ArrayList<Node> findAll(int _value) {

        ArrayList<Node> nodes = new ArrayList<>();

        // тут как метод find(int value), только не прекращаем искать если найдём

        // начинаем поиск с головы
        Node node = this.head;

        // пока не дойдём до конца списка
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    // здесь будет ваш код удаления одного узла по заданному значению
    public boolean remove(int _value) {

        // начинаем поиск удаляемого с головы
        Node node = this.head;
        // ищем пока не дойдём до конца списка
        while (node != null) {
            if (node.value == _value) {
                // удаляем элемент
                deleteNode(node);
                counter--;
                return true;
            }
            // берём слудующий если не нашли
            node = node.next;
        }
        // если не нашли
        return false;
    }

    // здесь будет ваш код удаления всех узлов по заданному значению
    public void removeAll(int _value) {
        // начинаем поиск удаляемого с головы
        Node node = this.head;
        // ищем пока не дойдём до конца списка
        while (node != null) {
            if (node.value == _value) {
                // удаляем элемент
                deleteNode(node);
                counter--;
            }
            // берём слудующий если не нашли
            node = node.next;
        }
    }

    private void deleteNode(Node node) {
        // если элемент одинственный
        if (head == node && tail == node) {
            head = null;
            tail = null;
        } else
            // если элемент первый
            if (head == node) {
                head = node.next;
                node.next.prev = null;
            } else
                // если элемент последний
                if (tail == node) {
                    tail = node.prev;
                    node.prev.next = null;
                } else
                // если элемент между других элементов
                {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
    }

    // здесь будет ваш код очистки всего списка
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    // здесь будет ваш код подсчёта количества элементов в списке
    public int count() {
        return counter;
    }

    // здесь будет ваш код вставки узла после заданного узла
    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {

        // если вставка в пустой список и в самое начало
        if (head == null && _nodeAfter == null) {
            head = _nodeToInsert;
            tail = _nodeToInsert;
            _nodeToInsert.next = null;
            _nodeToInsert.prev = null;
            counter++;
        } else
            // если вставка в самое начало
            if (_nodeAfter == null) {
                head.prev = _nodeToInsert;
                _nodeToInsert.next = head;
                head = _nodeToInsert;
                counter++;
            } else {
                // если вставка НЕ в начало, то ищем узел (по value) после которого будем делать вставку
                Node node = this.head;
                while (node != null) {
                    if (_nodeAfter.value == node.value) {

                        _nodeToInsert.prev = node;

                        // если вставка в самый конец
                        if (tail == node) {
                            _nodeToInsert.next = null;
                            node.next = _nodeToInsert;
                            tail = _nodeToInsert;

                        } else // если вставка в середину
                        {
                            _nodeToInsert.next = node.next;
                            node.next.prev = _nodeToInsert;
                            node.next = _nodeToInsert;
                        }

                        // чтобы прекратить поиск т.к. всё что надо сделали
                        node = null;
                        counter++;
                    } else {
                        // ищем дальше
                        node = node.next;
                    }
                }
            }
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

