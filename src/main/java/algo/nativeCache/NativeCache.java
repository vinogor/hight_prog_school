package algo.nativeCache;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;               // общая вместимость
    public String[] slots;         // ключи
    public T[] values;             // значения
    public int[] hits;             // кол-во обращений к ключам
    public int step = 1;           // шаг поиска
    public int counter;            // счётчик эл-ов

    public int minHits;             // минимальное кол-во хитов у эл-та
    public int minHitsIndex;        // индекс эл-та с минимальным хитом

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.hits = new int[size];
        this.counter = 0;
        this.minHits = 0;
        this.minHitsIndex = 0;
    }

    public boolean isKey(String key) {

        if (key == null) {
            return false;
        }

        return (boolean) search(key, null, 0, 1);
    }

    public void put(String key, T value) {

        if (key == null) {
            return;
        }

        boolean result = (boolean) search(key, value, 0, 2);

        if (result) {
            return;
        }

        // если места нет и ключа такого не хранится, то ставим вместо менее хитового
        // (заранее знаем какой и где он)
        slots[minHitsIndex] = key;
        values[minHitsIndex] = value;
        hits[minHitsIndex] = 0;
        minHits = 0;
    }

    // при +1 к хитам, надо актуализировать минимальное кол-во хитов

    public T get(String key) {

        if (key == null) {
            return null;
        }

        Object result = search(key, null, 0, 3);

        return result.equals(false) ? null : (T) result;
    }

    public void searchNewMin(int slotNumber) {
        // текущее минимальное кол-во хитов ТУТ меньше не станет...
        // либо такое же, либо +1
        slotNumber = getNewSlotNumber(slotNumber);

        boolean result = (boolean) search("none", null, slotNumber, 4);

        if (result) {
            return;
        }

        // если в итоге минимальное найденное значение хитов на 1 больше прошлого минимального
        minHits++;
    }

    public Object search(String key, T value, int startSlotNumber, int param) {
        Object result = false;
        int slotNumber = hashFun(key);
        int attempts = 0;

        while (attempts != size) {
            switch (param) {
                case 1:
                    if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {
                        result = true;
                        attempts = size - 1;
                    }
                    break;
                case 2:
                    // запись нового значения
                    if (slots[slotNumber] == null) {
                        slots[slotNumber] = key;
                        values[slotNumber] = value;
                        hits[slotNumber] = 0;  // на всякий случай
                        this.counter++;
                        attempts = size - 1;
                        result = true;
                    } else
                        // перезапись значения
                        if (slots[slotNumber].equals(key)) {
                            values[slotNumber] = value;
                            attempts = size - 1;
                            result = true;
                        }
                    break;
                case 3:
                    // если есть ключ и он равен искомому
                    if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {
                        // обновляем хиты
                        hits[slotNumber]++;
                        // если это был э-т с минимальным кол-ом хитов до вызова этого метода, то
                        if (minHitsIndex == slotNumber) {
                            // поиск нового эл-та с минимальным кол-вом хитов
                            // (но он может остаться по-прежнему самым мин-м)
                            searchNewMin(slotNumber);
                        }
                        result = values[slotNumber];
                        attempts = size - 1;
                    }
                    break;
                case 4:
                    // если мин хитс такое же, то сразу выход (меньше точно станет)
                    if (hits[startSlotNumber] == minHits) {
                        minHitsIndex = startSlotNumber;
                        attempts = size - 1;
                        result = true;
                    }
                    // если на 1 больше, то запоминаем и продолжаем поиск
                    if (hits[startSlotNumber] == minHits + 1) {
                        minHitsIndex = startSlotNumber;
                    }
                    startSlotNumber = getNewSlotNumber(startSlotNumber);
                    break;
            }
            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return result;
    }

    public int getNewSlotNumber(int slotNumber) {
        return (slotNumber + step) % size;
    }

    public int hashFun(String key) {
        int hash = key.hashCode() % size;
        return (hash < 0) ? hash * (-1) : hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb
                    .append("[").append(String.format("%2d", i)).append("]")
                    .append(" key: ").append(String.format("%6s", slots[i]))
                    .append(", value: ").append(String.format("%6s", values[i]))
                    .append(", hits: ").append(String.format("%2s", hits[i]))
                    .append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}