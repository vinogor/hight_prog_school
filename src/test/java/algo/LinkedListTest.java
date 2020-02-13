package algo;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class LinkedListTest {

    private static LinkedList ll;

    private static Node node_10_1;
    private static Node node_10_2;
    private static Node node_10_3;
    private static Node node_11;
    private static Node node_666;

    @Before
    public void setUp() {
        ll = new LinkedList();

        // дозаменить на константы
        node_10_1 = new Node(10);
        node_10_2 = new Node(10);
        node_10_3 = new Node(10);
        node_11 = new Node(11);
        node_666 = new Node(666);
    }

    @Test
    public void addInTail_01() {
        ll.addInTail(new Node(3));
        assertThat(ll.toString(), is("3 "));
    }

    @Test
    public void addInTail_02() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        assertThat(ll.toString(), is("3 10 "));
    }

    @Test
    public void addInTail_03() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(666));
        assertThat(ll.toString(), is("3 10 666 "));
    }

    @Test
    public void addInTail_04() {
        assertThat(ll.toString(), is(""));
    }

    @Test
    public void find_01() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(666));
        assertThat(ll.find(3).value, is(3));
    }

    @Test
    public void find_02() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(666));
        assertThat(ll.find(0), is(nullValue()));
    }

    @Test
    public void find_03() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(666));
        assertThat(ll.find(10).value, is(10));
    }

    @Test
    public void find_04() {
        assertThat(ll.find(0), is(nullValue()));
    }

    @Test
    public void remove_01() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        assertThat(ll.remove(3), is(true));
        assertThat(ll.toString(), is("10 11 666 "));
    }

    @Test
    public void remove_02() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        assertThat(ll.remove(666), is(true));
        assertThat(ll.toString(), is("3 10 11 "));
    }

    @Test
    public void remove_03() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        assertThat(ll.remove(11), is(true));
        assertThat(ll.toString(), is("3 10 666 "));
    }

    @Test
    public void remove_04() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        ll.addInTail(new Node(10));
        assertThat(ll.remove(10), is(true));
        assertThat(ll.toString(), is("3 11 666 10 "));
    }

    @Test
    public void remove_05() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        assertThat(ll.remove(1), is(false));
        assertThat(ll.toString(), is("3 10 11 666 "));
    }

    @Test
    public void remove_06() {
        assertThat(ll.remove(1), is(false));
        assertThat(ll.toString(), is(""));
    }

    @Test
    public void removeAll_01() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(666));
        ll.removeAll(3);
        assertThat(ll.toString(), is("10 666 "));
    }

    @Test
    public void removeAll_02() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(666));
        ll.addInTail(new Node(3));
        ll.removeAll(3);
        assertThat(ll.toString(), is("10 666 "));
    }

    @Test
    public void removeAll_03() {
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(3));
        ll.addInTail(new Node(3));
        ll.removeAll(3);
        assertThat(ll.toString(), is(""));
    }

    @Test
    public void removeAll_04() {
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        ll.removeAll(3);
        assertThat(ll.toString(), is("10 11 666 "));
    }

    @Test
    public void removeAll_05() {
        ll.removeAll(3);
        assertThat(ll.toString(), is(""));
    }

    @Test
    public void clear_01() {
        ll.addInTail(new Node(10));
        ll.addInTail(new Node(11));
        ll.addInTail(new Node(666));
        ll.clear();
        assertThat(ll.toString(), is(""));
    }

    @Test
    public void clear_02() {
        ll.clear();
        assertThat(ll.toString(), is(""));
    }

    @Test
    public void findAll_01() {
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);
        ll.addInTail(node_666);

        ArrayList<Node> result = ll.findAll(10);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(0).next, is(node_11));
    }

    @Test
    public void findAll_02() {
        ll.addInTail(node_11);
        ll.addInTail(node_666);
        ll.addInTail(node_10_1);

        ArrayList<Node> result = ll.findAll(10);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(0).next, nullValue());
    }

    @Test
    public void findAll_03() {
        ll.addInTail(node_666);
        ll.addInTail(node_10_1);
        ll.addInTail(node_11);

        ArrayList<Node> result = ll.findAll(10);

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

        ArrayList<Node> result = ll.findAll(10);

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

        ArrayList<Node> result = ll.findAll(10);

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

        ArrayList<Node> result = ll.findAll(10);

        assertThat(result.size(), is(3));
        assertThat(result.get(0).value, is(10));
        assertThat(result.get(1).value, is(10));
        assertThat(result.get(2).value, is(10));
        assertThat(result.get(0).next, is(node_10_2));
        assertThat(result.get(1).next, is(node_10_3));
        assertThat(result.get(2).next, nullValue());
    }
}