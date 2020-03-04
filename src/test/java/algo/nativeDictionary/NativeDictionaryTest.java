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

        assertThat(nd.isKey("1"), is(true));
    }

    @Test // когда единственный ключ, но не тот
    public void isKey_03() {
        nd.put("1", 1);

        assertThat(nd.isKey("2"), is(false));
    }

    @Test // когда есть единственный ключ, ищем другой но с таким же хэш
    public void isKey_04() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));

        assertThat(nd.isKey(newKey), is(false));
    }

    @Test // когда ключей несколько, ищем один из них
    public void isKey_05() {
        nd.put("1", 1);
        nd.put("2", 2);
        nd.put("3", 3);

        assertThat(nd.isKey("2"), is(true));
    }

    @Test // когда ключей несколько, ищем не существующий
    public void isKey_06() {
        nd.put("1", 1);
        nd.put("2", 2);
        nd.put("3", 3);

        assertThat(nd.isKey("4"), is(false));
    }

    @Test // когда ключ налл
    public void isKey_07() {
        nd.put("1", 1);
        nd.put("2", 2);
        nd.put("3", 3);

        assertThat(nd.isKey(null), is(false));
    }

    @Test // когда положили, потом перезаписали
    public void isKey_07_1() {
        nd.put("1", 1);
        nd.put("1", 2);
        nd.put("1", 3);

        System.out.println(nd);
        assertThat(nd.counter, is(1));
        assertThat(nd.isKey("1"), is(true));
    }

    @Test // когда положили, потом перезаписали несколько
    public void isKey_07_2() {
        nd.put("1", 1);
        nd.put("1", 2);
        nd.put("1", 3);
        nd.put("2", 1);
        nd.put("3", 2);
        nd.put("2", 3);

        System.out.println(nd);
        assertThat(nd.counter, is(3));
        assertThat(nd.isKey("1"), is(true));
        assertThat(nd.isKey("2"), is(true));
        assertThat(nd.isKey("3"), is(true));
        assertThat(nd.isKey("4"), is(false));
    }

    @Test // когда всё заполнено с одинак хэш, а нужного ключа нет
    public void isKey_08() {
        nd.put("a", -1);

        char ch = "a".toCharArray()[0];
        System.out.println(nd);

        // заполняем до отказа
        for (int i = 0; i < nd.size; i++) {
            ch = (char) (ch + 19);
            nd.put(String.valueOf(ch), i);
        }

        System.out.println(nd);

        assertThat(nd.isKey("aaa"), is(false));
        assertThat(nd.isKey("a"), is(true));
    }

    @Test // когда всё заполнено, искомый ключ есть
    public void isKey_09() {
        nd.put("a", -1);

        char ch = "a".toCharArray()[0];

        // заполняем до отказа
        for (int i = 0; i < nd.size; i++) {
            ch = (char) (ch + 19);
            nd.put(String.valueOf(ch), i);
        }

        System.out.println(nd);

        assertThat(nd.counter, is(19));
        assertThat(nd.isKey("ğ"), is(true));
        assertThat(nd.isKey("t"), is(true));
    }

    @Test // когда всё заполнено, перезаписано, чекаем все ключи
    public void isKey_09_1() {
        nd.put("a", -1);
        char ch = "a".toCharArray()[0];

        // заполняем до отказа
        for (int i = 0; i < nd.size; i++) {
            ch = (char) (ch + 19);
            nd.put(String.valueOf(ch), i);
        }

        System.out.println(nd);

        assertThat(nd.counter, is(19));
        assertThat(nd.isKey("ğ"), is(true));
        assertThat(nd.isKey("t"), is(true));


        nd.put("a", 0);
        ch = "a".toCharArray()[0];

        // заполняем до отказа
        for (int i = 1; i < nd.size + 1; i++) {
            ch = (char) (ch + 19);
            nd.put(String.valueOf(ch), i);
        }

        System.out.println(nd);

        assertThat(nd.counter, is(19));
        assertThat(nd.isKey("Ņ"), is(true));
        assertThat(nd.isKey("Ó"), is(true));
        assertThat(nd.isKey("a"), is(true));
        assertThat(nd.isKey("Ř"), is(true));
        assertThat(nd.isKey("æ"), is(true));
        assertThat(nd.isKey("t"), is(true));
        assertThat(nd.isKey("ū"), is(true));
        assertThat(nd.isKey("ù"), is(true));
        assertThat(nd.isKey("\u0087"), is(true));
        assertThat(nd.isKey("ž"), is(true));
        assertThat(nd.isKey("Č"), is(true));
        assertThat(nd.isKey("\u009A"), is(true));
        assertThat(nd.isKey("Ƒ"), is(true));
        assertThat(nd.isKey("ğ"), is(true));
        assertThat(nd.isKey("\u00AD"), is(true));
        assertThat(nd.isKey("Ƥ"), is(true));
        assertThat(nd.isKey("Ĳ"), is(true));
        assertThat(nd.isKey("À"), is(true));
        assertThat(nd.isKey("Ʒ"), is(true));

        assertThat(nd.isKey("1"), is(false));
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
        assertThat(nd.counter, is(1));
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
        assertThat(nd.slots[(11 + nd.step) % nd.size], is(newKey));
        assertThat(nd.values[(11 + nd.step) % nd.size], is(11));
    }

    @Test // попытка положить с ключём налл
    public void put_04() {
        nd.put(null, 1);
        assertThat(nd.counter, is(0));
    }

    @Test // достаём из пустого
    public void get_01() {
        Integer res = nd.get("1");
        assertThat(nd.counter, is(0));
        assertThat(res, nullValue());
    }

    @Test // достаём единственный
    public void get_02() {
        nd.put("1", 1);
        Integer res = nd.get("1");
        assertThat(nd.counter, is(1));
        assertThat(res, is(1));
    }

    @Test // достаём когда лежит 1, да не тот
    public void get_03() {
        nd.put("1", 1);
        Integer res = nd.get("2");
        assertThat(nd.counter, is(1));
        assertThat(res, nullValue());
    }

    @Test // достаём когда лежит с таким же хэш, да не тот
    public void get_04() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));
        Integer res = nd.get(newKey);
        assertThat(nd.counter, is(1));
        assertThat(res, nullValue());
    }

    @Test // достаём когда лежат 2 с одинак хэшами, но только 1 подходит
    public void get_05() {
        nd.put("1", 1);
        String newKey = String.valueOf((char) ("1".toCharArray()[0] + nd.size));
        nd.put(newKey, 11);
        assertThat(nd.counter, is(2));

        Integer res = nd.get(newKey);
        assertThat(res, is(11));

        res = nd.get("1");
        assertThat(res, is(1));
    }
}