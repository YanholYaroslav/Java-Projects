/**
* CW7
* lab4 t1_4_out_package.
* Run file t1_4_out_package.java and file t1_4_in_package.java
    to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW7;

import lab4.CW7.t1_N_package.T1_N_Class;
import lab4.CW7.t1_N_package.T1_N_Class.T1_N_Manipulate;

public class t1_4_out_package {
    
    public static void main(String args[]) {

        /* T1_4 */
        T1_N_Class TestObject1 = new T1_N_Class();
        T1_N_Manipulate TestObject2 = TestObject1.new T1_N_Manipulate();
        TestObject2.manipulateMethode();

    }
    
}
