/**
 * HW6
 * lab3 t2_13
 * Run this file to check the result.
 * @author Yaroslav Yanhol
 */

package lab3.HW6;

import lab3.HW6.Matrix;

public class t2_13 {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("File \"t2_13.java\" is running!");
        System.out.println();
        System.out.println();
        System.out.println("Tasks 2.13 methode test");
        System.out.println();

        Matrix matrix = new Matrix(5, 5);
        int a[][] = {
            {0, 5, 3, 5, 3},
            {0, 0, 3, 5, 3},
            {1, 5, 3, 0, 0},
            {1, 0, 0, 0, 3},
            {0, 0, 0, 0, 3}
                    };
        matrix.init(a);
        System.out.println("Created matrix :");
        matrix.display();     
        
        System.out.println();

        matrix.moveZerosToEnd();
        System.out.println("Sorted matrix :");
        matrix.display();

    }

}
