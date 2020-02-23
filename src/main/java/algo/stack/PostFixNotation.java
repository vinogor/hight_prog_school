package algo.stack;

//  Постфиксная запись выражения -- это запись, в которой порядок вычислений определяется не скобками и приоритетами,
//  а только позицией элемента в выражении. Например, в выражениях разрешено использовать целые числа и операции + и * .
//  Тогда выражение (1 + 2) * 3 запишется как 1 2 + 3 * (верхушка стека слева)
//
//  Такой стек обрабатывается следующим образом: берём с верхушки объект, если это число, сохраняем во втором стеке,
//  а если операция, выполняем её над двумя верхними элементами второго стека и возвращаем её обратно во второй стек.

import java.util.LinkedList;

public class PostFixNotation {

    // храним числа (целые)
    private LinkedList<Integer> numbers = new LinkedList<>();

    // метод работает, если
    //  - исходное выражение составлено без ошибок
    //  - исходные числа могут быть целые, положительные
    //  - операции + * совершаются только над 2 числами
    //  - элементы выражения разделены пробелами
    public int calculate(String str) {

        char[] chars = str.toCharArray();
        int tempNumber = 0;
        boolean isPrevDigit = false;

        for (char ch : chars) {

            // если это цифра, то начинаем собирать число
            if (Character.isDigit(ch)) {
                if (tempNumber == 0) {
                    tempNumber = Character.getNumericValue(ch);
                } else {
                    tempNumber = tempNumber * 10 + Character.getNumericValue(ch);
                }
                isPrevDigit = true;
            }

            // если это пробел после цифры, то завершаем составление числа и отправляем её в стек
            else if (ch == ' ') {
                if (isPrevDigit) {
                    numbers.push(tempNumber);
                    isPrevDigit = false;
                    tempNumber = 0;
                }
            }

            // если это оператор то делаем операцию и результат возвращаем в стек
            else if (ch == '*') {
                numbers.push(numbers.pop() * numbers.pop());
            } else if (ch == '+') {
                numbers.push(numbers.pop() + numbers.pop());
            } else if (ch == '=') {
                return numbers.pop();
            }
        }

        // чтобы скомпилировалось
        return 0;
    }
}
