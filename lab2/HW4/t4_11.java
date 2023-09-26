/**
 * HW4
 * lab2 task4_11
 * Yaroslav Yanhol
 */

package lab2.HW4;

import java.util.Scanner;

public class t4_11 {
    
    public static void main(String[] args){

        System.out.print("Enter an interval [a, b]: ");
        Scanner user_inp = new Scanner(System.in);
        int a = user_inp.nextInt();
        int b = user_inp.nextInt();
        user_inp.close();

        System.out.printf("Armstrong numbers from interval [%d, %d]: \n", a, b);
        for (int i = a; i <= b; i++){
            if (IsArmstrongNumber(i)){
                System.out.printf("%d, ", i);
            }
        }

    }

    public static int[] SplitNumber(int n){

        int res[] = new int[(int)Math.log10(n) + 1];
        int i = (int)Math.log10(n);
        while (n > 0){
            res[i] = n % 10;
            n = n / 10;
            i--;
        }
        return res;

    }

    public static boolean IsArmstrongNumber(int n){

        int digits[] = SplitNumber(n); 
        int sum = 0;
        int p = (int)digits.length;
        for (int i = 0; i < digits.length; i++) {
            sum += Math.pow(digits[i], p);
        }
        return sum == n;

    }

}
