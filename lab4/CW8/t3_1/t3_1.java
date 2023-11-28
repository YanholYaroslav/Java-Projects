/**
* CW8
* lab4 t3_1.
* Run file t3_1.java to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW8.t3_1;

import java.util.Scanner;

public class t3_1 {

    public static void main(String[] args) {

        int k = 5;
        Rational[] rationalArray = Rational.createRationalArray(k);

        System.out.println("Enter values for the array of fractions:");
        Scanner userInput = new Scanner(System.in);
        for (Rational rational : rationalArray) {
            rational.keyboardInput(userInput);
        }
        System.out.println("\nValues for the array of fractions:");
        for (Rational rational : rationalArray) {
            System.out.println(rational);
        }
        Rational sum = new Rational(0, 1);
        for (Rational rational : rationalArray) {
            try {
                sum = sum.add(rational);
            } catch (RationalValueError e) {
                e.printStackTrace();
            }
        }
        System.out.println("\nSum of the array of fractions: " + sum);
        userInput.close();

    }

}
