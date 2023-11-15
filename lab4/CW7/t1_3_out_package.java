/**
* CW7
* lab4 t1_3_out_package.
* Run file t1_3_out_package.java and file t1_3_in_package.java
    to check the result.
* @author Yaroslav Yanhol
*/
package lab4.CW7;

import lab4.CW7.t1_N_package.T1_N_Class;

public class t1_3_out_package {
    
     public static void main(String args[]) {

        /* T1_3 */
        T1_N_Class TestObject1 = new T1_N_Class();

        System.out.println(TestObject1.publicField);
        // No access
        // System.out.println(TestObject1.protectedField);
        // No access
        // System.out.println(TestObject1.privateField);
        // No access
        // System.out.println(TestObject1.defaultField);

        TestObject1.publicMethod();
        // No access
        // TestObject1.protectedMethod();
        // No access
        // TestObject1.privateMethod();
        // No access
        // TestObject1.defaultMethod();

    }

}
