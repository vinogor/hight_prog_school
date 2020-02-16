package algo;

import java.util.*;

// ==== Задания ====
// 1. Добавьте в класс LinkedList2 метод поиска первого узла по его значению.
// 2. Добавьте в класс LinkedList2 метод поиска всех узлов по конкретному значению (возвращается список/массив найденных узлов).
// 3. Добавьте в класс LinkedList2 метод удаления одного узла по его значению.
// 4. Добавьте в класс LinkedList2 метод удаления всех узлов по конкретному значению.
// 5. Добавьте в класс LinkedList2 метод вставки узла после заданного узла.
// 6. Добавьте в класс LinkedList2 метод вставки узла самым первым элементом.
// 7. Добавьте в класс LinkedList2 метод очистки всего содержимого (создание пустого списка).
// 8. Напишите проверочные тесты для каждого из предыдущих заданий.
//
// ==== Рекомендации по тестированию ====
// Проверяйте случаи, когда список пустой, содержит много элементов и один элемент:
// как в таких ситуациях будет работать удаление, вставка, поиск.
// Особое внимание уделите корректности полей head и tail после всех этих операций,
// а также связь в обратную сторону prev.

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value)
    {
        // здесь будет ваш код поиска
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        // здесь будет ваш код поиска всех узлов по заданному значению
        return nodes;
    }

    public boolean remove(int _value)
    {
        // здесь будет ваш код удаления одного узла по заданному значению
        return true; // если узел был удалён
    }

    public void removeAll(int _value)
    {
        // здесь будет ваш код удаления всех узлов по заданному значению
    }

    public void clear()
    {
        // здесь будет ваш код очистки всего списка
    }

    public int count()
    {
        return 0; // здесь будет ваш код подсчёта количества элементов в списке
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        // здесь будет ваш код вставки узла после заданного узла

        // если _nodeAfter = null
        // добавьте новый элемент первым в списке
    }
}

class Node
{
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}