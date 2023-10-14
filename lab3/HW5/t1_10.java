/**
 * CW5
 * lab3 task1_10
 * Yaroslav Yanhol
 */

package lab3.HW5;

import java.util.Scanner;

public class t1_10 {
    
    static public void main(String args[]){

        Scanner user_inp = new Scanner(System.in);

        System.out.println("Enter amount of numbers: ");
        int n = user_inp.nextInt();
        System.out.println("Enter numbers sep by space: ");
        int n_arr[] = new int[n];
        for (int i = 0; i < n; i++){
            n_arr[i] = user_inp.nextInt();
        }

        user_inp.close();


        boolean first_found = false;
        int palindrome = 0;
        for (int num: n_arr) {
            if (isPalindrome(num)) {
                if (first_found) {
                    palindrome = num;
                    break;
                } else {
                    first_found = true;
                    palindrome = num;
                }
            }
        }
        if (first_found) {
            System.out.println("Palindrome found is: " + palindrome);
        } else {
            System.out.println("No palindrome found.");
        }


    }

    public static boolean isPalindrome(int num) {

        String num_str = Integer.toString(num);
        String rev_num_str = new StringBuilder(num_str).reverse().toString();
        return num_str.equals(rev_num_str);

    }

}
