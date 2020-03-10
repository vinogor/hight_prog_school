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
    public void get() {
    }

    @Test
    public void remove() {
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