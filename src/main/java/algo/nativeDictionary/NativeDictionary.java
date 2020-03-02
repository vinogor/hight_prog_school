package algo.nativeDictionary;

// 1. Выясните, как в языке программирования, которым вы пользуетесь, реализован тип данных Словарь.
// 2. Реализуйте класс NativeDictionary, как описано выше.
// 3. Добавьте в этот класс три метода:
//    - put(key, value) - сохранение внутри класса ассоциативного массива пары ключ-значение по описанной выше схеме;
//    - is_key(key) - проверка, имеется ли в слотах такой ключ;
//    - get(key) - поиск и извлечение значения по ключу, или отсутствие значения, если ключ не найден.
// 4. Сделайте тесты, проверяющие, как работают put(), is_key() и get():
//    - добавление значения по новому ключу и добавление значения по уже существующему ключу с проверками что записалось,
//    - проверка присутствующего и отсутствующего ключей,
//    - извлечение значения по существующему и отсутствующему ключу.

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int counter;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        counter = 0;
    }

    // всегда возвращает корректный индекс слота
    public int hashFun(String key) {
        return key.hashCode() % size;
    }

    // возвращает true если ключ имеется,
    // иначе false
    public boolean isKey(String key) {

        return false;
    }

    // гарантированно записываем
    // значение value по ключу key
    public void put(String key, T value) {

    }

    // возвращает value для key,
    // или null если ключ не найден
    public T get(String key) {

        return null;
    }
}