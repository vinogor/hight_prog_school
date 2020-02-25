package algo.queue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueOn2StacksTest {

    private QueueOn2Stacks<Integer> q2st;

    @Before
    public void setUp() {
        q2st = new QueueOn2Stacks<>();
    }

    @Test
    public void enqueue_00() {

        assertThat(q2st.straight.size(), is(0));
        assertThat(q2st.reverse.size(), is(0));

        assertThat(q2st.straight.toString(), is(""));
        assertThat(q2st.reverse.toString(), is(""));
    }

    @Test
    public void enqueue_01() {
        q2st.enqueue(1);

        assertThat(q2st.straight.size(), is(1));
        assertThat(q2st.reverse.size(), is(0));

        assertThat(q2st.straight.toString(), is("1 "));
        assertThat(q2st.reverse.toString(), is(""));
    }

    @Test
    public void enqueue_02() {
        q2st.enqueue(1);
        q2st.enqueue(2);

        assertThat(q2st.straight.size(), is(2));
        assertThat(q2st.reverse.size(), is(0));

        assertThat(q2st.straight.toString(), is("2 1 "));
        assertThat(q2st.reverse.toString(), is(""));
    }

    @Test
    public void enqueue_03() {
        q2st.enqueue(1);
        q2st.enqueue(2);
        q2st.enqueue(3);

        assertThat(q2st.straight.size(), is(3));
        assertThat(q2st.reverse.size(), is(0));

        assertThat(q2st.straight.toString(), is("3 2 1 "));
        assertThat(q2st.reverse.toString(), is(""));
    }

    @Test
    public void enqueue_04() {
        q2st.enqueue(1);
        q2st.enqueue(2);
        q2st.enqueue(3);
        Integer res = q2st.dequeue();

        assertThat(q2st.straight.size(), is(0));
        assertThat(q2st.reverse.size(), is(2));

        assertThat(q2st.straight.toString(), is(""));
        assertThat(q2st.reverse.toString(), is("2 3 "));

        assertThat(res, is(1));
    }

    @Test
    public void enqueue_05() {
        q2st.enqueue(1);
        q2st.enqueue(2);
        q2st.enqueue(3);
        q2st.dequeue();
        Integer res = q2st.dequeue();

        assertThat(q2st.straight.size(), is(0));
        assertThat(q2st.reverse.size(), is(1));

        assertThat(q2st.straight.toString(), is(""));
        assertThat(q2st.reverse.toString(), is("3 "));

        assertThat(res, is(2));
    }

    @Test
    public void enqueue_06() {
        q2st.enqueue(1);
        q2st.enqueue(2);
        q2st.enqueue(3);
        q2st.enqueue(4);
        q2st.enqueue(5);

        Integer res1 = q2st.dequeue();
        Integer res2 = q2st.dequeue();
        Integer res3 = q2st.dequeue();

        assertThat(res1, is(1));
        assertThat(res2, is(2));
        assertThat(res3, is(3));

        q2st.enqueue(6);
        q2st.enqueue(7);

        Integer res4 = q2st.dequeue();

        assertThat(res4, is(4));

        assertThat(q2st.straight.size(), is(0));
        assertThat(q2st.reverse.size(), is(3));

        assertThat(q2st.straight.toString(), is(""));
        assertThat(q2st.reverse.toString(), is("5 6 7 "));
    }

    @Test
    public void dequeue_01() {
        Integer res = q2st.dequeue();

        assertThat(res, nullValue());
    }

    @Test
    public void dequeue_02() {
        q2st.enqueue(1);
        q2st.dequeue();
        Integer res = q2st.dequeue();

        assertThat(res, nullValue());
    }

    @Test
    public void size_01() {
        q2st.enqueue(1);

        assertThat(q2st.size(), is(1));
    }

    @Test
    public void size_02() {
        q2st.enqueue(1);
        q2st.enqueue(2);

        assertThat(q2st.size(), is(2));
    }

    @Test
    public void size_03() {
        q2st.enqueue(1);
        q2st.enqueue(2);
        q2st.enqueue(3);

        assertThat(q2st.size(), is(3));
    }
}