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

    // возвращает true если value имеется в множестве,
    // иначе false
    public boolean get(String value) {

        if (value == null) {
            return false;
        }

        int slotNumber = hashFun(value);
        int attempts = 0;

        while (attempts != size) {

            // если слот не занят, то false
            if (values[slotNumber] == null) {
                return false;
            } else
                // если такое значение уже есть то завершаем метод
                if (values[slotNumber].equals(value)) {
                    return true;
                }

            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }

        return false;
    }

    // возвращает true если value удалено
    // иначе false
    public boolean remove(String value) {

        if (value == null) {
            return false;
        }

        int slotNumber = hashFun(value);
        int attempts = 0;

        while (attempts != size) {

            // если слот не занят, то удалять нечего
            if (values[slotNumber] == null) {
                return false;
            } else
                // если такое значение уже есть то
                if (values[slotNumber].equals(value)) {
                    // удаляем найденное
                    values[slotNumber] = null;
                    counter--;
                    return true;
                }

            attempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }

        return false;
    }

    // пересечение текущего множества и set2
    public PowerSet intersection(PowerSet set2) {

        PowerSet res = new PowerSet();

        for (String str : values) {
            // если значение сущ и оно так же сущ в set2
            if ((str != null) && (set2.get(str))) {
                res.put(str);
            }
        }
        return res;
    }

    // объединение текущего множества и set2
    public PowerSet union(PowerSet set2) {

        PowerSet res = new PowerSet();

        for (String str : values) {
            if (str != null) {
                res.put(str);
            }
        }

        for (String str : set2.values) {
            // если значение сущ
            if (str != null) {
                res.put(str);
            }
        }

        return res;
    }

    // разница текущего множества и set2
    public PowerSet difference(PowerSet set2) {
        PowerSet res = new PowerSet();


        return res;
    }

    public boolean isSubset(PowerSet set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false

        return false;
    }

    private int getNewSlotNumber(int slotNumber) {
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
            String value = values[i];
            if (value != null) {
                sb.append(value).append(" ");
            }
        }
        return sb.toString();
    }
}