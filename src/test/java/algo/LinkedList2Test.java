package algo;

import algo.linkedList2.LinkedList2;
import algo.linkedList2.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkedList2Test {

    private static LinkedList2 ll2;

    private static Node node_3;
    private static Node node_10_1;
    private static Node node_10_2;
    private static Node node_10_3;
    private static Node node_11;
    private static Node node_666;


    @Before
    public void setUp() {
        ll2 = new LinkedList2();

        node_3 = new Node(3);
        node_10_1 = new Node(10);
        node_10_2 = new Node(10);
        node_10_3 = new Node(10);
        node_11 = new Node(11);
        node_666 = new Node(666);
    }

    @Test
    public void addInTail_01() {
        ll2.addInTail(node_3);
        assertThat(ll2.toString(), is("3 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(1));

    }

    @Test
    public void addInTail_02() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        assertThat(ll2.toString(), is("3 10 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_10_1));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void addInTail_03() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_11);
        assertThat(ll2.toString(), is("3 10 11 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void addInTail_04() {
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.head, nullValue());
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void find_01() {
        assertThat(ll2.find(3), nullValue());
    }

    @Test
    public void find_02() {
        ll2.addInTail(node_3);
        assertThat(ll2.find(3).value, is(3));
    }

    @Test
    public void find_02_2() {
        ll2.addInTail(node_11);
        assertThat(ll2.find(3), nullValue());
    }

    @Test
    public void find_03() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_666);
        assertThat(ll2.find(3).value, is(3));
    }

    @Test
    public void find_04() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        assertThat(ll2.find(3).value, is(3));
    }

    @Test
    public void find_05() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_666);
        ll2.addInTail(node_3);
        assertThat(ll2.find(3).value, is(3));
    }

    @Test
    public void find_06() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_3);
        Node result = ll2.find(10);
        assertThat(result.value, is(10));

        assertThat(result.prev, nullValue());
        assertThat(result.next, is(node_10_2));
    }

    @Test
    public void find_07() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        Node result = ll2.find(10);
        assertThat(result.value, is(10));

        assertThat(result.prev, is(node_3));
        assertThat(result.next, is(node_10_2));
    }

    @Test
    public void findAll_01() {
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(0));
    }

    @Test
    public void findAll_02() {
        ll2.addInTail(node_11);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(0));
    }

    @Test
    public void findAll_03() {
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(0));
    }

    @Test
    public void findAll_04() {
        ll2.addInTail(node_10_1);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(1));
        Node node = result.get(0);
        assertThat(node.value, is(10));
        assertThat(node.next, nullValue());
        assertThat(node.prev, nullValue());
    }

    @Test
    public void findAll_05() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(1));
        Node node = result.get(0);
        assertThat(node.value, is(10));
        assertThat(node.next, is(node_3));
        assertThat(node.prev, nullValue());
    }

    @Test
    public void findAll_06() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_666);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(1));
        Node node = result.get(0);
        assertThat(node.value, is(10));
        assertThat(node.next, is(node_666));
        assertThat(node.prev, is(node_3));
    }

    @Test
    public void findAll_07() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ll2.addInTail(node_10_1);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(1));
        Node node = result.get(0);
        assertThat(node.value, is(10));
        assertThat(node.next, nullValue());
        assertThat(node.prev, is(node_666));
    }

    @Test
    public void findAll_08() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(2));

        Node node1 = result.get(0);
        assertThat(node1.value, is(10));
        assertThat(node1.next, is(node_10_2));
        assertThat(node1.prev, nullValue());

        Node node2 = result.get(1);
        assertThat(node2.value, is(10));
        assertThat(node2.next, is(node_3));
        assertThat(node2.prev, is(node_10_1));
    }

    @Test
    public void findAll_09() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ll2.addInTail(node_10_2);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(2));

        Node node1 = result.get(0);
        assertThat(node1.value, is(10));
        assertThat(node1.next, is(node_3));
        assertThat(node1.prev, nullValue());

        Node node2 = result.get(1);
        assertThat(node2.value, is(10));
        assertThat(node2.next, nullValue());
        assertThat(node2.prev, is(node_666));
    }

    @Test
    public void findAll_10() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);
        ArrayList<Node> result = ll2.findAll(10);
        assertThat(result.size(), is(3));

        Node node1 = result.get(0);
        assertThat(node1.value, is(10));
        assertThat(node1.next, is(node_10_2));
        assertThat(node1.prev, nullValue());

        Node node2 = result.get(1);
        assertThat(node2.value, is(10));
        assertThat(node2.next, is(node_10_3));
        assertThat(node2.prev, is(node_10_1));

        Node node3 = result.get(2);
        assertThat(node3.value, is(10));
        assertThat(node3.next, nullValue());
        assertThat(node3.prev, is(node_10_2));
    }

    @Test
    public void remove_01() {
        ll2.addInTail(node_3);
        assertThat(ll2.remove(3), is(true));
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.head, nullValue());
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void remove_02() {
        assertThat(ll2.remove(3), is(false));
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.head, nullValue());
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void remove_03() {
        ll2.addInTail(node_11);
        assertThat(ll2.remove(3), is(false));
        assertThat(ll2.toString(), is("11 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(1));
    }

    @Test
    public void remove_04() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        assertThat(ll2.remove(3), is(true));
        assertThat(ll2.toString(), is("11 666 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_666));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void remove_05() {
        ll2.addInTail(node_11);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        assertThat(ll2.remove(3), is(true));
        assertThat(ll2.toString(), is("11 666 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_666));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void remove_06() {
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ll2.addInTail(node_3);
        assertThat(ll2.remove(3), is(true));
        assertThat(ll2.toString(), is("11 666 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_666));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void remove_07() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);
        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.toString(), is("10 10 "));
        assertThat(ll2.head, is(node_10_2));
        assertThat(ll2.tail, is(node_10_3));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void remove_08() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_11);
        ll2.addInTail(node_10_3);
        ll2.addInTail(node_666);

        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.remove(10), is(false));
        assertThat(ll2.toString(), is("3 11 666 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_666));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void remove_09() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ll2.addInTail(node_11);
        ll2.addInTail(node_10_3);

        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.remove(10), is(true));
        assertThat(ll2.remove(10), is(false));
        assertThat(ll2.toString(), is("3 666 11 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void removeAll_01() {
        ll2.addInTail(node_3);
        ll2.removeAll(3);
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.head, nullValue());
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void removeAll_02() {
        ll2.removeAll(3);
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.head, nullValue());
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void removeAll_03() {
        ll2.addInTail(node_11);
        ll2.removeAll(3);
        assertThat(ll2.toString(), is("11 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(1));
    }

    @Test
    public void removeAll_04() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ll2.removeAll(3);
        assertThat(ll2.toString(), is("11 666 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_666));
        assertThat(ll2.count(), is(2));
    }

        @Test
        public void removeAll_05() {
            ll2.addInTail(node_11);
            ll2.addInTail(node_3);
            ll2.addInTail(node_666);
            ll2.removeAll(3);
            assertThat(ll2.toString(), is("11 666 "));
            assertThat(ll2.head, is(node_11));
            assertThat(ll2.tail, is(node_666));
            assertThat(ll2.count(), is(2));
        }

        @Test
        public void removeAll_06() {
            ll2.addInTail(node_11);
            ll2.addInTail(node_666);
            ll2.addInTail(node_3);
            ll2.removeAll(3);
            assertThat(ll2.toString(), is("11 666 "));
            assertThat(ll2.head, is(node_11));
            assertThat(ll2.tail, is(node_666));
            assertThat(ll2.count(), is(2));
        }

        @Test
        public void removeAll_07() {
            ll2.addInTail(node_10_1);
            ll2.addInTail(node_10_2);
            ll2.addInTail(node_10_3);
            ll2.removeAll(10);
            assertThat(ll2.toString(), is(""));
            assertThat(ll2.head, nullValue());
            assertThat(ll2.tail, nullValue());
            assertThat(ll2.count(), is(0));
        }

        @Test
        public void removeAll_08() {
            ll2.addInTail(node_10_1);
            ll2.addInTail(node_3);
            ll2.addInTail(node_10_2);
            ll2.addInTail(node_11);
            ll2.addInTail(node_10_3);
            ll2.addInTail(node_666);
            ll2.removeAll(10);
            assertThat(ll2.toString(), is("3 11 666 "));
            assertThat(ll2.head, is(node_3));
            assertThat(ll2.tail, is(node_666));
            assertThat(ll2.count(), is(3));
        }

        @Test
        public void removeAll_09() {
            ll2.addInTail(node_10_1);
            ll2.addInTail(node_10_2);
            ll2.addInTail(node_3);
            ll2.addInTail(node_666);
            ll2.addInTail(node_11);
            ll2.addInTail(node_10_3);

            ll2.removeAll(10);
            assertThat(ll2.toString(), is("3 666 11 "));
            assertThat(ll2.head, is(node_3));
            assertThat(ll2.tail, is(node_11));
            assertThat(ll2.count(), is(3));
        }

    @Test
    public void removeAll_10() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ll2.addInTail(node_11);

        ll2.removeAll(10);
        assertThat(ll2.toString(), is("3 666 11 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void removeAll_11() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_666);
        ll2.addInTail(node_11);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);

        ll2.removeAll(10);
        assertThat(ll2.toString(), is("3 666 11 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void removeAll_12() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);
        ll2.addInTail(node_666);
        ll2.addInTail(node_11);

        ll2.removeAll(10);
        assertThat(ll2.toString(), is("3 666 11 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void removeAll_13() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ll2.removeAll(10);
        assertThat(ll2.toString(), is("3 11 666 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_666));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void clear_01() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ll2.clear();
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void clear_02() {
        ll2.clear();
        assertThat(ll2.toString(), is(""));
        assertThat(ll2.tail, nullValue());
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void count_01() {
        ll2.addInTail(node_3);
        assertThat(ll2.count(), is(1));
    }

    @Test
    public void count_02() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_666);
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void count_03() {
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void count_04() {
        ll2.addInTail(node_3);
        ll2.remove(3);
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void count_05() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);
        ll2.remove(10);
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void count_06() {
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_10_2);
        ll2.addInTail(node_10_3);
        ll2.removeAll(10);
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void count_07() {
        ll2.addInTail(node_3);
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ll2.clear();
        assertThat(ll2.count(), is(0));
    }

    @Test
    public void insertAfter_01() {
        ll2.insertAfter(null, node_3);
        assertThat(ll2.toString(), is("3 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(1));
    }

    @Test
    public void insertAfter_02() {
        ll2.addInTail(node_11);
        ll2.insertAfter(null, node_3);
        assertThat(ll2.toString(), is("3 11 "));
        assertThat(ll2.head, is(node_3));
        assertThat(ll2.tail, is(node_11));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void insertAfter_03() {
        ll2.addInTail(node_11);
        ll2.insertAfter(node_11, node_3);
        assertThat(ll2.toString(), is("11 3 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void insertAfter_04() {
        ll2.addInTail(node_11);
        ll2.addInTail(node_666);
        ll2.addInTail(node_10_1);

        ll2.insertAfter(node_11, node_3);
        assertThat(ll2.toString(), is("11 3 666 10 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_10_1));
        assertThat(ll2.count(), is(4));
    }

    @Test
    public void insertAfter_05() {
        ll2.addInTail(node_666);
        ll2.addInTail(node_11);
        ll2.addInTail(node_10_1);

        ll2.insertAfter(node_11, node_3);
        assertThat(ll2.toString(), is("666 11 3 10 "));
        assertThat(ll2.head, is(node_666));
        assertThat(ll2.tail, is(node_10_1));
        assertThat(ll2.count(), is(4));
    }

    @Test
    public void insertAfter_06() {
        ll2.addInTail(node_666);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_11);

        ll2.insertAfter(node_11, node_3);
        assertThat(ll2.toString(), is("666 10 11 3 "));
        assertThat(ll2.head, is(node_666));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(4));
    }

    @Test
    public void insertAfter_07() {
        ll2.insertAfter(null, node_3);
        ll2.insertAfter(null, node_666);

        assertThat(ll2.toString(), is("666 3 "));
        assertThat(ll2.head, is(node_666));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(2));
    }

    @Test
    public void insertAfter_08() {
        ll2.insertAfter(null, node_3);
        ll2.insertAfter(null, node_666);
        ll2.insertAfter(null, node_11);

        assertThat(ll2.toString(), is("11 666 3 "));
        assertThat(ll2.head, is(node_11));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void insertAfter_09() {
        ll2.insertAfter(null, node_11);
        ll2.insertAfter(node_11, node_3);
        ll2.insertAfter(null, node_10_1);

        assertThat(ll2.toString(), is("10 11 3 "));
        assertThat(ll2.head, is(node_10_1));
        assertThat(ll2.tail, is(node_3));
        assertThat(ll2.count(), is(3));
    }

    @Test
    public void insertAfter_10() {
        ll2.insertAfter(node_3, node_11);
        ll2.insertAfter(node_11, node_3);
        ll2.insertAfter(null, node_10_1);

        assertThat(ll2.toString(), is("10 "));
        assertThat(ll2.head, is(node_10_1));
        assertThat(ll2.tail, is(node_10_1));
        assertThat(ll2.count(), is(1));
    }

    @Test
    public void insertAfter_11() {
        ll2.addInTail(node_666);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_11);
        ll2.addInTail(node_10_2);

        ll2.insertAfter(node_10_1, node_3);

        assertThat(ll2.toString(), is("666 10 3 11 10 "));
        assertThat(ll2.head, is(node_666));
        assertThat(ll2.tail, is(node_10_2));
        assertThat(ll2.count(), is(5));
    }

    @Test
    public void insertAfter_12() {
        ll2.addInTail(node_666);
        ll2.addInTail(node_10_1);
        ll2.addInTail(node_11);
        ll2.addInTail(node_10_2);

        ll2.insertAfter(node_10_2, node_3);

        assertThat(ll2.toString(), is("666 10 3 11 10 "));
        assertThat(ll2.head, is(node_666));
        assertThat(ll2.tail, is(node_10_2));
        assertThat(ll2.count(), is(5));
    }
}