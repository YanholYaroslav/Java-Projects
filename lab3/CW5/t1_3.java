/**
 * CW5
 * lab3 task1_3
 * Yaroslav Yanhol
 */

package lab3.CW5;

import java.util.Scanner;

public class t1_3 {
    static public void main(String args[]){

        Scanner user_inp = new Scanner(System.in);

        System.out.println("Enter amount of values: ");
        int n = user_inp.nextInt();
        System.out.println("Enter values sep by space: ");
        int n_arr[] = new int[n];
        for (int i = 0; i < n; i++){
            n_arr[i] = user_inp.nextInt();
        }
        
        user_inp.close();
        
        double m  = mean(n_arr);
        System.out.println("Mean is: " + m);
        double ssd = SSD(n_arr);
        System.out.println("SSD is: " + ssd);

    }

    static public double mean(int arr[]){

        double s = 0;
        for (int i = 0; i < arr.length; i++){
            s += arr[i];
        }
        return s / arr.length;

    }

    static public double SSD(int arr[]){

        double m = mean(arr);
        double s = 0;
        for (int i = 0; i < arr.length; i++){
            s += ((arr[i] - m) * (arr[i] - m));
        }
        return s / arr.length;

    }

}
