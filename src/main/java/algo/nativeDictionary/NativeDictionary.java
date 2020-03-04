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
    public int step = 3; // ???

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];                             // ключ
        values = (T[]) Array.newInstance(clazz, this.size);   // значение
        counter = 0;
    }

    // всегда возвращает корректный индекс слота
    public int hashFun(String key) {
        return key.hashCode() % size;
    }

    // возвращает true если ключ имеется,
    public boolean isKey(String key) {

        if (key == null) {
            return false;
        }

        int slotNumber = hashFun(key);
        int counterAttempts = 0;

        while (counterAttempts != size) {
            // если ключ существует и равен, то
            if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {
                return true;
            }
            counterAttempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return false;
    }

    // "В данном обучающем примере исходим из фиксированного размера ассоциативного массива.
    // В автоматических тестах этот размер гарантированно не будет превышен."
    public void put(String key, T value) {

        if (key == null) {
            return;
        }

        // если есть куда вставлять (ну на всякий случай)
        if (counter != size) {

            int slotNumber = hashFun(key);
            int counterAttempts = 0;

            while (counterAttempts != size) {

                // если слот пуст или с таким же ключом, то записываем
                if (slots[slotNumber] == null || slots[slotNumber].equals(key)) {
                    slots[slotNumber] = key;
                    values[slotNumber] = value;
                    counter++;
                    break;
                }
                counterAttempts++;
                slotNumber = getNewSlotNumber(slotNumber);
            }
        }
    }

    // возвращает value для key,
    // или null если ключ не найден
    public T get(String key) {

        int slotNumber = hashFun(key);
        int counterAttempts = 0;

        while (counterAttempts != size) {
            // если ключ существует и равен, то
            if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {
                return values[slotNumber];
            }
            counterAttempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return null;
    }

    private int getNewSlotNumber(int slotNumber) {
        return (slotNumber + step) % size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append("[").append(i).append("] ").append(slots[i]).append(" : ").append(values[i]).append(", ");
        }
        return sb.toString();
    }
}