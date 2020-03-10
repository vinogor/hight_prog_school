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
    public void size() {

//        assertThat(, is());
    }

    @Test
    public void put_01() {
        assertThat(ps.size(), is(0));
    }

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