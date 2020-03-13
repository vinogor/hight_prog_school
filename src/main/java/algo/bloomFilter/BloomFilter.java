package algo.bloomFilter;

public class BloomFilter {
    public int filter_len;
    public int bitArray;

    public BloomFilter(int f_len) {
        filter_len = f_len;

        // создаём битовый массив длиной f_len ...
        bitArray = 0b0000_0000_0000_0000_0000_0000_0000_0000;
    }

    // хэш-функции
    public int hash1(String str1) {
        // 17
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
        }
        // реализация ...
        return 0;
    }

    public int hash2(String str1) {
        // 223
        // реализация ...
        return 0;
    }

    public void add(String str1) {
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        return false;
    }

    public static void main(String[] args) {

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