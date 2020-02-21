package algo.linkedList;

public class ListTransformations {

    public static LinkedList sumOfTwoLists(LinkedList list1, LinkedList list2) {

        // если длины равны то...
        if (list1.count() == list2.count()) {

            LinkedList listResult = new LinkedList();

            Node node1 = list1.head;
            Node node2 = list2.head;

            while (node1 != null) {
                listResult.addInTail(new Node(node1.value + node2.value));
                node1 = node1.next;
                node2 = node2.next;
            }
            return listResult;
        }
        // если длины не равны то возвращаем пустой список
        return new LinkedList();
    }
}
