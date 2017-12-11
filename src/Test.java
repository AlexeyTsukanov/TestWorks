import java.util.ArrayList;
import java.util.List;

/*Программа заполняет два массива всеми возможными вариантами простых пятизначных чисел начиная от самого большенго к меньшему.
* Затем перебирает каждый элемент, сумируя их
* после нахождения первого числа - полиндрома(которое является самым большим, т.к. проверка идет от наибольших чисел),
* программа выводит на консоль простые числа и их производное число-полиндром*/

public class Test {
    public static void main(String[] args) {
        List<Integer> array1 = new ArrayList<>();
        List<Integer> array2 = new ArrayList<>();
        inputNumbers(array1);
        array2.addAll(array1);
        sumAndCheck(array1, array2);
    }

    public static List<Integer> inputNumbers(List<Integer> array) {
        for (int i = 99999; i >= 10000; i--) {
            if (isNumberSimple(i)) {
                array.add(i);
            }
        }
        return array;
    }

    private static boolean palindrome(String str) {
        return str.equals(new StringBuilder().append(str).reverse().toString());
    }

    public static boolean isNumberSimple(int N) {
        if (N < 2) return false;
        for (int i = 2; i * i <= N; i++)
            if (N % i == 0) return false;
        return true;
    }

    public static void sumAndCheck(List array1, List array2) {
        for (int i = 0; i < array1.size(); i++) {
            for (int j = 0; j < array2.size(); j++) {
                int num = ((int) array1.get(i)) + ((int) array2.get(j));
                if (palindrome(Integer.toString(num))) {
                    System.out.println("Число 1 = " + array1.get(i));
                    System.out.println("Число 2 = " + array2.get(j));
                    System.out.println("Palindrom = " + num);
                    return;
                }
            }
        }
    }
}
