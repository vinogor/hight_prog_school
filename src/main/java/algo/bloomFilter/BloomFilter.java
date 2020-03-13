package algo.bloomFilter;

public class BloomFilter {

    public int filter_len;       // размер в битах
    public int bitArray;         // типо битовый массив для фильтра

    public BloomFilter(int f_len) {
        filter_len = f_len; // будет всё норм работать для максимум = 32 т.к. bitArray - int

        // создаём битовый массив длиной f_len ...
        bitArray = 0b0000_0000_0000_0000_0000_0000_0000_0000;

        System.out.println(getBinaryStringFromInt(bitArray) + " - исх состояние бит массива ");
    }


    // Хэш-функции можно использовать достаточно простые, например версия для строки:
    // организуем цикл до длины строки, результат в этом цикле считаем как его версия с предыдущей итерации,
    // умноженная на случайное число, к которой прибавляетсяfilter_len код очередного символа,
    // и берём результат тут же по МОДУЛЮ ДЛИНЫ ТАБЛИЦЫ.

    public int hash1(String str1) {
        int result = 1;
        int randomNum = 17;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);  // char = 16 bit
            result = (result * randomNum + code) % filter_len;   // от 0 до filter_len - 1
        }
        return result;
    }

    public int hash2(String str1) {
        int result = 1;
        int randomNum = 223;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (result * randomNum + code) % filter_len;
        }
        return result;
    }

    public void add(String str1) {

        int hash1 = hash1(str1);
        System.out.println(hash1 + " - получаем хэш1 ");
        bitArray = bitArray | 1 << (hash1);
        System.out.println(getBinaryStringFromInt(bitArray) + " - бит массив после добавление хэш1 ");

        int hash2 = hash2(str1);
        System.out.println(hash2 + " - получаем хэш1 ");
        bitArray = bitArray | 1 << (hash2);
        System.out.println(getBinaryStringFromInt(bitArray) + " - бит массив после добавление хэш2 ");
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        return false;
    }

    private String getBinaryStringFromInt(int i) {
        // 32 - разрядность
        String str = String.format("%32s", Integer.toBinaryString(i)).replace(" ", "0");
        str = str.replaceAll("(.{4})", "$1 ");
        return str;
    }

    public static void main(String[] args) {

        BloomFilter bf = new BloomFilter(32);
        bf.add("qweqwesd134");
        bf.add("qweqwesdfghd134");
/*

        int x = 0b1111_1111_1111_1111_1111_1111_1111_1111;
        int y = 0b1011_1111_1111_1111_1111_1111_1111_1111;

        System.out.println(x);
        System.out.println(y);

        System.out.println();
        System.out.println("          " + 0 + " = " + Integer.toBinaryString(0));
        System.out.println("         " + ~0 + " = " + Integer.toBinaryString(~0));
        System.out.println();
        System.out.println(" " + x + " = 0" + Integer.toBinaryString(x));
        System.out.println(-x + " = " + Integer.toBinaryString(-x));
        System.out.println(~x + " = " + Integer.toBinaryString(~x));
        System.out.println((~x + 1) + " = " + Integer.toBinaryString(~x + 1));
*/


        // что делать со знаком? как им управлять?
        // будет ли отрицательные числа? вроде да
        // если нет, то тогда только 31 бит?

        // Хэш-функции можно использовать достаточно простые, например версия для строки:
        // организуем цикл до длины строки, результат в этом цикле считаем как его версия с предыдущей итерации,
        // умноженная на случайное число, к которой прибавляется код очередного символа,
        // и берём результат тут же по МОДУЛЮ ДЛИНЫ ТАБЛИЦЫ.

        // модуль брать через маску?
        // подходит ли int для использования в качестве битового массива? (страший бит?)

        // если размер битового массива должен быть больше 32 (31) бита?
        // может сразу делать на long ???

        // кароче пока всё для инт и менее сделать
    }
}