package algo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListTransformationsTest {

    private static LinkedList ll1;
    private static LinkedList ll2;
    private static Node1 node_1_1;
    private static Node1 node_1_2;
    private static Node1 node_1_3;
    private static Node1 node_1_4;
    private static Node1 node_1_5;
    private static Node1 node_1_6;

    @Before
    public void setUp() {
        ll1 = new LinkedList();
        ll2 = new LinkedList();
        node_1_1 = new Node1(1);
        node_1_2 = new Node1(2);
        node_1_3 = new Node1(3);
        node_1_4 = new Node1(4);
        node_1_5 = new Node1(5);
        node_1_6 = new Node1(6);
    }

    @Test
    public void sumOfTwoLists_01() {
        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is(""));
    }

    @Test
    public void sumOfTwoLists_02() {
        ll1.addInTail(node_1_1);
        ll1.addInTail(node_1_2);

        ll2.addInTail(node_1_3);

        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is(""));
    }

    @Test
    public void sumOfTwoLists_03() {
        ll1.addInTail(node_1_1);
        ll1.addInTail(node_1_2);
        ll1.addInTail(node_1_3);

        ll2.addInTail(node_1_4);
        ll2.addInTail(node_1_5);
        ll2.addInTail(node_1_6);

        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is("5 7 9 "));
    }

    @Test
    public void sumOfTwoLists_04() {
        ll1.addInTail(node_1_3);
        ll1.addInTail(node_1_1);
        ll1.addInTail(node_1_2);

        ll2.addInTail(node_1_5);
        ll2.addInTail(node_1_4);
        ll2.addInTail(node_1_6);

        LinkedList listResult = ListTransformations.sumOfTwoLists(ll1, ll2);

        assertThat(listResult.toString(), is("8 5 8 "));
    }
}