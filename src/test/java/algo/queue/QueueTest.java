package algo.queue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueueTest {

    private Queue<Integer> q;

    @Before
    public void setUp() {
        q = new Queue<>();
    }

    @Test
    public void enqueue_00() {
        assertThat(q.size(), is(0));
        assertThat(q.toString(), is(""));
    }

    @Test
    public void enqueue_01() {
        q.enqueue(1);

        assertThat(q.size(), is(1));
        assertThat(q.toString(), is("1 "));
    }

    @Test
    public void enqueue_02() {
        q.enqueue(1);
        q.enqueue(2);

        assertThat(q.size(), is(2));
        assertThat(q.toString(), is("1 2 "));
    }

    @Test
    public void enqueue_03() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        assertThat(q.size(), is(3));
        assertThat(q.toString(), is("1 2 3 "));
    }

    @Test
    public void enqueue_04() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        Integer res = q.dequeue();

        assertThat(q.size(), is(2));
        assertThat(q.toString(), is("2 3 "));
        assertThat(res, is(1));
    }

    @Test
    public void enqueue_05() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        Integer res = q.dequeue();

        assertThat(q.size(), is(1));
        assertThat(q.toString(), is("3 "));
        assertThat(res, is(2));
    }

    @Test
    public void enqueue_06() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        Integer res1 = q.dequeue();
        Integer res2 = q.dequeue();
        Integer res3 = q.dequeue();

        assertThat(res1, is(1));
        assertThat(res2, is(2));
        assertThat(res3, is(3));

        q.enqueue(6);
        q.enqueue(7);

        Integer res4 = q.dequeue();

        assertThat(res4, is(4));
        assertThat(q.size(), is(3));
        assertThat(q.toString(), is("5 6 7 "));
    }

    @Test
    public void dequeue_01() {
        Integer res = q.dequeue();

        assertThat(res, nullValue());
    }

    @Test
    public void dequeue_02() {
        q.enqueue(1);
        q.dequeue();
        Integer res = q.dequeue();

        assertThat(res, nullValue());
    }

    @Test
    public void size_01() {
        q.enqueue(1);

        assertThat(q.size(), is(1));
    }

    @Test
    public void size_02() {
        q.enqueue(1);
        q.enqueue(2);

        assertThat(q.size(), is(2));
    }

    @Test
    public void size_03() {
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        assertThat(q.size(), is(3));
    }
}