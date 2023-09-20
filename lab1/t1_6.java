/**
 * CW
 * lab1 task1_6
 * Yaroslav Yanhol
 */



public class t1_6 {

    public static void main(String[] args) {

        double Sum = 0;
        for (int i = 0; i < args.length; i++) {
            Sum += Double.parseDouble(args[i]);
        }
        System.out.println("The sum of arguments: " + Sum);
        System.out.println("Amount of arguments: " + args.length);

    }

}