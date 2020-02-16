package algo;

public class ListTransformations {

    public static LinkedList sumOfTwoLists(LinkedList list1, LinkedList list2) {

        // если длины равны то...
        if (list1.count() == list2.count()) {

            LinkedList listResult = new LinkedList();

            Node1 node1 = list1.head;
            Node1 node12 = list2.head;

            while (node1 != null) {
                listResult.addInTail(new Node1(node1.value + node12.value));
                node1 = node1.next;
                node12 = node12.next;
            }
            return listResult;
        }
        // если длины не равны то возвращаем пустой список
        return new LinkedList();
    }
}
