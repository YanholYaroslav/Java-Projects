/**
 * CW
 * lab1 task1_5
 * Yaroslav Yanhol
 */



public class t1_5 {

    public static void main(String[] args) {

        if (args.length == 3) {
            String a = args[0];
            String b = args[1];
            String c = args[2];
            System.out.println(a + " " +  b + " " + c);
        } else {
            System.out.println("Please, enter 3 arguments!");
        }

    }

}