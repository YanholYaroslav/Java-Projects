/**
* CW7
* lab4 t1_1_out_package.
* Run file t1_1_out_package.java and file t1_2_in_package.java
    to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW7;

import lab4.CW7.t1_N_package.T1_N_Class;

public class t1_1_out_package {

    public static void main(String args[]) {

        /* T1_1 */
        // The class object is created outside the package
        T1_N_Class TestObject1 = new T1_N_Class();

        /* T1_2 */
        // Compiler throws an error
        // TestObject1.protectedMethod();

    }

}
