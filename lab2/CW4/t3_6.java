/**
 * CW4
 * lab2 task3_6
 * Yaroslav Yanhol
 */


package lab2.CW4;

import java.util.Random;

public class t3_6 {
    public static void main(String[] args) {

        int n = 1000000;
        int won = CoinGame(n);
        double prob = (double) won/n;
        System.out.println("Alice does less attempts with probability: " + prob);

    }

    public static int CoinGame(int n){

        Random r_gen = new Random();
        int AliceWon = 0;

        for (int i = 0; i < n; i++)
        {

            Boolean AliceCond1 = false;
            Boolean AliceCond2 = false;
            Boolean BobCond1 = false;

            while (true)
            {

                Boolean drop = r_gen.nextBoolean();
                if (drop && AliceCond1){
                    AliceCond2 = true;
                } else if (drop && AliceCond1 == false){
                    AliceCond1 = true;
                } else {
                    AliceCond1 = false;
                    AliceCond2 = false;
                }

                drop = r_gen.nextBoolean();
                if (drop == false && BobCond1){
                    break;
                } else if (drop && BobCond1){
                    BobCond1 = false;
                } else if (drop && BobCond1 == false){
                    BobCond1 = true;
                }
                
                if (AliceCond2){
                    AliceWon++;
                    break;
                }

            }
        }
        return AliceWon;
    }

}
