package algo;

import java.util.*;

// Пункты, помеченные * сделайте отдельно.
//
// + 1. Добавьте в класс LinkedList метод удаления одного узла по его значению.
// + 2. Добавьте в класс LinkedList метод удаления всех узлов по конкретному значению.
// + 3. Добавьте в класс LinkedList метод очистки всего содержимого (создание пустого списка).
// 4. Добавьте в класс LinkedList метод поиска всех узлов по конкретному значению
//      (возвращается список/массив найденных узлов).
// 5. Добавьте в класс LinkedList метод вычисления длины списка.
// 6. Добавьте в класс LinkedList метод вставки узла после заданного узла.
// ++ * 7. Напишите проверочные тесты для каждого из предыдущих заданий.
//
//* 8. Напишите функцию, которая получает на вход два связанных списка, состоящие из целых значений,
// и если их длины равны, возвращает список, каждый элемент которого равен сумме соответствующих элементов входных списков.
// Рекомендации по тестированию.
// Проверяйте случаи, когда список пустой, содержит много элементов и один элемент: как в таких ситуациях
// будет работать удаление одного и нескольких элементов, вставка, поиск. Особое внимание уделите корректности
// полей head и tail после всех этих операций.

// однонаправленный!!!
public class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) { // случай когда список пуст
            this.head = item;
        } else {
            // если список не пуст, то старый хвост будет указывать на новый айтем
            this.tail.next = item;
        }   // а новым хвостом будет новый айтем
        this.tail = item;
    }

    public Node find(int value) {
        // начинаем поиск с головы
        Node node = this.head;
        // пока не дойдём до конца списка
        while (node != null) {
            if (node.value == value) {
                //  или пока не найдём и вернём искомое
                return node;
            }
            node = node.next;
        }
        // если не найдём - вернём налл
        return null;
    }

    // здесь будет ваш код удаления одного узла (первого попавшегося) по заданному значению

    public boolean remove(int _value) {
        // нужно знать предыдущий узел для перелинковки!

        // начинаем поиск удаляемого с головы
        Node node = this.head;
        // тут будем сохранять предыдущую ноду
        Node nodePrevious = null;

        // ищем пока не дойдём до конца списка
        while (node != null) {
            //  или пока не найдём и осуществим удаление
            if (node.value == _value) {
                deleteNode(node, nodePrevious);
                return true;
            }
            nodePrevious = node; // запоминаем уже проверенную ноду, для случая 3 и 4
            node = node.next;    // берём следующую
        }
        // если не найдём - вернём налл
        return false;
    }
    // здесь будет ваш код удаления всех узлов по заданному значению

    public void removeAll(int _value) {
        // всё как в методе boolean remove(int _value) только при нахождении - не прекращаем поиск

        // начинаем поиск удаляемого с головы
        Node node = this.head;
        // тут будем сохранять предыдущую ноду
        Node nodePrevious = null;

        // ищем пока не дойдём до конца списка
        while (node != null) {
            //  и даже если найдём - удалим и пойдём искать дальше!
            if (node.value == _value) {
                deleteNode(node, nodePrevious);
            }
            nodePrevious = node; // запоминаем уже проверенную ноду, для случая 3 и 4
            node = node.next;    // берём следующую
        }
    }

    // здесь будет ваш код очистки всего списка
    public void clear() {
        head = null;
        tail = null;
    }

    // здесь будет ваш код поиска всех узлов
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
    public int count() {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        // здесь будет ваш код вставки узла после заданного

        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
    }

    private void deleteNode(Node node, Node nodePrevious) {
        // случай 1 когда узел - единственный
        // === меняем в налл ссылки головы и хвоста
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else {
            // случай 2 когда узел - первый
            // === голова будет ссылаться на след узел
            if (node == head) {
                head = node.next;
            } else {
                // случай 3 когда узел - последний
                // === хвост будет ссылаться на предыдущий узел, а предыдущий ссылаться на налл
                if (node == tail) {
                    tail = nodePrevious;
                    nodePrevious.next = null;
                } else {
                    // случай 4 когда узел - посреди других узлов
                    // === предыдущая нода ссылается на следующую минуя текущую
                    nodePrevious.next = node.next;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node node = this.head;
        while (node != null) {
            sb.append(node.value).append(" ");
            node = node.next;
        }
        return sb.toString();
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}