/**
 * CW3
 * lab2 task2_4
 * Yaroslav Yanhol
 */

package lab2.CW3;

import java.util.Scanner;

public class t2_4 {
    public static void main(String[] args) {

        Scanner user_inp = new Scanner(System.in);
        System.out.println("Enter n, m: ");
        int n = user_inp.nextInt();
        int m = user_inp.nextInt();
        user_inp.close();

        int mask = 1 << m;
        int res = n ^ mask;
        System.out.println("New number: " + res);

    }

}
