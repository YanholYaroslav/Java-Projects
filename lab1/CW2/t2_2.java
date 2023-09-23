/**
 * CW
 * lab1 task2_2
 * Yaroslav Yanhol
 */

package CW2;

import java.util.Scanner;

public class t2_2 {
    public static void main(String[] args) {

    System.out.println("Введіть два цілих числа через пробіл: ");
    
    Scanner user_inp = new Scanner(System.in);
    String a = user_inp.next();
    Double b = user_inp.nextDouble();
    user_inp.close();

    int a_l = a.length();
    int b_l = (int)(Math.log10(b) + 1);
    System.out.println("Кількість розрядів числа а = " + a_l + ", b = " + b_l);
    
    Double garm = 1/(1/Double.parseDouble(a) + 1/b);
    System.out.printf("Середнє гармонічне цих чисел = %.2f\n", garm);
    }
}
