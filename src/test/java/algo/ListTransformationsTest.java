package algo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListTransformationsTest {

    private static LinkedList ll1;
    private static LinkedList ll2;
    private static Node node_1;
    private static Node node_2;
    private static Node node_3;
    private static Node node_4;
    private static Node node_5;
    private static Node node_6;

    @Before
    public void setUp() {
        ll1 = new LinkedList();
        ll2 = new LinkedList();
        node_1 = new Node(1);
        node_2 = new Node(2);
        node_3 = new Node(3);
        node_4 = new Node(4);
        node_5 = new Node(5);
        node_6 = new Node(6);
    }

    @Test
    public void sumOfTwoLists_01() {
        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is(""));
    }

    @Test
    public void sumOfTwoLists_02() {
        ll1.addInTail(node_1);
        ll1.addInTail(node_2);

        ll2.addInTail(node_3);

        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is(""));
    }

    @Test
    public void sumOfTwoLists_03() {
        ll1.addInTail(node_1);
        ll1.addInTail(node_2);
        ll1.addInTail(node_3);

        ll2.addInTail(node_4);
        ll2.addInTail(node_5);
        ll2.addInTail(node_6);

        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is("5 7 9 "));
    }

    @Test
    public void sumOfTwoLists_04() {
        ll1.addInTail(node_3);
        ll1.addInTail(node_1);
        ll1.addInTail(node_2);

        ll2.addInTail(node_5);
        ll2.addInTail(node_4);
        ll2.addInTail(node_6);

        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is("8 5 8 "));
    }
}