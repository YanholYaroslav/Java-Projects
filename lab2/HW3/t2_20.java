/**
 * HW3
 * lab2 task2_20
 * Yaroslav Yanhol
 */

package lab2.HW3;

import java.util.Scanner;

public class t2_20 {
    
    public static void main(String[] args) {

        Scanner user_inp = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int a = user_inp.nextInt();
        user_inp.close();

        System.out.println("Binary: " + int_to_le(a));

    }

    public static String int_to_le(int a){

        String res = "";
        int mask = 0x7F;

        while (a > 0) {
            int bv = a & mask;
            String unf_s = Integer.toBinaryString(bv);

            while (unf_s.length() < 7){
                unf_s = "0" + unf_s;
            }

            res += unf_s + " ";
            a >>>= 7;
        }

        return String.format(res);

    }

}
