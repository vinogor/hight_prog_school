package algo.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PostFixNotationTest {

    private PostFixNotation pfn;

    @Before
    public void setUp() {
        pfn = new PostFixNotation();
    }

    @Test
    public void calculate_01() {
        assertThat(pfn.calculate("8 3 + ="), is(11));
    }

    @Test
    public void calculate_02() {
        assertThat(pfn.calculate("81 3 + ="), is(84));
    }

    @Test
    public void calculate_03() {
        assertThat(pfn.calculate("80 30 + ="), is(110));
    }

    @Test
    public void calculate_04() {
        assertThat(pfn.calculate("8 0 + ="), is(8));
    }

    @Test
    public void calculate_05() {
        assertThat(pfn.calculate("8 3 * ="), is(24));
    }

    @Test
    public void calculate_06() {
        assertThat(pfn.calculate("81 3 * ="), is(243));
    }

    @Test
    public void calculate_07() {
        assertThat(pfn.calculate("800 30 * ="), is(24000));
    }

    @Test
    public void calculate_08() {
        assertThat(pfn.calculate("8 0 * ="), is(0));
    }

    @Test
    public void calculate_09() {
        assertThat(pfn.calculate("8 2 + 5 * 9 + ="), is(59));
    }
}