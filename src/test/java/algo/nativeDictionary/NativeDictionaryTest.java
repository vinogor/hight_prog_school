package algo.nativeDictionary;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class NativeDictionaryTest {

    private NativeDictionary<Integer> nd;

    @Before
    public void setUp() {
        nd = new NativeDictionary<>(19, Integer.class);
    }

    @Test // когда пусто
    public void isKey_01() {
        boolean res = nd.isKey("");
        assertThat(res, is(false));
    }

    @Test // когда единственный ключ, ищем его
    public void isKey_02() {
        nd.put("1", 1);

        boolean res = nd.isKey("1");
        assertThat(res, is(true));
    }

    @Test // когда единственный ключ, но не тот
    public void isKey_03() {
        nd.put("1", 1);

        boolean res = nd.isKey("2");
        assertThat(res, is(false));
    }
    @Test // когда есть единственный ключ, ищем другой но с таким же хэш
    public void isKey_04() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));

        boolean res = nd.isKey(newKey);
        assertThat(res, is(false));
    }

    @Test // когда ключей несколько, ищем один из них
    public void isKey_05() {
        nd.put("1", 1);
        nd.put("2", 2);
        nd.put("3", 3);

        boolean res = nd.isKey("2");
        assertThat(res, is(true));
    }

    @Test // когда ключей несколько, ищем не существующий
    public void isKey_06() {
        nd.put("1", 1);
        nd.put("2", 2);
        nd.put("3", 3);

        boolean res = nd.isKey("4");
        assertThat(res, is(false));
    }

    @Test // когда ключ налл
    public void isKey_07() {
        nd.put("1", 1);
        nd.put("2", 2);
        nd.put("3", 3);

        boolean res = nd.isKey(null);
        assertThat(res, is(false));
    }

    @Test // когда всё заполнено, а нужного ключа нет
    public void isKey_08() {
        int value = 0;
        nd.put("a", value);
        value++;

        char ch = "a".toCharArray()[0];

        // заполняем до отказа
        while (nd.counter != nd.size) {
            ch = (char) (ch + 19);
            nd.put(String.valueOf(ch), value);
            value++;
        }

        System.out.println(nd);

        boolean res = nd.isKey("aaa");
        assertThat(res, is(false));
    }

    @Test // когда всё заполнено, искомый ключ есть
    public void isKey_09() {
        int value = 0;
        nd.put("a", value);
        value++;

        char ch = "a".toCharArray()[0];

        // заполняем до отказа
        while (nd.counter != nd.size) {
            ch = (char) (ch + 19);
            nd.put(String.valueOf(ch), value);
            value++;
        }

        System.out.println(nd);

        boolean res = nd.isKey("ğ");
        assertThat(res, is(true));
    }

    @Test // просто положили
    public void put_01() {
        nd.put("1", 1);
        assertThat(nd.counter, is(1));
        assertThat(nd.slots[11], is("1"));
        assertThat(nd.values[11], is(1));
    }

    @Test // перезапись ключа
    public void put_02() {
        nd.put("1", 1);
        nd.put("1", 11);
        assertThat(nd.counter, is(2));
        assertThat(nd.slots[11], is("1"));
        assertThat(nd.values[11], is(11));
        assertThat(nd.slots[14], nullValue());
        assertThat(nd.values[14], nullValue());
    }

    @Test // разные ключи, одинаковый хэш
    public void put_03() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));
        nd.put(newKey, 11);

        System.out.println(nd);
        assertThat(nd.counter, is(2));
        assertThat(nd.slots[11], is("1"));
        assertThat(nd.values[11], is(1));
        assertThat(nd.slots[14], is(newKey));
        assertThat(nd.values[14], is(11));
    }

    @Test // попытка положить с ключём налл
    public void put_04() {
        nd.put(null, 1);
        assertThat(nd.counter, is(0));
    }

    @Test // достаём из пустого
    public void get_01() {
        Integer res = nd.get("1");
        assertThat(res, nullValue());
    }

    @Test // достаём единственный
    public void get_02() {
        nd.put("1", 1);
        Integer res = nd.get("1");
        assertThat(res, is(1));
    }

    @Test // достаём когда лежит 1, да не тот
    public void get_03() {
        nd.put("1", 1);
        Integer res = nd.get("2");
        assertThat(res, nullValue());
    }

    @Test // достаём когда лежит с таким же хэш, да не тот
    public void get_04() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));
        Integer res = nd.get(newKey);
        assertThat(res, nullValue());
    }

    @Test // достаём когда лежат 2 с одинак хэшами, но только 1 подходит
    public void get_05() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));
        nd.put(newKey, 11);

        Integer res = nd.get(newKey);
        assertThat(res, is(11));

        res = nd.get("1");
        assertThat(res, is(1));
    }
}