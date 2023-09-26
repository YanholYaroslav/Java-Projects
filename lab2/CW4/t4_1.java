/**
 * CW4
 * lab2 task4_1
 * Yaroslav Yanhol
 */


//package lab2.CW4;

import java.util.HashMap;
import java.util.Map;

public class t4_1 {
    public static void main(String[] args) {

        int p = Integer.parseInt(args[0]);
        int q = Integer.parseInt(args[1]);
        String de = DE(p, q);
        System.out.printf("Decimal Expansion %d/%d = %s\n", p, q, de);
    
    }

    public static String DE(int p, int q) {

        StringBuilder res = new StringBuilder();

        int R = p / q;
        int T = p % q;
        res.append(R);
        if (T == 0){return res.toString();}
        res.append(".");

        Map<Integer, Integer> RemToPos = new HashMap<>();

        while (T!=0){

            if (RemToPos.containsKey(T)) {

                int ind = RemToPos.get(T);
                String FirstPart = res.substring(0, ind);
                String SecondPart = res.substring(ind);
                return FirstPart + "(" + SecondPart + ")";
                
            }

            RemToPos.put(T, res.length());

            T *= 10;
            R = T / q;
            T %= q;
            res.append(R);

        }

        return res.toString();

    }

}
