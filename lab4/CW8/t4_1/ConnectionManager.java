/**
 * CW8
 * Lab4 Connection and ConnectionManager classes realization for t4_1 
 * performance.
 * Run file t4_1.java to check the result.
 * @author Yaroslav Yanhol
 */
package lab4.CW8.t4_1;

class Connection {

    public Connection() {}

}

public class ConnectionManager extends Connection {

    static int connectionIndex = 0;
    private static final int CONNECTIONS_ARRAY_SIZE = 4;
    private static Connection[] connectionsArray = new Connection[CONNECTIONS_ARRAY_SIZE];
    
    public static Connection getConnection() {

        if (connectionIndex < CONNECTIONS_ARRAY_SIZE) {
            if (connectionsArray[connectionIndex] == null) {
                connectionsArray[connectionIndex] = new Connection();
            }
            return connectionsArray[connectionIndex++];
        } else {
            System.out.println("No available connections.");
            System.exit(0);
            return null;
        }
    
    }

}
