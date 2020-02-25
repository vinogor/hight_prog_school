package algo.deque;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class PalindromeTest {

    private Palindrome pali;

    @Before
    public void setUp()  {
        pali = new Palindrome();
    }

    @Test
    public void check_01() {
        assertThat(pali.check("123123"), is(false));
    }

    @Test
    public void check_02() {
        assertThat(pali.check("abcba"), is(true));
    }

    @Test
    public void check_03() {
        assertThat(pali.check(""), is(true));
    }

    @Test
    public void check_04() {
        assertThat(pali.check("q"), is(true));
    }

    @Test
    public void check_05() {
        assertThat(pali.check("qq"), is(true));
    }

    @Test
    public void check_06() {
        assertThat(pali.check("q1q"), is(true));
    }

    @Test
    public void check_07() {
        assertThat(pali.check("qq1q"), is(false));
    }

}