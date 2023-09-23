/**
 * CW
 * lab1 task2_1
 * Yaroslav Yanhol
 */

package CW2;

import java.util.Scanner;

public class t2_1 {
    public static void main(String[] args) {
        System.out.println("Введіть прізвище");
        
        Scanner user_inp = new Scanner(System.in);
        String prizw = user_inp.nextLine();

        System.out.println("Привіт, " + prizw);

        user_inp.close();
    }
}
