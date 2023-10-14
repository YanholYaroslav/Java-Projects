/**
 * CW5
 * lab3 task1_2
 * Yaroslav Yanhol
 */

package lab3.CW5;

import java.util.Scanner;

public class t1_2 {
    static public void main(String args[]){

        int n_arr[] = new int[10000];
        Scanner user_inp = new Scanner(System.in);
        int num = 1;
        int ind = 0;

        System.out.println("Enter integer nums. End with 0: ");
        while (num != 0){
            n_arr[ind] = user_inp.nextInt();
            num = n_arr[ind];
            ind++;
        }
        
        user_inp.close();
        max(n_arr);
        min(n_arr);
        
    }

    static void min(int arr[]){  

        int min = arr[0];  
        for(int i = 1; i < arr.length; i++){

            if (min > arr[i])
            min = arr[i];
        }
        System.out.println("Min is: " + min);

    }

    static void max(int arr[]){  

        int max = arr[0];  
        for(int i = 1; i < arr.length; i++){

            if (max < arr[i])
            max = arr[i];
        } 
        System.out.println("Max is: " + max);

    }

}
