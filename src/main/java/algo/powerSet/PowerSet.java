package algo.powerSet;


public class PowerSet {

    public String[] values;
    public int size;
    public int step;
    public int counter;

    // ваша реализация хранилища
    // В реализации используйте вариант с фиксированным размером хэш-таблицы на 20,000 значений строкового типа.
    public PowerSet() {
        this.size = 20_000;
        this.values = new String[this.size];
        this.step = 3;
        this.counter = 0;
    }

    public int hashFun(String key) {
        int hash = key.hashCode() % size;
        return (hash < 0) ? hash * (-1) : hash;
    }

    public int size() {
        return counter;
    }

    // не должен допускать добавление уже существующего в множестве значения
    // всегда срабатывает
    public void put(String value) {

        if (value == null) {
            return;
        }

        int slotNumber = hashFun(value);
        int attempts = 0;

        while (attempts != size) {

            // если слот не занят, то записываем и завершаем метод
            if (values[slotNumber] == null) {
                values[slotNumber] = value;
                this.counter++;
                break;
            // если такое значение уже есть то завершаем метод
            } else if (values[slotNumber].equals(value)) {
                break;
            }

            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }

    }

    private int getNewSlotNumber(int slotNumber) {
        return (slotNumber + step) % size;
    }

    public boolean get(String value) {
        // возвращает true если value имеется в множестве,
        // иначе false
        return false;
    }

    public boolean remove(String value) {
        // возвращает true если value удалено
        // иначе false
        return false;
    }

    public PowerSet intersection(PowerSet set2) {
        // пересечение текущего множества и set2
        return null;
    }

    public PowerSet union(PowerSet set2) {
        // объединение текущего множества и set2
        return null;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        return null;
    }

    public boolean isSubset(PowerSet set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        return false;
    }
}