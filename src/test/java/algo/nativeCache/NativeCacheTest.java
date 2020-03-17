package algo.nativeCache;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NativeCacheTest {

    private NativeCache<String> nc;

    @Before
    public void setUp() {
        nc = new NativeCache<>(5, String.class);
    }

    @Test // один положили, достали существующий
    public void put_01() {
        nc.put("a", "val_a");

        assertThat(nc.counter, is(1));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("a"), is("val_a"));

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));
    }

    @Test // один положили, пытаемся достать НЕ существующий
    public void put_02() {
        nc.put("a", "val_a");

        assertThat(nc.counter, is(1));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("b"), nullValue());

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));
    }

    @Test // положим, перезапишем, достанем существующий
    public void put_03() {
        nc.put("a", "val_a");
        nc.put("a", "val_a2");

        assertThat(nc.counter, is(1));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("a"), is("val_a2"));

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));
    }


    @Test
    public void get_01() {

    }
}