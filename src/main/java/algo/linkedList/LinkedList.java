package algo.linkedList;

import java.util.*;

// Пункты, помеченные * сделайте отдельно.
//
// + 1. Добавьте в класс LinkedList метод удаления одного узла по его значению.
// + 2. Добавьте в класс LinkedList метод удаления всех узлов по конкретному значению.
// + 3. Добавьте в класс LinkedList метод очистки всего содержимого (создание пустого списка).
// + 4. Добавьте в класс LinkedList метод поиска всех узлов по конкретному значению
//      (возвращается список/массив найденных узлов).
// + 5. Добавьте в класс LinkedList метод вычисления длины списка.
// + 6. Добавьте в класс LinkedList метод вставки узла после заданного узла.
// ++ * 7. Напишите проверочные тесты для каждого из предыдущих заданий.
//
// +  * 8. Напишите функцию, которая получает на вход два связанных списка, состоящие из целых значений,
// и если их длины равны, возвращает список, каждый элемент которого равен сумме соответствующих элементов входных списков.
//
//  Рекомендации по тестированию.
// Проверяйте случаи, когда список пустой, содержит много элементов и один элемент: как в таких ситуациях
// будет работать удаление одного и нескольких элементов, вставка, поиск. Особое внимание уделите корректности
// полей head и tail после всех этих операций.

// однонаправленный!!!
public class LinkedList<T> {
    public Node<T> head;
    public Node<T> tail;

    private int counter;

    public LinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    public void addInTail(Node<T> node) {
        if (this.head == null) { // случай когда список пуст
            this.head = node;
        } else {
            // если список не пуст, то старый хвост будет указывать на новый айтем
            this.tail.next = node;
        }   // а новым хвостом будет новый айтем
        this.tail = node;
        counter++;
    }

    public Node<T> find(T value) {
        // начинаем поиск с головы
        Node<T> node = this.head;
        // пока не дойдём до конца списка
        while (node != null) {
            if (node.value.equals(value)) {
                //  или пока не найдём и вернём искомое
                return node;
            }
            node = node.next;
        }
        // если не найдём - вернём налл
        return null;
    }

    // здесь будет ваш код удаления одного узла (первого попавшегося) по заданному значению

    public boolean remove(T _value) {
        // нужно знать предыдущий узел для перелинковки!

        // начинаем поиск удаляемого с головы
        Node<T> node = this.head;
        // тут будем сохранять предыдущую ноду
        Node<T> nodePrevious = null;

        // ищем пока не дойдём до конца списка
        while (node != null) {
            //  или пока не найдём и осуществим удаление
            if (node.value.equals(_value)) {
                deleteNode(node, nodePrevious);
                counter--;
                return true;
            }
            nodePrevious = node; // запоминаем уже проверенную ноду, для случая 3 и 4
            node = node.next;    // берём следующую
        }
        // если не найдём - вернём налл
        return false;
    }

    // здесь будет ваш код удаления всех узлов по заданному значению
    public void removeAll(T _value) {
        // всё как в методе boolean remove(int _value) только при нахождении - не прекращаем поиск

        // начинаем поиск удаляемого с головы
        Node<T> node = this.head;
        // тут будем сохранять предыдущую ноду
        Node<T> nodePrevious = null;

        // ищем пока не дойдём до конца списка
        while (node != null) {
            //  и даже если найдём - удалим и пойдём искать дальше!
            if (node.value.equals(_value)) {
                deleteNode(node, nodePrevious);
                counter--;
                // nodePrevious - предыдущая осталась та же так как текущую то удалили!!
            } else {
                // предыдущей нодой становится уже проверенная нода (для случая 3 и 4)
                nodePrevious = node;
            }
            node = node.next;    // берём следующую
        }
    }

    // здесь будет ваш код очистки всего списка
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    // здесь будет ваш код поиска всех узлов
    public ArrayList<Node<T>> findAll(T _value) {
        ArrayList<Node<T>> nodes = new ArrayList<>();

        // тут как метод find(int value), только не прекращаем искать если найдём

        // начинаем поиск с головы
        Node<T> node = this.head;

        // пока не дойдём до конца списка
        while (node != null) {
            if (node.value.equals(_value)) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    // здесь будет ваш код подсчёта количества элементов в списке
    public int count() {
        // тут каждый раз заного считает длину
        // ниже есть более продвинутый метод
        int counterSimple = 0;
        Node<T> node = this.head;
        while (node != null) {
            counterSimple++;
            node = node.next;
        }
        return counterSimple;
    }

    public int countPro() {
        return counter;
    }

    // здесь будет ваш код вставки узла после заданного
    // (после первого попавшегося подходящего по value)
    public void insertAfter(Node<T> _nodeAfter, Node<T> _nodeToInsert) {

        // если вставка в пустой список
        if (_nodeAfter == null && head == null) { // tail и так должен быть == null
            head = _nodeToInsert;
            tail = _nodeToInsert;
        } else
            // если вставка в самое начало
            if (_nodeAfter == null) {
                _nodeToInsert.next = head;
                head = _nodeToInsert;
                counter++;
            } else {
                // если вставка НЕ в начало, то ищем узел (по value) после которого будем делать вставку
                Node<T> node = this.head;
                while (node != null) {
                    if (_nodeAfter.value.equals(node.value)) {
                        // вставляем узел
                        _nodeToInsert.next = node.next;
                        node.next = _nodeToInsert;
                        counter++;
                        // если вставка в самый конец, то меняем tail
                        if (tail == node) {
                            tail = _nodeToInsert;
                        }
                        // чтобы прекратить поиск
                        node = null;
                    } else {
                        node = node.next;
                    }
                }
            }
    }

    // вспомогательный метод
    private void deleteNode(Node<T> node, Node<T> nodePrevious) {
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
        StringBuilder sb = new StringBuilder();
        Node<T> node = this.head;
        while (node != null) {
            sb.append(node.value).append(" ");
            node = node.next;
        }
        return sb.toString();
    }
}

