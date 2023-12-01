/**
 * CW8
 * Lab4 t4_1.
 * Run file t4_1.java to check the result.
 * @author Yaroslav Yanhol
 */
package lab4.CW8.t4_1;

public class t4_1 {
    
    public static void main(String[] args) {
        
        do {

            Connection connection = ConnectionManager.getConnection();
            System.out.println("Got connection: " + (ConnectionManager.connectionIndex - 1));

        } while (true);

    }

}
