/**
 * CW5
 * lab3 task1_4
 * Yaroslav Yanhol
 */

package lab3.CW5;

import java.util.Scanner;

public class t1_4 {
    static public void main(String args[]){

        Scanner user_inp = new Scanner(System.in);

        System.out.println("Enter amount of values: ");
        int n = user_inp.nextInt();
        System.out.println("Enter values sep by space: ");
        int n_arr[] = new int[n];
        for (int i = 0; i < n; i++){
            n_arr[i] = user_inp.nextInt();
        }

        /*
        int ind = 0;
        while (true){
            try {
                n_arr[ind] = user_inp.nextInt();
                ind++;
            } catch (Exception e) {
                break;
                }
        }
        */

        user_inp.close();
        
        int max_num = n_arr[0];
        int tmp = n_arr[0];
        int count = 1;
        int max_count = 1;
        for (int i = 1; i < n_arr.length; i++) {

            if (n_arr[i] == tmp) {
                count++;
            } else {
                tmp = n_arr[i];
                count = 1;
            }
        
            if (count > max_count) {
                max_count = count;
                max_num = tmp;
            } else if (count == max_count && tmp > max_num) {
                max_num = tmp;
            }

        }

        System.out.printf("%d times in a row value \"%d\" has revealed.\n", max_count, max_num);
        
    }

}
