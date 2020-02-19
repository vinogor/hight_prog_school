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
//
// 2. Добавьте метод Insert(item, i), который вставляет в i-ю позицию объект item, сдвигая вперёд все последующие
//    элементы. Учтите, что новая длина массива может превысить размер буфера.
//
// 3. Добавьте метод Remove(i), который удаляет объект из i-й позиции, при необходимости выполняя сжатие буфера.
//
// В обоих случаях, если индекс i лежит вне допустимых границ, генерируйте исключение.
//
// Важно, единственное исключение: для метода Insert() параметр i может принимать значение,
// равное длине рабочего массива count, в таком случае добавление происходит в его хвост.
//
// 4. Оцените меры сложности для этих двух методов.
//
// 5. Напишите тесты, проверяющие работу методов Insert() и Remove():
//
//    -- вставка элемента, когда в итоге размер буфера не превышен (проверьте также размер буфера);
//    -- вставка элемента, когда в результате превышен размер буфера (проверьте также корректное изменение размера буфера);
//    -- попытка вставки элемента в недопустимую позицию;
//
//    -- удаление элемента, когда в результате размер буфера остаётся прежним (проверьте также размер буфера);
//    -- удаление элемента, когда в результате понижается размер буфера (проверьте также корректное изменение размера буфера);
//    -- попытка удаления элемента в недопустимой позиции.

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
            // копируем старый (полностью) в новый
            System.arraycopy(array, 0, newArr, 0, count);
            array = newArr;
            capacity = new_capacity;
        }
    }

    public T getItem(int index) {
        checkIndex(index);
        return array[index];
    }

    // добавление элемента в КОНЕЦ массива
    public void append(T itm) {
        // если всё уже заполнено, то удвояем массив
        checkCapacity();
        array[count] = itm;
        count++;
    }

    // вставляем В указанный индекс (то что правее - сдвигаем!)
    //      Важно, единственное исключение: для метода Insert() параметр i может принимать значение,
    //      равное длине рабочего массива count, в таком случае добавление происходит в его хвост.
    public void insert(T itm, int index) {

        // допустимый ли индекс?
        if (index < 0 || index > count) {
            throw new ArrayIndexOutOfBoundsException();
        }

        // если вставка за ПОЛНОСТЬЮ заполненный массива
        // (cap X 2, без сдвига)
        if (count == capacity && index == capacity) {
            makeArray(capacity * 2);
        } else
            // если вставка в ПОЛНОСТЬЮ заполненный массив
            // (cap X 2, со сдвигом)
            if (count == capacity) {
                makeArray(capacity * 2);
                System.arraycopy(array, index, array, index + 1, count - index);
            } else
                // если вставка в середину, когда есть место (сдвиг)
                if (index != count) {
                    System.arraycopy(array, index, array, index + 1, count - index);
                }
        // если вставка сразу за конец, когда есть место => просто вставляем (без сдвигов и без увелич ёмкости)

        array[index] = itm;
        count++;
    }


    public void remove(int index) {

        checkIndex(index);

        // если удаление с конца (сдвигать не надо)
        if (index == count - 1) {
            array[index] = null; // обнулим то что удаляем
        } else {
            // удаление через перезапись сдвигом
            System.arraycopy(array, index + 1, array, index, count - index - 1);
            array[count - 1] = null; // обнулим последнюю ячейку
        }
        count--;

        // если есть куда ужимать
        if (capacity > 16) {
            double freeCells = (double) (capacity - count) / capacity;

            // если больше половины ячеек свободно
            if (freeCells > 0.5) {
                int newCapacity = (int) (capacity / 1.5);

                // если ужатие оказалось меньше чем 16
                if (newCapacity < 16) {
                    newCapacity = 16;
                }

                // собственно само ужатие
                makeArray(newCapacity);
            }
        }
    }

        private void checkCapacity () {
            if (capacity == count) {
                makeArray(capacity * 2);
            }
        }

        private void checkIndex ( int index){
            if (index < 0 || index > count - 1) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

    }