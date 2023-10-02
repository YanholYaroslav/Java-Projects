/**
 * HW3
 * lab2 task2_10
 * Yaroslav Yanhol
 */

package lab2.HW3;

import java.util.Scanner;

public class t2_10 {

    public static void main(String[] args) {

        Scanner user_inp = new Scanner(System.in);
        System.out.println("Enter two long ints: ");
        Long a = user_inp.nextLong();
        Long b = user_inp.nextLong();
        user_inp.close();

        Long c = long_add(a, b);
        Long d = long_subtract(a, b);
        System.out.println("Sum is: " + c);
        System.out.printf("Difference is: " + d);

    }

    public static long long_add(long a, long b) {

        while (b != 0) {
            long mask = a & b;
            a = a ^ b;
            b = mask << 1;
        }
        return a;

    }

    public static long long_subtract(long a, long b) {
        while (b != 0) {
            long mask = (~a) & b;
            a = a ^ b;
            b = mask << 1;
        }
        return a;
    }

}
