/**
 * CW4
 * lab2 task4_2
 * Yaroslav Yanhol
 */

package lab2.CW4;

import java.util.Calendar;

public class t4_2 {

    public static void main(String[] args) {

        int maxDaysWithoutFriday13 = WithoutFriday13();
        System.out.println("Maximum of days without friday 13th is: " 
                            + maxDaysWithoutFriday13);
    
    }

    public static int WithoutFriday13()
    {
        Calendar calendar = Calendar.getInstance();
        int MaxDays = 0;
        int days = 0;

        /* Для перевірки правильності розрахунку за стартову позицію було взято різницю 
         * 1999 року з умови та інтервалу в 400 років
         */
        for (int year = 1999 - 400; year < 1999; year++)
        {
            for (int month = 0; month < 12; month++)
            {
                calendar.set(year, month, 13);
                int Month = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                days += Month;

                if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
                {
                    days--;
                    MaxDays = MaxDays < days ? days : MaxDays;
                    days = 0;
                }
            }
        }
        return MaxDays;
    }

}
