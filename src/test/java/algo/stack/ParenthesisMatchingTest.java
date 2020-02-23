package algo.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParenthesisMatchingTest {

    private ParenthesisMatching matching;

    @Before
    public void setUp() {
        matching = new ParenthesisMatching();
    }

    @Test
    public void check_01() {
        assertThat(matching.check("(()((())()))"), is(true));
    }

    @Test
    public void check_02() {
        assertThat(matching.check("(()()(()"), is(false));
    }

    @Test
    public void check_03() {
        assertThat(matching.check("())("), is(false));
    }

    @Test
    public void check_04() {
        assertThat(matching.check("))(("), is(false));
    }

    @Test
    public void check_05() {
        assertThat(matching.check("((())"), is(false));
    }

    @Test
    public void check_06() {
        assertThat(matching.check(""), is(true));
    }
}