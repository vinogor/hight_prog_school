package algo.nativeCache;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;        // общая вместимость
    public String[] slots;  // ключи
    public T[] values;      // значения
    public int[] hits;      // кол-во обращений к ключам
    public int step = 1;    // шаг поиска
    int counter;            // счётчик эл-ов

    int minHits;             // минимальное кол-во хитов у эл-та
    int minHitsIndex;        // индекс эл-та с минимальным хитом

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.counter = 0;
        this.minHits = 0;
        this.minHitsIndex = 0;
    }

    public int hashFun(String key) {
        int hash = key.hashCode() % size;
        return (hash < 0) ? hash * (-1) : hash;
    }

    public boolean isKey(String key) {

        if (key == null) {
            return false;
        }

        int slotNumber = hashFun(key);
        int attempts = 0;

        while (attempts != size) {
            if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {
                return true;
            }
            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return false;
    }

    public void put(String key, T value) {

        if (key == null) {
            return;
        }

        int slotNumber = hashFun(key);
        int attempts = 0;

        while (attempts != size) {

            // запись нового значения
            if (slots[slotNumber] == null) {
                slots[slotNumber] = key;
                values[slotNumber] = value;
                this.counter++;
                break;
            } else

                // перезапись значения
                if (slots[slotNumber].equals(key)) {
                values[slotNumber] = value;
                break;
            }

            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }

        // если места нет и ключа такого нет, то ставим вместо менее хитового
        // (заранее знаем какой и где он)
        slots[minHitsIndex] = key;
        values[minHitsIndex] = value;
        hits[minHitsIndex] = 0;
        minHits = 0;
        // сможем ли мы его получить? Хэшкод то другой...
        // вроде да, но перебором

    }

    // при +1 к хитам, надо актуализировать минимальное кол-во хитов
    public T get(String key) {

        int slotNumber = hashFun(key);
        int attempts = 0;

        while (attempts != size) {

            // если есть ключ и он равен искомому
            if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {

                // обновляем хиты
                hits[slotNumber]++;
                // если это был э-т с минимальным кол-ом хитов в прошлом, то
                if (minHitsIndex == slotNumber) {
                    // поиск нового эл-та с минимальным кол-вом хитов
                    // (но он может остаться по-прежнему самым мин-м)
                    searchNewMin(slotNumber);
                }

                return values[slotNumber];
            }
            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return null;
    }

    private void searchNewMin(int slotNumber) {
        slotNumber = getNewSlotNumber(slotNumber);
        int attempts = 1; // ??? если = 0, последния попытка сравнивает с самим собой
        while (attempts != size) {
            if (hits[slotNumber] < minHits) {
                minHits = hits[slotNumber];
                minHitsIndex = slotNumber;
                break;
            }
            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
    }

    private int getNewSlotNumber(int slotNumber) {
        return (slotNumber + step) % size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb
                    .append("[").append(i).append("] ")
                    .append("key: ").append(slots[i])
                    .append("value: ").append(values[i])
                    .append("hits: ").append(hits[i])
                    .append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
}