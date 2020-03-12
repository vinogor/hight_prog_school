package algo.powerSet;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PowerSetTest {

    private PowerSet ps;

    @Before
    public void setUp() {
        ps = new PowerSet();
    }

    @Test
    public void put_00() {
        ps.put(null);
        assertThat(ps.size(), is(0));
    }

    @Test
    public void put_01() {
        assertThat(ps.size(), is(0));
    }

    @Test
    public void put_02() {
        ps.put("1");

        assertThat(ps.size(), is(1));
    }

    @Test
    public void put_03() {
        ps.put("1");
        ps.put("2");

        assertThat(ps.size(), is(2));
    }

    @Test
    public void put_04() {
        ps.put("1");
        ps.put("1");

        assertThat(ps.size(), is(1));
    }

    @Test
    public void put_05() {
        ps.put("1");
        ps.put("1");
        ps.put("1");

        assertThat(ps.size(), is(1));
    }

    @Test // положить второе уникальное значение с одинаковым хэш
    public void put_06() {
        ps.put("1");
        char ch = "1".toCharArray()[0];
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));

        assertThat(ps.size(), is(2));
    }

    // а если заполнить полностью?


    @Test
    public void get_01() {
        boolean res = ps.get(null);
        assertThat(res, is(false));
    }

    @Test
    public void get_02() {
        ps.put("1");
        boolean res = ps.get("1");
        assertThat(res, is(true));
    }

    @Test
    public void get_03() {
        ps.put("1");
        boolean res = ps.get("2");
        assertThat(res, is(false));
    }

    @Test
    public void get_04() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        boolean res = ps.get("1");
        assertThat(res, is(true));
    }

    @Test
    public void get_05() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        boolean res = ps.get("2");
        assertThat(res, is(true));
    }

    @Test
    public void get_06() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        boolean res = ps.get("3");
        assertThat(res, is(true));
    }

    @Test // получить одно из 2х значений у которых хэш одинаковый
    public void get_07() {
        ps.put("1");
        char ch = "1".toCharArray()[0];
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));


        assertThat(ps.get("1"), is(true));
        assertThat(ps.get(String.valueOf(ch)), is(true));
    }

    @Test // получить не сущ-е из 2х значений у которых хэш одинаковый
    public void get_08() {
        ps.put("1");
        char ch = "1".toCharArray()[0];
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));
        ch = (char) (ch + ps.size);

        assertThat(ps.get(String.valueOf(ch)), is(false));
        ch = (char) (ch - ps.size);
        assertThat(ps.get(String.valueOf(ch)), is(true));
    }

    @Test // попытка удалить null
    public void remove_01() {
        boolean res = ps.remove(null);
        assertThat(res, is(false));
    }

    @Test // попытка удалить не существующее из пустого
    public void remove_02() {
        boolean res = ps.remove("1");
        assertThat(res, is(false));
    }

    @Test // удаляем удинственное
    public void remove_03() {
        ps.put("1");
        assertThat(ps.counter, is(1));
        boolean res = ps.remove("1");
        assertThat(ps.counter, is(0));
        assertThat(res, is(true));
    }

    @Test // удаляем одно из 3х - с начала
    public void remove_04() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        assertThat(ps.counter, is(3));
        boolean res = ps.remove("1");
        assertThat(ps.counter, is(2));
        assertThat(res, is(true));
    }

    @Test // удаляем одно из 3х - с середины
    public void remove_05() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        assertThat(ps.counter, is(3));
        boolean res = ps.remove("2");
        assertThat(ps.counter, is(2));
        assertThat(res, is(true));
    }

    @Test // удаляем одно из 3х - с конца
    public void remove_06() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        assertThat(ps.counter, is(3));
        boolean res = ps.remove("3");
        assertThat(ps.counter, is(2));
        assertThat(res, is(true));
    }

    @Test // удаляем не сущ-щее из 3х
    public void remove_07() {
        ps.put("1");
        ps.put("2");
        ps.put("3");
        assertThat(ps.counter, is(3));
        boolean res = ps.remove("4");
        assertThat(ps.counter, is(3));
        assertThat(res, is(false));
    }


    @Test // удаляем 1 из 3х с одинак хэш
    public void remove_08() {
        ps.put("1");
        char ch = "1".toCharArray()[0];
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));

        assertThat(ps.counter, is(3));
        boolean res = ps.remove(String.valueOf(ch));
        assertThat(ps.counter, is(2));
        assertThat(res, is(true));
    }

    @Test // удаляем не сущ из 3х, у всех одинак хэш
    public void remove_09() {
        ps.put("1");
        char ch = "1".toCharArray()[0];
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));
        ch = (char) (ch + ps.size);
        ps.put(String.valueOf(ch));
        ch = (char) (ch + ps.size);

        assertThat(ps.counter, is(3));
        boolean res = ps.remove(String.valueOf(ch));
        assertThat(ps.counter, is(3));
        assertThat(res, is(false));
    }

    @Test
    public void intersection() {
    }

    @Test
    public void union() {
    }

    @Test
    public void difference() {
    }

    @Test
    public void isSubset() {
    }
}