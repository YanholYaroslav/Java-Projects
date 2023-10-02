/**
 * CW3
 * lab2 task2_3
 * Yaroslav Yanhol
 */

package lab2.CW3;

import java.util.Scanner;

public class t2_3 {
    
    public static void main(String[] args) {

        Scanner user_inp = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = user_inp.next().charAt(0);

        System.out.println("Binary is: " + char_to_bin(ch));

        user_inp.close();

    }

    public static String char_to_bin(char b){

        String s = "";
        for (int i = 15; i >= 0; i--) {

            boolean bvalue = ((b >> i) & 1) == 1;
            s += (bvalue ? '1' : '0');

        }
        return s;

    }

}
