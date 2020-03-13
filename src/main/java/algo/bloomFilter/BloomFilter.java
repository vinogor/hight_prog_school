package algo.bloomFilter;

public class BloomFilter {

    public int filter_len;       // размер в битах
    public int bitArray;         // типо битовый массив для фильтра

    public BloomFilter(int f_len) {
        filter_len = f_len; // будет всё норм работать для максимум = 32 т.к. bitArray - int
        bitArray = 0b0000_0000_0000_0000_0000_0000_0000_0000;

        System.out.println(getBinaryStringFromInt(bitArray) + " - исх состояние бит массива ");
    }

    public int hash1(String str1) {
        int result = 0;
        int randomNum = 17;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = (result * randomNum + code) % filter_len;   // от 0 до filter_len - 1
        }
        return result;
    }

    public int hash2(String str1) {
        int result = 0;
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
        bf.add("0123456789");
        bf.add("1234567890");

    }
}