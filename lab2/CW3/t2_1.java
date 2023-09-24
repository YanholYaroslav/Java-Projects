/**
 * CW3
 * lab2 task2_1
 * Yaroslav Yanhol
 */

package lab2.CW3;

public class t2_1 {

    public static void main(String[] args) {

        int a = 0xD0; // Перше число з нулем у найменш значущій цифрі
        int b = 0xA1; // Друге число з одиницею у найменш значущій цифрі
        System.out.println("a: " + a + ", b: " + b);

        int res1 = a & b;
        int res2 = a | b;
        int res3 = a ^ b;
        int res4 = ~a;
        int res5 = a >> b;
        int res6 = a << b;
        int res7 = a >>> b;
        System.out.println("Result of AND: " + Integer.toBinaryString(res1));
        System.out.println("Result of OR: "  + Integer.toBinaryString(res2));
        System.out.println("Result of XOR: " + Integer.toBinaryString(res3));
        System.out.println("Result of complementation: " + Integer.toBinaryString(res4));
        System.out.println("Result of >>:  " + Integer.toBinaryString(res5));
        System.out.println("Result of <<:  " + Integer.toBinaryString(res6));
        System.out.println("Result of >>>: " + Integer.toBinaryString(res7));

    }

}
