/**
 * CW
 * lab1 task4_5
 * Yaroslav Yanhol
 */


package lab1;

import java.util.Scanner;
import java.lang.Math;

public class t4_5 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    double x1 = scanner.nextDouble();
    double y1 = scanner.nextDouble();
    double x2 = scanner.nextDouble();
    double y2 = scanner.nextDouble();
    double x3 = scanner.nextDouble();
    double y3 = scanner.nextDouble();

    double AB = getLength(x1, y1, x2, y2);
    double BC = getLength(x2, y2, x3, y3);
    double CA = getLength(x3, y3, x1, y1);

    double area = TrArea(AB, BC, CA);

    System.out.println("Area: " + area);

    scanner.close();

    }

    // Довжина відрізку
    public static double getLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Площа за Герона
    public static double TrArea(double AB, double BC, double CA) {
        double p = (AB + BC + CA) / 2.0;
        return Math.sqrt(p * (p - AB) * (p - BC) * (p - CA));
    }
    
}