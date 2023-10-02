/**
 * CW3
 * lab2 task2_2
 * Yaroslav Yanhol
 */

package lab2.CW3;

public class t2_2 {
    
    public static void main(String[] args) {

        int a = 0x7FFFFFFF; // Має найбільш значущу двійкову позицію
        System.out.println("decimal a: " + a + ", binary a: " + Integer.toBinaryString(a));
        while (a != 0){
            a = a >> 1;
            System.out.println("a: " + Integer.toBinaryString(a));
        }

        int b = 0b11011011; // Двійкове число
        System.out.println("decimal b: " + b + ", binary b: " + Integer.toBinaryString(b));
        b = b << 24;
        System.out.println("After <<, decimal b: " + b + ", binary b: " + Integer.toBinaryString(b));
        while (b != 0){
            b = b >>> 1;
            System.out.println("b: " + Integer.toBinaryString(b));
            //System.out.println("b: " + b);
        }

    }

}
