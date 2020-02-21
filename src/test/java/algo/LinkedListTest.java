package algo;

import algo.linkedList.LinkedList;
import algo.linkedList.Node;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkedListTest {

    private static LinkedList<Integer> ll;

    private static Node<Integer> node_3;
    private static Node<Integer> node_10_1;
    private static Node<Integer> node_10_2;
    private static Node<Integer> node_10_3;
    private static Node<Integer> node_11;
    private static Node<Integer> node_666;

    @Before
    public void setUp() {
        ll = new LinkedList<>();

        node_3 = new Node<>(3);
        node_10_1 = new Node<>(10);
        node_10_2 = new Node<>(10);
        node_10_3 = new Node<>(10);
        node_11 = new Node<>(11);
        node_666 = new Node<>(666);
    }

    @Test
    public void addInTail_01() {
        ll.addInTail(node_3);
        assertThat(ll.toString(), is("3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void addInTail_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        assertThat(ll.toString(), is("3 10 "));
        assertThat(ll.tail, is(node_10_1));
    }

    @Test
    public void addInTail_03() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        assertThat(ll.toString(), is("3 10 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void addInTail_04() {
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void find_01() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        assertThat(ll.find(3).value, is(3));
    }

    @Test
    public void find_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        assertThat(ll.find(0), is(nullValue()));
    }

    @Test
    public void find_03() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        assertThat(ll.find(10).value, is(10));
    }

    @Test
    public void find_04() {
        assertThat(ll.find(0), is(nullValue()));
    }

    @Test
    public void remove_01() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        assertThat(ll.remove(3), is(true));
        assertThat(ll.toString(), is("10 11 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void remove_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        assertThat(ll.remove(666), is(true));
        assertThat(ll.toString(), is("3 10 11 "));
        assertThat(ll.tail, is(node_11));
    }

    @Test
    public void remove_03() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        assertThat(ll.remove(11), is(true));
        assertThat(ll.toString(), is("3 10 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void remove_04() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.addInTail(node_10_2);
        assertThat(ll.remove(10), is(true));
        assertThat(ll.toString(), is("3 11 666 10 "));
        assertThat(ll.tail, is(node_10_2));
    }

    @Test
    public void remove_05() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        assertThat(ll.remove(1), is(false));
        assertThat(ll.toString(), is("3 10 11 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void remove_06() {
        assertThat(ll.remove(1), is(false));
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void remove_07() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.addInTail(node_10_2);
        assertThat(ll.remove(10), is(true));
        assertThat(ll.remove(10), is(true));
        assertThat(ll.toString(), is("3 11 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void removeAll_01() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_3);
        ll.addInTail(node_666);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void removeAll_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void removeAll_03() {
        ll.addInTail(node_3);
        ll.addInTail(node_666);
        ll.addInTail(node_10_1);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void removeAll_04() {
        ll.addInTail(node_10_1);
        ll.removeAll(10);
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void removeAll_05() {
        ll.removeAll(10);
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void removeAll_06() {
        ll.addInTail(node_10_1);
        ll.removeAll(11);
        assertThat(ll.toString(), is("10 "));
        assertThat(ll.tail, is(node_10_1));
    }

    @Test
    public void removeAll_07() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_3);
        ll.addInTail(node_10_2);
        ll.addInTail(node_666);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void removeAll_08() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void removeAll_09() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.removeAll(3);
        assertThat(ll.toString(), is("10 11 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void removeAll_10() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void removeAll_11() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_3);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void removeAll_12() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_3);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void removeAll_13() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.addInTail(node_3);
        ll.removeAll(10);
        assertThat(ll.toString(), is("3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void clear_01() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.clear();
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void clear_02() {
        ll.clear();
        assertThat(ll.toString(), is(""));
        assertThat(ll.tail, nullValue());
    }

    @Test
    public void findAll_01() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);

        ArrayList<Node<Integer>> result = ll.findAll(10);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(0).next, is(node_11));
    }

    @Test
    public void findAll_02() {
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.addInTail(node_10_1);

        ArrayList<Node<Integer>> result = ll.findAll(10);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(0).next, nullValue());
    }

    @Test
    public void findAll_03() {
        ll.addInTail(node_666);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);

        ArrayList<Node<Integer>> result = ll.findAll(10);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(0).next, is(node_11));
    }

    @Test
    public void findAll_04() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_11);
        ll.addInTail(node_666);

        ArrayList<Node<Integer>> result = ll.findAll(10);

        assertThat(result.size(), is(2));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(1).value, is(10));
        assertThat(result.get(0).next, is(node_10_2));
        assertThat(result.get(1).next, is(node_11));
    }

    @Test
    public void findAll_05() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_10_2);
        ll.addInTail(node_666);
        ll.addInTail(node_10_3);

        ArrayList<Node<Integer>> result = ll.findAll(10);

        assertThat(result.size(), is(3));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(1).value, is(10));
        assertThat(result.get(2).value, is(10));
        assertThat(result.get(0).next, is(node_11));
        assertThat(result.get(1).next, is(node_666));
        assertThat(result.get(2).next, nullValue());
    }

    @Test
    public void findAll_06() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);

        ArrayList<Node<Integer>> result = ll.findAll(10);

        assertThat(result.size(), is(3));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(1).value, is(10));
        assertThat(result.get(2).value, is(10));
        assertThat(result.get(0).next, is(node_10_2));
        assertThat(result.get(1).next, is(node_10_3));
        assertThat(result.get(2).next, nullValue());
    }

    @Test
    public void count_01() {
        ll.addInTail(node_3);
        assertThat(ll.count(), is(1));
    }

    @Test
    public void count_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        assertThat(ll.count(), is(3));
    }

    @Test
    public void count_03() {
        assertThat(ll.count(), is(0));
    }

    @Test
    public void count_04() {
        ll.addInTail(node_3);
        ll.remove(3);
        assertThat(ll.count(), is(0));
    }

    @Test
    public void count_05() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.remove(10);
        assertThat(ll.count(), is(2));
    }

    @Test
    public void count_06() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.count(), is(0));
    }

    @Test
    public void count_07() {
        ll.addInTail(node_3);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.clear();
        assertThat(ll.count(), is(0));
    }

    @Test
    public void countPro_01() {
        ll.addInTail(node_3);
        assertThat(ll.countPro(), is(1));
    }

    @Test
    public void countPro_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        assertThat(ll.countPro(), is(3));
    }

    @Test
    public void countPro_03() {
        assertThat(ll.countPro(), is(0));
    }

    @Test
    public void countPro_04() {
        ll.addInTail(node_3);
        ll.remove(3);
        assertThat(ll.countPro(), is(0));
    }

    @Test
    public void countPro_05() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.remove(10);
        assertThat(ll.countPro(), is(2));
    }

    @Test
    public void countPro_06() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_10_2);
        ll.addInTail(node_10_3);
        ll.removeAll(10);
        assertThat(ll.countPro(), is(0));
    }

    @Test
    public void countPro_07() {
        ll.addInTail(node_3);
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.clear();
        assertThat(ll.countPro(), is(0));
    }

    @Test
    public void insertAfter_01() {
        ll.addInTail(node_3);
        ll.addInTail(node_11);
        ll.addInTail(node_666);

        ll.insertAfter(node_3, node_10_1);

        assertThat(ll.toString(), is("3 10 11 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void insertAfter_02() {
        ll.addInTail(node_3);
        ll.addInTail(node_11);
        ll.addInTail(node_666);

        ll.insertAfter(node_666, node_10_1);

        assertThat(ll.toString(), is("3 11 666 10 "));
        assertThat(ll.tail, is(node_10_1));
    }


    @Test
    public void insertAfter_03() {
        ll.addInTail(node_3);
        ll.addInTail(node_11);
        ll.addInTail(node_666);

        ll.insertAfter(null, node_10_1);

        assertThat(ll.toString(), is("10 3 11 666 "));
        assertThat(ll.tail, is(node_666));
    }

    @Test
    public void insertAfter_04() {
        ll.addInTail(node_3);
        ll.addInTail(node_10_1);
        ll.addInTail(node_666);
        ll.addInTail(node_10_2);

        ll.insertAfter(node_10_3, node_11);

        assertThat(ll.toString(), is("3 10 11 666 10 "));
        assertThat(ll.tail, is(node_10_2));
    }

    @Test
    public void insertAfter_05() {
        ll.insertAfter(null, node_11);

        assertThat(ll.toString(), is("11 "));
        assertThat(ll.tail, is(node_11));
    }

    @Test
    public void insertAfter_06() {
        ll.insertAfter(null, node_11);
        ll.insertAfter(null, node_3);

        assertThat(ll.toString(), is("3 11 "));
        assertThat(ll.tail, is(node_11));
    }

    @Test
    public void insertAfter_07() {
        ll.insertAfter(null, node_11);
        ll.insertAfter(null, node_3);
        ll.insertAfter(null, node_10_1);

        assertThat(ll.toString(), is("10 3 11 "));
        assertThat(ll.tail, is(node_11));
    }

    @Test
    public void insertAfter_08() {
        ll.insertAfter(null, node_11);
        ll.insertAfter(node_11, node_3);
        ll.insertAfter(null, node_10_1);

        assertThat(ll.toString(), is("10 11 3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void insertAfter_09() {
        ll.insertAfter(node_3, node_11);
        ll.insertAfter(null, node_11);
        assertThat(ll.toString(), is("11 "));
        assertThat(ll.tail, is(node_11));
    }

    @Test
    public void insertAfter_10() {
        ll.addInTail(node_3);
        ll.insertAfter(null, node_11);
        assertThat(ll.toString(), is("11 3 "));
        assertThat(ll.tail, is(node_3));
    }

    @Test
    public void insertAfter_11() {
        ll.addInTail(node_3);
        ll.insertAfter(node_3, node_11);
        assertThat(ll.toString(), is("3 11 "));
        assertThat(ll.tail, is(node_11));
    }

    @Test
    public void insertAfter_12() {
        ll.addInTail(node_3);
        ll.addInTail(node_666);
        ll.insertAfter(node_666, node_11);
        assertThat(ll.toString(), is("3 666 11 "));
        assertThat(ll.tail, is(node_11));
    }
}