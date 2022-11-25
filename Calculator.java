import java.util.InputMismatchException;
import java.util.Scanner;
import java.lang.NumberFormatException;
import java.lang.ArrayIndexOutOfBoundsException;
public class Calculator {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char znak;
    static int result;

    static boolean x= true;

    public static void main (String[] args) throws Exception {
        String console = scanner.nextLine();
        char[] array = new char[10];
        for (int i = 0; i < console.length(); i++) {
            array[i] = console.charAt(i);//заполняем массив введенными символами
            if (array[i] == '+') {
                znak = '+';
            }
            if (array[i] == '-') {
                znak = '-';
            }
            if (array[i] == '*') {
                znak = '*';
            }
            if (array[i] == '/') {
                znak = '/';
            }
        }
        String under_charString = String.valueOf(array);//переводим char в string
        String[] blacks = under_charString.split("[+-/*]");//делим по знаку
        String variable1 = null;
        String variable2 = null;
        try{
            variable1 = blacks[0];
            variable2 = blacks[1];}
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Неверный знак");
            System.exit(0);
        }
        String variable3 = variable2.trim();

        number1 = romanToNumber(variable1);
        number2 = romanToNumber(variable3);
        if((number1 < 0 && number2 > 0) || (number2 < 0 && number1 > 0)){
            throw new Exception("Разные системы счисления");//разные системы счисления
        }
        try{
            number1 = Integer.parseInt(variable1);
            number2 = Integer.parseInt(variable3);}

        catch (InputMismatchException | NumberFormatException e) {

            if (number1 > 0 && number2 >0 && number1 < 11 && number2 < 11) {
                result = calculat(number1, number2, znak);
                System.out.println("Результат для римских цифр");
                String resultRoman = convertNumToRimskie(result);
                System.out.println(variable1 + " " + znak + " " + variable3 + " = " + resultRoman);
                System.exit(0);
            }
            else {
                System.out.println("Неверный формат данных");
                System.exit(0);
            }
        }
        if (number1 < 0 && number2 < 0) {
            result = 0;
        }
        if((number1 > 10) || (number2 > 10)) {
            throw new Exception("Неверные числа");//введены числа больше 10
        }
        result = calculat(number1, number2, znak);
        System.out.println("Результат для арабских цифр");
        System.out.println(number1 + " " + znak + " " + number2 + " = " + result);
    }
    private static String convertNumToRimskie (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        final String s = roman[numArabian];
        return s;
    }
    private static int romanToNumber (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Неверный формат ");
        }
        return -1;
    }
    public static int calculat (int num1, int num2, char operation) {
        int result = 0;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try {
                    result = num1 / num2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Нельзя делить на ноль");
                    System.exit(0);
                    break;
                }
                break;
        }
        return result;
    }
}
