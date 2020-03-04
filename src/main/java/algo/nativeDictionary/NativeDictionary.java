package algo.nativeDictionary;

import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int counter;
    public int step = 3;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        counter = 0;
    }

    public int hashFun(String key) {
        return key.hashCode() % size;
    }

    public boolean isKey(String key) {

        if (key == null) {
            return false;
        }

        int slotNumber = hashFun(key);
        int counterAttempts = 0;

        while (counterAttempts != size) {
            if (slots[slotNumber] != null && slots[slotNumber].equals(key)) {
                return true;
            }
            counterAttempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return false;
    }

    public void put(String key, T value) {

        if (key == null) {
            return;
        }

        if (counter != size) {

            int slotNumber = hashFun(key);
            int counterAttempts = 0;

            while (counterAttempts != size) {

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

    public T get(String key) {

        int slotNumber = hashFun(key);
        int counterAttempts = 0;

        while (counterAttempts != size) {
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