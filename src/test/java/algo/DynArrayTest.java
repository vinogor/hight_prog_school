package algo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DynArrayTest {

    private DynArray<Integer> arr;
    private Integer integer1;
    private Integer integer2;
    private Integer integer3;

    @Before
    public void setUp() {
        arr = new DynArray<>(Integer.class);
        integer1 = 1;
        integer2 = 2;
        integer3 = 3;
    }

    @Test
    public void makeArray_01() {
        assertThat(arr.capacity, is(16));
        assertThat(arr.array.length, is(16));
        assertThat(arr.count, is(0));
    }

    @Test
    public void makeArray_02() {
        arr.makeArray(arr.capacity * 2);
        assertThat(arr.capacity, is(32));
        assertThat(arr.array.length, is(32));
        assertThat(arr.count, is(0));
    }

    @Test
    public void getItem_01() {
        arr.array[0] = 0;
        arr.count = 1;
        assertThat(arr.getItem(0), is(0));
    }

    @Test
    public void getItem_02() {
        arr.array[0] = 0;
        arr.array[1] = 1;
        arr.array[2] = 2;
        arr.count = 3;
        assertThat(arr.getItem(1), is(1));
    }

    @Test
    public void getItem_03() {
        arr.array[0] = 0;
        arr.array[1] = 1;
        arr.array[2] = 2;
        arr.count = 3;
        assertThat(arr.getItem(2), is(2));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getItem_04() {
        arr.array[0] = 0;
        arr.array[1] = 1;
        arr.array[2] = 2;
        arr.count = 3;
        arr.getItem(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void getItem_05() {
        arr.array[0] = 0;
        arr.array[1] = 1;
        arr.array[2] = 2;
        arr.count = 3;
        arr.getItem(3);
    }

    @Test
    public void append_01() {
        arr.append(0);
        assertThat(arr.count, is(1));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], nullValue());
    }

    @Test
    public void append_02() {
        arr.append(0);
        arr.append(1);
        assertThat(arr.count, is(2));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], is(1));
        assertThat(arr.array[2], nullValue());
    }

    @Test
    public void append_03() {
        arr.append(0);
        arr.append(1);
        arr.append(2);
        assertThat(arr.count, is(3));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], is(1));
        assertThat(arr.array[2], is(2));
        assertThat(arr.array[3], nullValue());
    }

    @Test
    public void append_04() {
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        arr.append(16);
        assertThat(arr.count, is(17));
        assertThat(arr.array[15], is(15));
        assertThat(arr.array[16], is(16));
        assertThat(arr.array[17], nullValue());
        assertThat(arr.array.length, is(32));
        assertThat(arr.capacity, is(32));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insert_01() {
        arr.insert(0, -1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insert_02() {
        arr.insert(0, 1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void insert_03() {
        arr.append(0);
        arr.insert(0, 2);
    }

    @Test // вставка ЗА пустой массив, в котором есть место
    public void insert_04() {
        arr.insert(0, 0);

        assertThat(arr.count, is(1));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], nullValue());
        assertThat(arr.capacity, is(16));

    }

    @Test // вставка ЗА массив с 1 эл-ом, в котором есть место
    public void insert_05() {
        arr.append(0);
        arr.insert(1, 1);

        assertThat(arr.count, is(2));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], is(1));
        assertThat(arr.array[2], nullValue());
        assertThat(arr.capacity, is(16));
    }

    @Test // вставка ЗА массив с 2 эл-ом, в котором есть место
    public void insert_06() {
        arr.append(0);
        arr.append(1);
        arr.insert(2, 2);

        assertThat(arr.count, is(3));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], is(1));
        assertThat(arr.array[2], is(2));
        assertThat(arr.array[3], nullValue());
        assertThat(arr.capacity, is(16));
    }

    @Test // вставка в начало массива, в котором есть место
    public void insert_07() {
        arr.append(0);
        arr.append(1);
        arr.insert(2, 0);

        assertThat(arr.count, is(3));
        assertThat(arr.array[0], is(2));
        assertThat(arr.array[1], is(0));
        assertThat(arr.array[2], is(1));
        assertThat(arr.array[3], nullValue());
        assertThat(arr.capacity, is(16));
    }

    @Test // вставка в середину массива, в котором есть место
    public void insert_08() {

        arr.append(0);
        arr.append(1);
        arr.insert(2, 1);

        assertThat(arr.count, is(3));
        assertThat(arr.array[0], is(0));
        assertThat(arr.array[1], is(2));
        assertThat(arr.array[2], is(1));
        assertThat(arr.array[3], nullValue());
        assertThat(arr.capacity, is(16));
    }

    @Test // вставка за массив, в котором НЕТ места
    public void insert_09() {
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        arr.insert(16, 16);

        assertThat(arr.count, is(17));
        assertThat(arr.array[15], is(15));
        assertThat(arr.array[16], is(16));
        assertThat(arr.array[17], nullValue());
        assertThat(arr.capacity, is(32));
    }

    @Test // вставка в середину массива, в котором НЕТ места
    public void insert_10() {
        for (int i = 0; i < 16; i++) {
            arr.append(i);
        }
        arr.insert(16, 10);

        assertThat(arr.count, is(17));
        assertThat(arr.array[9], is(9));
        assertThat(arr.array[10], is(16));
        assertThat(arr.array[11], is(10));
        assertThat(arr.array[16], is(15));
        assertThat(arr.array[17], nullValue());
        assertThat(arr.capacity, is(32));
    }

    // вставка

}