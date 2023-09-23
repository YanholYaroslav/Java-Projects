/**
 * CW
 * lab1 task2_3
 * Yaroslav Yanhol
 */

package CW2;

import java.lang.Math;
import java.util.Scanner;

public class t2_3 {
    public static void main(String[] args) {

    System.out.println("Введіть два цілих числа через пробіл: ");

    Scanner user_inp = new Scanner(System.in);
    Float a = user_inp.nextFloat();
    Float b = user_inp.nextFloat();
    user_inp.close();

    Double c = Math.sqrt(a*b);
    System.out.printf("Середнє геометричне у науковому %e та у десятковому %f представленнях.", c, c);
    }
}
