package algo;

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
public class LinkedList {
    public Node1 head;
    public Node1 tail;

    private int counter;

    public LinkedList() {
        head = null;
        tail = null;
        counter = 0;
    }

    public void addInTail(Node1 node1) {
        if (this.head == null) { // случай когда список пуст
            this.head = node1;
        } else {
            // если список не пуст, то старый хвост будет указывать на новый айтем
            this.tail.next = node1;
        }   // а новым хвостом будет новый айтем
        this.tail = node1;
        counter++;
    }

    public Node1 find(int value) {
        // начинаем поиск с головы
        Node1 node1 = this.head;
        // пока не дойдём до конца списка
        while (node1 != null) {
            if (node1.value == value) {
                //  или пока не найдём и вернём искомое
                return node1;
            }
            node1 = node1.next;
        }
        // если не найдём - вернём налл
        return null;
    }

    // здесь будет ваш код удаления одного узла (первого попавшегося) по заданному значению

    public boolean remove(int _value) {
        // нужно знать предыдущий узел для перелинковки!

        // начинаем поиск удаляемого с головы
        Node1 node1 = this.head;
        // тут будем сохранять предыдущую ноду
        Node1 node1Previous = null;

        // ищем пока не дойдём до конца списка
        while (node1 != null) {
            //  или пока не найдём и осуществим удаление
            if (node1.value == _value) {
                deleteNode(node1, node1Previous);
                counter--;
                return true;
            }
            node1Previous = node1; // запоминаем уже проверенную ноду, для случая 3 и 4
            node1 = node1.next;    // берём следующую
        }
        // если не найдём - вернём налл
        return false;
    }

    // здесь будет ваш код удаления всех узлов по заданному значению
    public void removeAll(int _value) {
        // всё как в методе boolean remove(int _value) только при нахождении - не прекращаем поиск

        // начинаем поиск удаляемого с головы
        Node1 node1 = this.head;
        // тут будем сохранять предыдущую ноду
        Node1 node1Previous = null;

        // ищем пока не дойдём до конца списка
        while (node1 != null) {
            //  и даже если найдём - удалим и пойдём искать дальше!
            if (node1.value == _value) {
                deleteNode(node1, node1Previous);
                counter--;
                // nodePrevious - предыдущая осталась та же так как текущую то удалили!!
            } else {
                // предыдущей нодой становится уже проверенная нода (для случая 3 и 4)
                node1Previous = node1;
            }
            node1 = node1.next;    // берём следующую
        }
    }

    // здесь будет ваш код очистки всего списка
    public void clear() {
        head = null;
        tail = null;
        counter = 0;
    }

    // здесь будет ваш код поиска всех узлов
    public ArrayList<Node1> findAll(int _value) {
        ArrayList<Node1> node1s = new ArrayList<>();

        // тут как метод find(int value), только не прекращаем искать если найдём

        // начинаем поиск с головы
        Node1 node1 = this.head;

        // пока не дойдём до конца списка
        while (node1 != null) {
            if (node1.value == _value) {
                node1s.add(node1);
            }
            node1 = node1.next;
        }
        return node1s;
    }

    // здесь будет ваш код подсчёта количества элементов в списке
    public int count() {
        // тут каждый раз заного считает длину
        // ниже есть более продвинутый метод
        int counterSimple = 0;
        Node1 node1 = this.head;
        while (node1 != null) {
            counterSimple++;
            node1 = node1.next;
        }
        return counterSimple;
    }

    public int countPro() {
        return counter;
    }

    // здесь будет ваш код вставки узла после заданного
    // (после первого попавшегося подходящего по value)
    public void insertAfter(Node1 _node1After, Node1 _node1ToInsert) {

        // если вставка в пустой список
        if (_node1After == null && head == null) { // tail и так должен быть == null
            head = _node1ToInsert;
            tail = _node1ToInsert;
        } else
            // если вставка в самое начало
            if (_node1After == null) {
                _node1ToInsert.next = head;
                head = _node1ToInsert;
                counter++;
            } else {
                // если вставка НЕ в начало, то ищем узел (по value) после которого будем делать вставку
                Node1 node1 = this.head;
                while (node1 != null) {
                    if (_node1After.value == node1.value) {
                        // вставляем узел
                        _node1ToInsert.next = node1.next;
                        node1.next = _node1ToInsert;
                        counter++;
                        // если вставка в самый конец, то меняем tail
                        if (tail == node1) {
                            tail = _node1ToInsert;
                        }
                        // чтобы прекратить поиск
                        node1 = null;
                    } else {
                        node1 = node1.next;
                    }
                }
            }
    }

    // вспомогательный метод
    private void deleteNode(Node1 node1, Node1 node1Previous) {
        // случай 1 когда узел - единственный
        // === меняем в налл ссылки головы и хвоста
        if (node1 == head && node1 == tail) {
            head = null;
            tail = null;
        } else {
            // случай 2 когда узел - первый
            // === голова будет ссылаться на след узел
            if (node1 == head) {
                head = node1.next;
            } else {
                // случай 3 когда узел - последний
                // === хвост будет ссылаться на предыдущий узел, а предыдущий ссылаться на налл
                if (node1 == tail) {
                    tail = node1Previous;
                    node1Previous.next = null;
                } else {
                    // случай 4 когда узел - посреди других узлов
                    // === предыдущая нода ссылается на следующую минуя текущую
                    node1Previous.next = node1.next;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node1 node1 = this.head;
        while (node1 != null) {
            sb.append(node1.value).append(" ");
            node1 = node1.next;
        }
        return sb.toString();
    }
}

// убрать 1 из имени чтобы сервер принял
class Node1 {
    public int value;
    public Node1 next;

    public Node1(int _value) {
        value = _value;
        next = null;
    }
}