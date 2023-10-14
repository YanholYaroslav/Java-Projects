/**
 * CW5
 * lab3 task1_14
 * Yaroslav Yanhol
 */

package lab3.HW5;

import java.util.Scanner;

public class t1_14 {
    static public void main(String args[]){

        System.out.println("Choose a number from 1 to 1000000!");
        int l = 1;
        int r = 1000000;
        int question_limit = 20;

        Scanner user_inp = new Scanner(System.in);
        while (question_limit > 0) {

            if (l > r) {
                System.out.println("I asked you to choose a number from 1 to 1000000. That's not fair!");
                System.out.println("Number of attempts: " + (20 - question_limit + 1) + ". It doesn't count anymore!");
                break;
            }

            int num = (l + r) / 2;
            System.out.println("The number is: " + num + ". (Enter '<', '>' or 'yes'):");

            String userAnswer = user_inp.nextLine();

            if (userAnswer.equals("yes")) {
                System.out.println("Success! The number is: " + num);
                System.out.println("Number of attempts: " + (20 - question_limit + 1));
                break;
            } else if (l == r) {
                System.out.println("There is no other option here! The number is: " + l);
                System.out.println("Number of attempts: " + (20 - question_limit + 1));
                break;
            } else if (userAnswer.equals("<")) {
                r = num - 1;
            } else if (userAnswer.equals(">")) {
                l = num + 1;
            } else {
                System.out.println("Please, enter '<', '>' or 'yes'.");
                continue;
            }

            

            question_limit--;
            System.out.println("Attempts left: " + question_limit);

        }
        user_inp.close();

        if (question_limit <= 0) {
            System.out.println("it's a fail. Question limit exceeded.");
        }

    }

}
