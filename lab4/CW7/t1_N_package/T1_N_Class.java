/**
* CW7
* lab4 T1_N_Class realization for t1_1 - t1_4 perfomance.
* Run files t1_1.java - t1_4.java (in/out package) to check the 
    results.
* @author Yaroslav Yanhol
*/
package lab4.CW7.t1_N_package;

public class T1_N_Class {

    public int publicField = 1;
    protected int protectedField = 2;
    private int privateField = 3;
    int defaultField = 4;

    public void publicMethod() {
        System.out.println("This is a public method output.");
    }

    protected void protectedMethod() {
        System.out.println("This is a protected method output.");
    }

    private void privateMethod() {
        System.out.println("This is a private method output.");
    }

    void defaultMethod() {
        System.out.println("This is a default method output.");
    }
       
    public class T1_N_Manipulate {

        public void manipulateMethode() {
            System.out.println(protectedField);
        }
    
    }
}


