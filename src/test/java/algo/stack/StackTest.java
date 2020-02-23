package algo.stack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void setUp() {
        stack = new Stack<>();
    }

    @Test
    public void push() {
        stack.push(1);
        assertThat(stack.ll.getFirst(), is(1));
        assertThat(stack.ll.size(), is(1));
    }

    @Test
    public void pop() {
        stack.push(1);
        Integer pop = stack.pop();
        assertThat(pop, is(1));
        assertThat(stack.ll.size(), is(0));
    }

    @Test
    public void peek() {
        stack.push(1);
        Integer pop = stack.peek();
        assertThat(pop, is(1));
        assertThat(stack.ll.size(), is(1));
    }

    @Test
    public void size() {
        stack.push(1);
        assertThat(stack.ll.size(), is(1));
    }
}