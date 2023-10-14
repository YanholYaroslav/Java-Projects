/**
 * CW5
 * lab3 task1_24
 * Yaroslav Yanhol
 */

package lab3.CW5;

import java.util.Scanner;
import java.lang.Math;

public class t1_24 {
    static public void main(String args[]){

        Scanner user_inp = new Scanner(System.in);

        System.out.println("Enter amount of items: ");
        int n = user_inp.nextInt();
        System.out.println("Enter max weight of backpack: ");
        int m = user_inp.nextInt();
        System.out.println("Enter items weight values sep by space: ");
        int n_arr[] = new int[n];
        for (int i = 0; i < n; i++){
            n_arr[i] = user_inp.nextInt();
        }

        user_inp.close();

        int result = optiWeight(n, n_arr, m);
        System.out.println("Max weight: " + result);

    }

    static public int optiWeight(int n, int items_arr[], int weight){

        if (n == 0 || weight == 0) {
            return 0;
        }

        if (items_arr[n - 1] > weight) {
            return optiWeight(n - 1, items_arr, weight);
        } else {
            int include = items_arr[n - 1] + optiWeight(n - 1, items_arr, weight - items_arr[n - 1]);
            int exclude = optiWeight(n - 1, items_arr, weight);
            return Math.max(include, exclude);
        }

    }

}
