/**
 * CW5
 * lab3 task1_1
 * Yaroslav Yanhol
 */

package lab3.CW5;

public class t1_1 {
    static public void main(String args[]){

        String s_arr[] = new String[5];
        s_arr[0] = "What";
        s_arr[1] = "the";
        s_arr[2] = "fox";
        s_arr[3] = "say";
        s_arr[4] = "?";
        for (int i = 0; i < 5; i++){
            System.out.print(
                s_arr[i] + ", "
            );
        }
        System.out.println();
        for (int i = 0; i < 5; i++){
            System.out.print(
                i + ": " + s_arr[i] + "\n"
            );
        }

    }

}
