package algo.linkedList;

public class ListTransformations {

    public static LinkedList<Integer> sumOfTwoLists(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        // если длины равны то...
        if (list1.count() == list2.count()) {

            LinkedList<Integer> listResult = new LinkedList<>();

            Node<Integer> node1 = list1.head;
            Node<Integer> node2 = list2.head;

            while (node1 != null) {
                listResult.addInTail(new Node<>(node1.value + node2.value));
                node1 = node1.next;
                node2 = node2.next;
            }
            return listResult;
        }
        // если длины не равны то возвращаем пустой список
        return new LinkedList<>();
    }
}
