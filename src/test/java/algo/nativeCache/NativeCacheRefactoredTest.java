package algo.nativeCache;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NativeCacheRefactoredTest {

    private NativeCacheRefactored<String> nc;

    @Before
    public void setUp() {
        nc = new NativeCacheRefactored<>(5, String.class);
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

    @Test // заполним полностью, достанем парочку по 1 разу
    public void put_04() {
        nc.put("a", "val_a");
        nc.put("b", "val_b");
        nc.put("c", "val_c");
        nc.put("d", "val_d");
        nc.put("e", "val_e");

        assertThat(nc.counter, is(5));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("a"), is("val_a"));
        assertThat(nc.get("b"), is("val_b"));

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));
    }

    @Test // заполним полностью, достанем все по 1 разу
    public void put_05() {
        nc.put("a", "val_a");
        nc.put("b", "val_b");
        nc.put("c", "val_c");
        nc.put("d", "val_d");
        nc.put("e", "val_e");

        assertThat(nc.counter, is(5));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("a"), is("val_a"));
        assertThat(nc.get("b"), is("val_b"));
        assertThat(nc.get("c"), is("val_c"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("e"), is("val_e"));

        assertThat(nc.minHits, is(1));
        assertThat(nc.minHitsIndex, is(1)); // последняя ячейка которая хитнулась
    }

    @Test // заполним полностью, достанем все по 1 разу, положим ещё 1
    public void put_06() {
        nc.put("a", "val_a");
        nc.put("b", "val_b");
        nc.put("c", "val_c");
        nc.put("d", "val_d");
        nc.put("e", "val_e");

        assertThat(nc.counter, is(5));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("a"), is("val_a"));
        assertThat(nc.get("b"), is("val_b"));
        assertThat(nc.get("c"), is("val_c"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("e"), is("val_e"));

        assertThat(nc.minHits, is(1));
        assertThat(nc.minHitsIndex, is(1)); // последняя ячейка которая хитнулась

        nc.put("f", "val_f");

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(1)); // она же и обнулится
    }

    @Test // заполним полностью, достанем всех по разному, положим несколько
    public void put_07() {
        nc.put("a", "val_a");
        nc.put("b", "val_b");
        nc.put("c", "val_c");
        nc.put("d", "val_d");
        nc.put("e", "val_e");

        assertThat(nc.counter, is(5));
        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(0));

        assertThat(nc.get("a"), is("val_a"));
        assertThat(nc.get("a"), is("val_a"));
        assertThat(nc.get("a"), is("val_a"));
        assertThat(nc.get("b"), is("val_b"));
        assertThat(nc.get("b"), is("val_b"));
        assertThat(nc.get("b"), is("val_b"));
        assertThat(nc.get("b"), is("val_b"));
        assertThat(nc.get("c"), is("val_c"));
        assertThat(nc.get("c"), is("val_c"));
        assertThat(nc.get("c"), is("val_c"));
        assertThat(nc.get("c"), is("val_c"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("d"), is("val_d"));
        assertThat(nc.get("e"), is("val_e"));
        assertThat(nc.get("e"), is("val_e"));
        assertThat(nc.get("e"), is("val_e"));
        assertThat(nc.get("e"), is("val_e"));
        assertThat(nc.get("e"), is("val_e"));
        assertThat(nc.get("e"), is("val_e"));

        nc.put("f", "val_f");

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(2));

        nc.put("g", "val_g");

        assertThat(nc.minHits, is(0));
        assertThat(nc.minHitsIndex, is(2));
    }

    @Test // заполним полностью эл-ми с одинаковым хэш, достанем все по 1 разу
    public void put_08() {
        String newKey = "a";
        for (int i = 0; i < nc.size; i++) {
            nc.put(newKey, "val_" + newKey);
            newKey = String.valueOf((char) (newKey.toCharArray()[0] + nc.size));
        }

        newKey = "a";
        for (int i = 0; i < nc.size; i++) {
            assertThat(nc.get(newKey), is("val_" + newKey));
            newKey = String.valueOf((char) (newKey.toCharArray()[0] + nc.size));
        }

        assertThat(nc.counter, is(5));
        assertThat(nc.minHits, is(1));
        assertThat(nc.minHitsIndex, is(1));
    }

    @Test // заполним полностью эл-ми с одинаковым хэш, достанем все по 1 разу, положим ещё 1 с тем же хэш, получим его
    public void put_09() {
        String newKey = "a";
        for (int i = 0; i < nc.size; i++) {
            nc.put(newKey, "val_" + newKey);
            newKey = String.valueOf((char) (newKey.toCharArray()[0] + nc.size));
        }

        newKey = "a";
        for (int i = 0; i < nc.size; i++) {
            assertThat(nc.get(newKey), is("val_" + newKey));
            newKey = String.valueOf((char) (newKey.toCharArray()[0] + nc.size));
        }

        assertThat(nc.counter, is(5));
        assertThat(nc.minHits, is(1));
        assertThat(nc.minHitsIndex, is(1));

        nc.put(newKey, "val_" + newKey);
        assertThat(nc.minHits, is(0));

        assertThat(nc.get(newKey), is("val_" + newKey));
        assertThat(nc.minHits, is(1));
    }
}