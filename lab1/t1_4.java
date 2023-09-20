/**
 * CW
 * lab1 task1_4
 * Yaroslav Yanhol
 */

/**
 * Приклад класу, який демонструє, що статичне поле є єдиним для усіх об'єктів класу
 */
public class t1_4 {
    
    // Статичне поле
    static int counter = 0;
    
    /**
     * Метод збільшення значення поля на одиницю
     */
    public static void plus() {counter++;}
    
    /**
     * Метод отримання значення з статичного поля
     * @return Значення статичного поля
     */
    public static int getCount() {return counter;}

    public static void main(String[] args) {
        // Створюємо два об'єкти нашого класу
        t1_4 obj1 = new t1_4();
        t1_4 obj2 = new t1_4();
        obj1.plus();
        
        // Отримаємо значення статичного поля з другого об'єкту класу
        int c = obj2.getCount();
        
        System.out.println("Значення отримане з другого об'єкту класу: " + c
                        + "\nЗначення з першого об'єкту: " + obj1.getCount());

    }

}
