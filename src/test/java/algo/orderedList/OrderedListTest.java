package algo.orderedList;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class OrderedListTest {

    @Test
    public void add_asc_01() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        assertThat(ol.getAll().size(), is(0));
    }

    @Test
    public void add_asc_02() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);

        assertThat(ol.getAll().size(), is(1));
        assertThat(ol.getAll().get(0).value, is(0));
    }

    @Test
    public void add_asc_03() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(1);

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(1));
    }

    @Test
    public void add_asc_04() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(1);
        ol.add(2);

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(2));
    }

    @Test
    public void add_asc_05() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(-1);

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.getAll().get(0).value, is(-1));
        assertThat(ol.getAll().get(1).value, is(0));
    }

    @Test
    public void add_asc_06() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(-1);
        ol.add(-2);

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.getAll().get(0).value, is(-2));
        assertThat(ol.getAll().get(1).value, is(-1));
        assertThat(ol.getAll().get(2).value, is(0));
    }

    @Test
    public void add_asc_07() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(0);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(2));
    }

    @Test
    public void add_asc_08() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(1);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(2));
    }

    @Test
    public void add_asc_09() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(2);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(2));
        assertThat(ol.getAll().get(3).value, is(2));
    }

    @Test
    public void add_asc_10() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(6));
        assertThat(ol.getAll().get(5).value, is(7));
        assertThat(ol.getAll().get(6).value, is(100));
    }


    @Test
    public void add_dec_01() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        assertThat(ol.getAll().size(), is(0));
    }

    @Test
    public void add_dec_02() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);

        assertThat(ol.getAll().size(), is(1));
        assertThat(ol.getAll().get(0).value, is(0));
    }

    @Test
    public void add_dec_03() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(1);

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.getAll().get(0).value, is(1));
        assertThat(ol.getAll().get(1).value, is(0));
    }

    @Test
    public void add_dec_04() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(1);
        ol.add(2);

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.getAll().get(0).value, is(2));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(0));
    }

    @Test
    public void add_dec_05() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(-1);

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(-1));
    }

    @Test
    public void add_dec_06() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(-1);
        ol.add(-2);

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(-1));
        assertThat(ol.getAll().get(2).value, is(-2));
    }

    @Test
    public void add_dec_07() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(0);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(2));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(0));
        assertThat(ol.getAll().get(3).value, is(0));
    }

    @Test
    public void add_dec_08() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(1);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(2));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(0));
    }

    @Test
    public void add_dec_09() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(2);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(2));
        assertThat(ol.getAll().get(1).value, is(2));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(0));
    }

    @Test
    public void add_dec_10() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(0).value, is(100));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(1));
        assertThat(ol.getAll().get(5).value, is(0));
        assertThat(ol.getAll().get(6).value, is(-100));
    }


    @Test
    public void find_asc_01() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(0);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res.value, is(0));
    }

    @Test
    public void find_asc_02() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(20);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res.value, is(20));
    }

    @Test
    public void find_asc_03() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(40);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res.value, is(40));
    }

    @Test
    public void find_asc_04() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        Node<Integer> res = ol.find(0);

        assertThat(ol.getAll().size(), is(0));
        assertThat(res, nullValue());
    }

    @Test
    public void find_asc_05() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(15);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }

    @Test
    public void find_asc_06() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(45);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }

    @Test
    public void find_asc_07() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(-45);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }

    @Test
    public void find_asc_08() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(33);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }


    @Test
    public void find_desc_01() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(0);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res.value, is(0));
    }

    @Test
    public void find_desc_02() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(20);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res.value, is(20));
    }

    @Test
    public void find_desc_03() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(40);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res.value, is(40));
    }

    @Test
    public void find_desc_04() {
        OrderedList<Integer> ol = new OrderedList<>(false);

        Node<Integer> res = ol.find(0);

        assertThat(ol.getAll().size(), is(0));
        assertThat(res, nullValue());
    }

    @Test
    public void find_desc_05() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(15);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }

    @Test
    public void find_desc_06() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(45);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }

    @Test
    public void find_desc_07() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(-45);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }

    @Test
    public void find_desc_08() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(10);
        ol.add(20);
        ol.add(30);
        ol.add(40);

        Node<Integer> res = ol.find(33);

        assertThat(ol.getAll().size(), is(5));
        assertThat(res, nullValue());
    }
    
    @Test
    public void delete_asc_01() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(33);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(6));
        assertThat(ol.getAll().get(5).value, is(7));
        assertThat(ol.getAll().get(6).value, is(100));
    }

    @Test
    public void delete_asc_02() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(-100);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(0).value, is(0));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(3));
        assertThat(ol.getAll().get(3).value, is(6));
        assertThat(ol.getAll().get(4).value, is(7));
        assertThat(ol.getAll().get(5).value, is(100));
    }

    @Test
    public void delete_asc_03() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(100);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(6));
        assertThat(ol.getAll().get(5).value, is(7));
    }

    @Test
    public void delete_asc_04() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(3);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(6));
        assertThat(ol.getAll().get(4).value, is(7));
        assertThat(ol.getAll().get(5).value, is(100));
    }

    @Test
    public void delete_asc_05() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(0);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(1));
        assertThat(ol.getAll().get(2).value, is(3));
        assertThat(ol.getAll().get(3).value, is(6));
        assertThat(ol.getAll().get(4).value, is(7));
        assertThat(ol.getAll().get(5).value, is(100));
    }

    @Test
    public void delete_asc_06() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(4);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(6));
        assertThat(ol.getAll().get(5).value, is(7));
        assertThat(ol.getAll().get(6).value, is(100));
    }

    @Test
    public void delete_asc_07() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(-50);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(0).value, is(-100));
        assertThat(ol.getAll().get(1).value, is(0));
        assertThat(ol.getAll().get(2).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(6));
        assertThat(ol.getAll().get(5).value, is(7));
        assertThat(ol.getAll().get(6).value, is(100));
    }

    @Test
    public void delete_asc_08() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(-50);
        ol.delete(-100);
        ol.delete(0);
        ol.delete(33);
        ol.delete(6);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(0).value, is(1));
        assertThat(ol.getAll().get(1).value, is(3));
        assertThat(ol.getAll().get(2).value, is(7));
        assertThat(ol.getAll().get(3).value, is(100));
    }

    @Test
    public void delete_desc_01() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(33);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(0).value, is(100));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(1));
        assertThat(ol.getAll().get(5).value, is(0));
        assertThat(ol.getAll().get(6).value, is(-100));
    }

    @Test
    public void delete_desc_02() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(-100);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(0).value, is(100));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(4).value, is(1));
        assertThat(ol.getAll().get(5).value, is(0));
    }

    @Test
    public void delete_desc_03() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(100);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(5).value, is(-100));
        assertThat(ol.getAll().get(4).value, is(0));
        assertThat(ol.getAll().get(3).value, is(1));
        assertThat(ol.getAll().get(2).value, is(3));
        assertThat(ol.getAll().get(1).value, is(6));
        assertThat(ol.getAll().get(0).value, is(7));
    }

    @Test
    public void delete_desc_04() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(3);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(5).value, is(-100));
        assertThat(ol.getAll().get(4).value, is(0));
        assertThat(ol.getAll().get(3).value, is(1));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(0).value, is(100));
    }

    @Test
    public void delete_desc_05() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(0);

        assertThat(ol.getAll().size(), is(6));
        assertThat(ol.getAll().get(5).value, is(-100));
        assertThat(ol.getAll().get(4).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(0).value, is(100));
    }

    @Test
    public void delete_desc_06() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(4);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(6).value, is(-100));
        assertThat(ol.getAll().get(5).value, is(0));
        assertThat(ol.getAll().get(4).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(0).value, is(100));
    }

    @Test
    public void delete_desc_07() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(-50);

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.getAll().get(6).value, is(-100));
        assertThat(ol.getAll().get(5).value, is(0));
        assertThat(ol.getAll().get(4).value, is(1));
        assertThat(ol.getAll().get(3).value, is(3));
        assertThat(ol.getAll().get(2).value, is(6));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(0).value, is(100));
    }

    @Test
    public void delete_desc_08() {
        OrderedList<Integer> ol = new OrderedList<>(false);
        ol.add(0);
        ol.add(7);
        ol.add(6);
        ol.add(3);
        ol.add(1);
        ol.add(100);
        ol.add(-100);

        assertThat(ol.getAll().size(), is(7));

        ol.delete(-50);
        ol.delete(-100);
        ol.delete(0);
        ol.delete(33);
        ol.delete(6);

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.getAll().get(3).value, is(1));
        assertThat(ol.getAll().get(2).value, is(3));
        assertThat(ol.getAll().get(1).value, is(7));
        assertThat(ol.getAll().get(0).value, is(100));
    }

    @Test
    public void clear_asc_asc_01() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        ol.clear(true);

        assertThat(ol.toString(), is(""));
    }

    @Test
    public void clear_asc_asc_02() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        ol.add(0);
        ol.add(1);
        ol.add(2);

        assertThat(ol.toString(), is("0 1 2 "));

        ol.clear(true);

        assertThat(ol.toString(), is(""));

        ol.add(0);
        ol.add(1);
        ol.add(2);

        assertThat(ol.toString(), is("0 1 2 "));
    }

    @Test
    public void clear_asc_desc_02() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        ol.add(0);
        ol.add(1);
        ol.add(2);

        assertThat(ol.toString(), is("0 1 2 "));

        ol.clear(false);

        assertThat(ol.toString(), is(""));

        ol.add(0);
        ol.add(1);
        ol.add(2);

        assertThat(ol.toString(), is("2 1 0 "));
    }

    @Test
    public void count_01() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        assertThat(ol.count(), is(0));
    }

    @Test
    public void count_02() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);

        assertThat(ol.count(), is(1));
    }

    @Test
    public void count_03() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);

        assertThat(ol.count(), is(2));
    }

    @Test
    public void count_04() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        assertThat(ol.count(), is(3));
    }

    @Test
    public void count_05() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        ol.clear(true);

        assertThat(ol.count(), is(0));
    }

    @Test
    public void count_06() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        ol.delete(1);

        assertThat(ol.count(), is(2));
    }

    @Test
    public void count_07() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        ol.delete(2);

        assertThat(ol.count(), is(2));
    }

    @Test
    public void count_08() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        ol.delete(3);

        assertThat(ol.count(), is(2));
    }

    @Test
    public void count_09() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        ol.delete(3);
        ol.delete(0);
        ol.delete(1);

        assertThat(ol.count(), is(1));
    }

    @Test
    public void count_10() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(1);
        ol.add(2);
        ol.add(3);

        System.out.println(ol);
        ol.delete(3);
        System.out.println(ol);
        ol.delete(0);
        System.out.println(ol);
        ol.delete(1);
        System.out.println(ol);
        ol.delete(-1);
        System.out.println(ol);
        ol.delete(2);
        System.out.println(ol);

        assertThat(ol.count(), is(0));
    }

    @Test
    public void delete_asc_01_1() {
        OrderedList<Integer> ol = new OrderedList<>(true);
        ol.add(0);

        assertThat(ol.getAll().size(), is(1));

        ol.delete(0);

        assertThat(ol.getAll().size(), is(0));
    }

    @Test
    public void delete_asc_01_2() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        assertThat(ol.getAll().size(), is(0));

        ol.delete(0);

        assertThat(ol.getAll().size(), is(0));
    }

    @Test
    public void delete_asc_01_3() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        ol.add(0);
        ol.add(1);

        ol.delete(0);

        assertThat(ol.getAll().size(), is(1));
        assertThat(ol.getAll().get(0).value, is(1));
    }

    @Test
    public void delete_asc_01_4() {
        OrderedList<Integer> ol = new OrderedList<>(true);

        ol.add(0);
        ol.add(1);
        ol.add(2);
        ol.add(3);
        ol.add(4);

        ol.delete(4);
        ol.delete(1);
        ol.delete(3);
        ol.delete(0);
        ol.delete(2);

        assertThat(ol.getAll().size(), is(0));
    }
    
    // =========== для строк ==========

    @Test
    public void add_str_asc_01() {
        OrderedList<String> ol = new OrderedList<>(true);
        assertThat(ol.getAll().size(), is(0));
    }

    @Test
    public void add_str_asc_02() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");

        assertThat(ol.getAll().size(), is(1));
        assertThat(ol.toString(), is("a "));
    }

    @Test
    public void add_str_asc_03() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");
        ol.add("aa");

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.toString(), is("a aa "));
    }

    @Test
    public void add_str_asc_04() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");
        ol.add("aa");
        ol.add("ab");

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.toString(), is("a aa ab "));
    }

    @Test
    public void add_str_asc_05() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("b");
        ol.add("a");

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.toString(), is("a b "));
    }

    @Test
    public void add_str_asc_06() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("c");
        ol.add("b");
        ol.add("a");

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.toString(), is("a b c "));
    }

    @Test
    public void add_str_asc_07() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");
        ol.add("b");
        ol.add("c");
        ol.add("a");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is("a a b c "));
    }

    @Test
    public void add_str_asc_08() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");
        ol.add("b");
        ol.add("c");
        ol.add("b");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is("a b b c "));
    }

    @Test
    public void add_str_asc_09() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");
        ol.add("b");
        ol.add("c");
        ol.add("c");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is("a b c c "));
    }

    @Test
    public void add_str_asc_09_2() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add(" a");
        ol.add("b  ");
        ol.add(" c");
        ol.add("c   ");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is(" a b    c c    "));
    }

    @Test
    public void add_str_asc_10() {
        OrderedList<String> ol = new OrderedList<>(true);
        ol.add("a");
        ol.add("b");
        ol.add("cc");
        ol.add("aa");
        ol.add("bb");
        ol.add("ca");
        ol.add("ccc");

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.toString(), is("a aa b bb ca cc ccc "));
    }


    @Test
    public void add_str_dec_01() {
        OrderedList<String> ol = new OrderedList<>(false);
        assertThat(ol.getAll().size(), is(0));
    }

    @Test
    public void add_str_dec_02() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");

        assertThat(ol.getAll().size(), is(1));
        assertThat(ol.toString(), is("a "));
    }

    @Test
    public void add_str_dec_03() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");
        ol.add("b");

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.toString(), is("b a "));
    }

    @Test
    public void add_str_dec_04() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");
        ol.add("b");
        ol.add("c");

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.toString(), is("c b a "));
    }

    @Test
    public void add_str_dec_05() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("b");
        ol.add("a");

        assertThat(ol.getAll().size(), is(2));
        assertThat(ol.toString(), is("b a "));
    }

    @Test
    public void add_str_dec_06() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("c");
        ol.add("b");
        ol.add("a");

        assertThat(ol.getAll().size(), is(3));
        assertThat(ol.toString(), is("c b a "));
    }

    @Test
    public void add_str_dec_07() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");
        ol.add("b");
        ol.add("c");
        ol.add("a");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is("c b a a "));
    }

    @Test
    public void add_str_dec_08() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");
        ol.add("b");
        ol.add("c");
        ol.add("b");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is("c b b a "));
    }

    @Test
    public void add_str_dec_09() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");
        ol.add("b");
        ol.add("c");
        ol.add("c");

        assertThat(ol.getAll().size(), is(4));
        assertThat(ol.toString(), is("c c b a "));
    }

    @Test
    public void add_str_dec_10() {
        OrderedList<String> ol = new OrderedList<>(false);
        ol.add("a");
        ol.add("b");
        ol.add("cc");
        ol.add("aa");
        ol.add("bb");
        ol.add("ca");
        ol.add("ccc");

        assertThat(ol.getAll().size(), is(7));
        assertThat(ol.toString(), is("ccc cc ca bb b aa a "));
    }
}