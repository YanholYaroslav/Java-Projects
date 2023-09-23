/**
 * CW
 * lab1 task2_7
 * Yaroslav Yanhol
 */

public class t2_7 {
    // CTRL + SHIFT + C     (відкрити новий термінал)
    // cd lab1              (дістатися папки з файлом для компіляції)
    // javac t2_7.java -> java t2_7 a b     (a, b - цілі числа)
    public static void main(String[] args) {

        if (args.length == 2) {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int r = a * b;
            System.out.println("Multiplication result: " + r);
        } else {
            System.err.println("Please, enter two integer numbers");
        }

    }

}
