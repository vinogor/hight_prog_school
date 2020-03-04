package algo.hashTable;

//  В классе HashTable требуется реализовать четыре метода:
//  - хэш-функцию hash_fun(value), которая по входному значению вычисляет индекс слота;
//  - функцию поиска слота seek_slot(value), которая по входному значению сперва рассчитывает
//    индекс слота хэш-функцией, а затем отыскивает подходящий слот с учётом коллизий, или возвращает неудачу, если это не удалось;
//  - put(value), который помещает значение value в слот, вычисляемый с помощью функции поиска;
//  - find(value), который проверяет, имеется ли в слотах указанное значение, и возвращает либо слот, либо признак неудачи.
//
//  Напишите тесты, которые проверяют работу этих четырёх методов.


public class HashTable {
    public int size;        // размер хэш-таблицы, желательно простое число (17, 19)
    public int step;        // шаг поиска свободного слота, например 3 (а почему не один?!)
    public String[] slots;  // массив со слотами, фиксированный размер
    public int counter;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        counter = 0;
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    // всегда возвращает корректный индекс слота
    public int hashFun(String value) {
        int hash = value.hashCode() % size;
        return (hash < 0) ? hash * (-1) : hash;
    }

    // записываем значение по хэш-функции
    public int put(String value) {
        int slotNumber = seekSlot(value);
        if (slotNumber == -1) {
            return -1;
        }
        slots[slotNumber] = value;
        counter++;
        return slotNumber;
    }

    // находит индекс пустого слота для значения, или -1
    public int seekSlot(String value) {

        // если мест нет
        if (counter == size) {
            return -1;
        }

        int slotNumber = hashFun(value);

        // ищем пустой
        while (true) {
            // если пустой, то возвращаем
            if (slots[slotNumber] == null) {
                return slotNumber;
            }
            // берём новый слот с заданным шагом
            slotNumber = getNewSlotNumber(slotNumber);
        }
    }

    // находит индекс слота со значением, или -1
    public int find(String value) {
        int slotNumber = hashFun(value);
        int counterAttempts = 0;

        // ищем
        while (counterAttempts != size) {
            if (slots[slotNumber] != null && slots[slotNumber].equals(value)) {
                return slotNumber;
            }
            counterAttempts++;
            slotNumber = getNewSlotNumber(slotNumber);
        }
        return -1;
    }

    private int getNewSlotNumber(int slotNumber) {
        return (slotNumber + step) % size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(slots[i]).append(" ");
        }
        return sb.toString();
    }
}