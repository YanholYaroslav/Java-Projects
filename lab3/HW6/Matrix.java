/**
 * HW6
 * lab3 Matrix class.
 * Run file t2_13.java to check the result.
 * @author Yaroslav Yanhol
 */

package lab3.HW6;

import java.util.Random;
import java.util.Scanner;

public class Matrix {

        private int[][] matrix;
        private int rows;
        private int columns;

        // Максимальна довжина елемента в матриці. Використовується для форматування виводу у методі display()
        private int ElMaxLen = 5;

        /**
        * Конструктор об'єкту класу Matrix.
        * Створює новий об'єкт класу Matrix.
        * @param rows - кількість рядків матриці.
        * @param columns - кількість стовпців матриці.
        * @return - об'єкт класу Matrix.
        */
        public Matrix(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            matrix = new int[rows][columns];
        }

        /** Метод для ініціалізації об'єкту класу Matrix на основі готового двовимірного масиву
         * @param values - масив типу int, з якого буде взято значення.
         * @return - немає повернутих значень.
         */
        public void init(int[][] values) {

            if (values.length != rows || values[0].length != columns) {
                throw new IllegalArgumentException("The dimension of the transfered array [" + values.length + ", " + values[0].length + 
                                                    "] does not correspond to the dimension of the matrix [" + rows + ", " + columns + "].");
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = values[i][j];
                }
            }
            findEltMaxLen();

        }


        /**
        * Метод для пошуку максимальної довжини елемента у матриці.
        * Використовується для форматування виводу в методі display().
        * Має бути викликаний за кожного оновлення значень об'єкту класу Matrix.
        * @return - немає повернутих значень.
        */
        private void findEltMaxLen(){

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int cur_len = Integer.toString(matrix[i][j]).length();
                    if (cur_len > ElMaxLen){
                        ElMaxLen = cur_len;
                    }
                }
            }
        
        }


        /**
        * Метод для введення матриці з консолі.
        * @param user_inp - поток введення виду Scanner.
        * @return - немає повернутих значень.
        */
        public void inConsole(Scanner user_inp) {

            System.out.println("Enter matrix elements: ");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    System.out.printf("Element [%d][%d]: ", i, j);
                    matrix[i][j] = user_inp.nextInt();
                }
            }
            findEltMaxLen();

        }

        /**
        * Метод для заповнення матриці випадковими числами в заданому діапазоні.
        * @param min - мінімальне допустиме значення.
        * @param max - максимальне допустиме значення.
        * @return - немає повернутих значень.
        */
        public void fillRandom(int min, int max) {

            Random rand = new Random();
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrix[i][j] = rand.nextInt(max - min + 1) + min;
                }
            }
            findEltMaxLen();

        }

        /**
        * Метод для виведення матриці на консоль.
        * @return - немає повернутих значень.
        */
        public void display() {

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    String sp = " ";
                    int v_l = Integer.toString(matrix[i][j]).length();
                    for (int s = 0; s < ElMaxLen - v_l; s++){
                        sp += " ";
                    }
                    System.out.print(sp + matrix[i][j]);
                }
                System.out.println();
            }

        }


        /* ---- Task 2_13 methode --- */
        /**
        * Метод сортуання значень у рядках матриці.
        * Кожен елемент у рядку із значенням 0 переміщується у кінець рядку.
        * @param void - немає параметрів на вхід. Змін зазнає сам об'єкт класу.
        * @return - немає повернутих значень.
        */
        public void moveZerosToEnd() {

            for (int i = 0; i < rows; i++) {

                int[] row = matrix[i];
                int noNull = 0;
                for (int j = 0; j < columns; j++) {
                    if (row[j] != 0) {
                        row[noNull] = row[j];
                        noNull++;
                    }
                }
        
                for (int j = noNull; j < columns; j++) {
                    row[j] = 0;
                }

            }

        }
        
}
