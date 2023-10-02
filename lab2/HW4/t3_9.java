/**
 * HW4
 * lab2 task3_9
 * Yaroslav Yanhol
 */

//package lab2.HW4;

public class t3_9 {
    public static void main(String[] args) {

        double nums[] = new double[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = Double.parseDouble(args[i]);
        }

        for (int i = 0; i < 5; i++){
            for (int j = i + 1; j < 5; j++){
                if (nums[i] < nums[j]){
                    double temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        double mean = (nums[1] + nums[2] + nums[3] + nums[4])/4;
        System.out.printf("Mean is: %.2f\n", mean);

    }
}
