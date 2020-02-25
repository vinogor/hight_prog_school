package algo.deque;

public class Palindrome {

    // Напишите функцию, которая с помощью Deque проверяет,
    // является ли некоторая строка палиндромом
    // (читается одинаково слева направо и справа налево).

    public boolean check(String str) {

        char[] chars = str.toCharArray();
        Deque<Character> deque = new Deque<>();

        // добавим всю строку в двустороннюю очередь
        for (Character ch : chars) {
            deque.addTail(ch);
        }

        // чекаем на палиндромность
        while (deque.size() > 1) {
            if (deque.removeFront() != deque.removeTail()) {
                return false;
            }
        }
        return true;
    }
}
