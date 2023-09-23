/**
 * HW
 * lab1 task4_6g (є)
 * Yaroslav Yanhol
 */

package HW2;

import java.lang.Math;
import java.util.Scanner;

public class t4_6g {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter x: ");
    double x = scanner.nextDouble();

    double r1 = sigmoid_func(x);
    double r2 = sigmoid_deriv_func(x);
    System.out.println("sigmoid_func result: " + r1);
    System.out.println("sigmoid_deriv_func result: " + r2);

    scanner.close();

    }

    // Функція sigmoid
    public static double sigmoid_func(double x) {
        return Math.pow((1 + Math.exp(-x)), -1);
    }

    // Функція похідної sigmoid
    public static double sigmoid_deriv_func(double x) {
        return Math.exp(x)/Math.pow((Math.exp(x) + 1), 2);
    }

}
