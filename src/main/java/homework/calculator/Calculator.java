package homework.calculator;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    double a, b;
    String operator;

    public static void main(String[] args) {
        new Calculator().start();
    }

    private void start() {
        System.out.print("Введите число 'a': ");
        a = Double.parseDouble(readLine());
        System.out.print("Выберите оператор '+' '-' '*' '/' '%': ");
        operator = readLine();
        System.out.print("Введите число 'b': ");
        b = Double.parseDouble(readLine());
        System.out.print(calculate(a, b, operator));
    }

    private String calculate(double a, double b, String operator) {
        String string = "";

        switch (operator) {
            case ("+"):
                System.out.print("Результат сложения: " + a + " + " + b + " = ");
                double additionResult = a + b;
                string = String.valueOf(additionResult);
                break;
            case ("-"):
                System.out.print("Частное чисел:  " + a + " - " + b + " = ");
                double subtractionResult = a - b;
                string = String.valueOf(subtractionResult);
                break;
            case ("*"):
                System.out.print("Произведение чисел:  " + a + " * " + b + " = ");
                double multiplyResult = a * b;
                string = String.valueOf(multiplyResult);
                break;
            case ("/"):
                if (b != 0) {
                    System.out.print("Результат деления:  " + a + " / " + b + " = ");
                    double divisionResult = a / b;
                    string = String.valueOf(divisionResult);
                } else {
                    string = "На 0 делить нельзя";
                    return string;
                }
                break;
            case ("%"):
                double result = a % b;
                System.out.print("Остаток от деления: " + a + " % " + b + " = " + result);
                break;
            default:
                string = "Вы ввели неверный оператор";
                return string;
        }
        return string;
    }

    private String readLine() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = null;
        try {
            string = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return string;
    }
}


