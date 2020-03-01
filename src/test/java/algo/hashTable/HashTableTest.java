package algo.hashTable;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

public class HashTableTest {

    private HashTable ht;

    @Before
    public void setUp() {
        ht = new HashTable(19, 3);
    }

    @Test // просто положили
    public void put_01() {
        int res = ht.put("a");

        assertThat(ht.counter, is(1));
        assertThat(res, is(2));
        assertThat(ht.toString(), is("null null a null null null null null null null null null null null null null null null null "));
    }

    @Test // положили с коллизией, проверили шаг
    public void put_02() {
        int res1 = ht.put("a");
        int res2 = ht.put("a");

        assertThat(ht.counter, is(2));
        assertThat(res1, is(2));
        assertThat(res2, is(2 + 3));
        assertThat(ht.toString(), is("null null a null null a null null null null null null null null null null null null null "));
    }

    @Test // положили с коллизией, так чтобы при поиске своб места дошли до конца и вернулись в начало
    public void put_03() {
        ht.put("a");
        ht.put("a");
        ht.put("a");
        ht.put("a");
        ht.put("a");
        ht.put("a");
        ht.put("a");

        assertThat(ht.counter, is(7));
        assertThat(ht.toString(), is("null a a null null a null null a null null a null null a null null a null "));
    }


    @Test
    public void hashFun_01() {
        int res = ht.hashFun("a");
        assertThat(res, is(2));
    }

    @Test
    public void hashFun_02() {
        int res = ht.hashFun("b");
        assertThat(res, is(3));
    }

    @Test // последняя ячейка
    public void hashFun_03() {
        int res = ht.hashFun("q");
        assertThat(res, is(18));
    }

    @Test // перескочим на нулевую
    public void hashFun_04() {
        int res = ht.hashFun("r");
        assertThat(res, is(0));
    }

    @Test // найти что-то в пустой таблице
    public void find_01() {
        int res = ht.find("a");
        assertThat(res, is(-1));
    }

    @Test // найти единственное значение
    public void find_02() {
        ht.put("a");
        int res = ht.find("a");
        assertThat(res, is(2));
    }

    @Test // найти значение среди двух разных с одинаковыми хэш
    public void find_03() {
        ht.put("a");
        ht.put("t");
        int res = ht.find("t");
        assertThat(res, is(2 + 3));
    }

    @Test // найти значение когда вся таблица заполнена ДРУГИМИ значениями с таким же хэш
    public void find_04() {
        int slot = ht.put("a");  // = 2
        char ch = "a".toCharArray()[0];

        // заполняем до отказа
        while (slot != -1) {
            ch = (char) (ch + 19);
            slot = ht.put(String.valueOf(ch));
        }

        int res = ht.find(String.valueOf(ch + 19));
        assertThat(res, is(-1));
    }
}