package algo.nativeCache;

import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;  // ключи
    public T[] values;      // значения
    public int[] hits;      // кол-во обращений к ключам
    int counter;

    public NativeCache(int size, Class clazz) {
        this.size = size;
        this.slots = new String[size];
        this.values = (T[]) Array.newInstance(clazz, this.size);
        this.counter = 0;
    }
}