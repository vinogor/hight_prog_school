package algo;

import java.lang.reflect.Array;

// 1. Нам потребуются такие базовые методы:
// - формирование блока памяти заданного размера: MakeArray(int new_capacity). Метод меняет размер массива array,
//   копируя при необходимости текущие объекты вышеописанным способом;
// - получение объекта по его индексу GetItem(int i). В этот метод встроим проверку корректности
//   в рамках границ, и генерацию соответствующего исключения, если обращение некорректно;
// - добавление нового элемента в конец массива, метод Append(item) .
//
// Важно. В тестах используется схема, когда увеличение буфера происходит в два раза,
// а уменьшение в полтора раза (текущее значение размера буфера делится на 1.5, и
// результат приводится к целому типу). При этом сохраняем минимальную ёмкость 16 элементов.
// Придерживайтесь этой схемы в своём коде для успешного тестирования.

public class DynArray<T> {
    public T[] array;
    public int count;    // текущее кол-во
    public int capacity; // ёмкость
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        // new DynArray<Integer>(Integer.class);
        count = 0;
        capacity = 16;
        makeArray(capacity);
    }

    public void makeArray(int new_capacity) {
        // если создаём первый раз
        if (array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        } else {
            // создаём массив с новой ёмкостью
            T[] newArr = (T[]) Array.newInstance(this.clazz, new_capacity);
            // копируем старый в новый
            System.arraycopy(array, 0, newArr, 0, array.length);
            array = newArr;
            capacity = new_capacity;
        }
    }

    public T getItem(int index) {
        if (index < 0 || index > count - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    // добавление элемента в КОНЕЦ массива
    public void append(T itm) {
        // если всё уже заполнено, то удвояем массив
        if (capacity == count) {
            makeArray(capacity * 2);
        }
        array[count] = itm;
        count++;
    }

    public void insert(T itm, int index) {
        // ваш код
    }

    // уменьшаем в 1,5
    // но не менее 16
    public void remove(int index) {
        // ваш код
    }

}