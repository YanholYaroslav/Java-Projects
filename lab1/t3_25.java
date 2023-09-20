/**
 * HW
 * lab1 task3_25
 * Yaroslav Yanhol
 */

package lab1;

import java.lang.Math;
import java.util.Scanner;

public class t3_25 {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter point (x0, y0) sep by space: ");
    double x0 = scanner.nextDouble();
    double y0 = scanner.nextDouble();

    System.out.println("\na) Enter point (x, y) sep by space: ");
    double x1 = scanner.nextDouble();
    double y1 = scanner.nextDouble();
    double l1 = getLen(x0, y0, x1, y1);
    System.out.println("Distance is: " + l1);

    System.out.println("\nb) Enter line (a, b, c) sep by space: ");
    double a = scanner.nextDouble();
    double b = scanner.nextDouble();
    double c = scanner.nextDouble();
    double l2 = getDistToLine(a, b, c, x0, y0);
    System.out.println("Distance is: " + l2);
    
    System.out.println("\nc) Enter parameters for lines (a2, b1, c) sep by space: ");
    double a1 = 1;
    double b2 = 1;
    double a2 = scanner.nextDouble();
    double b1 = scanner.nextDouble();
    double c1 = scanner.nextDouble();
    double[] l3 = getIntersect(a1, b1, c1, a2, b2, c1);
    if (l3 != null) {
        System.out.println("Point (" + l3[0] + ", " + l3[1] + ")");
    } else {
        System.out.println("The lines are parallel. There is no intersection here");
    }

    scanner.close();
    }


    // Відстань між двома точками
    public static double getLen(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // Відстань від точки до прямої
    public static double getDistToLine(double a, double b, double c, double x0, double y0) {
        return Math.abs((a * x0 + b * y0 + c)) / Math.sqrt(a * a + b * b);
    }
    
    // Координати точки перетину двох прямих
    public static double[] getIntersect(double a1, double b1, double c1,
                                        double a2, double b2, double c2) {

        if (a2*b1 == 1) {
            return null;
        } else {
            double x = (c2 * b1 - c1 * b2) / (a1 * b2 - a2 * b1);
            double y = (a1 * c2 - a2 * c1) / (a1 * b2 - a2 * b1);
            return new double[]{x, y};
        }
    }

}
