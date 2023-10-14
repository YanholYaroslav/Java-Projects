/**
 * CW6
 * lab3 Matrix class. Run this file to check the result of tasks 2_1 - 2_4
 * @author Yaroslav Yanhol
 */

package lab3.CW6;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

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


        /* ---- Task 2_1 methodes --- */
        /**
        * Сортує всі рядки у матриці за зростанням.
        * Кожен рядок у матриці сортується окремо в порядку зростання.
        * @param void - немає параметрів на вхід. Змін зазнає сам об'єкт класу.
        * @return - немає повернутих значень.
        */
        public void sortRows(){
            for (int[] row: matrix) {
                Arrays.sort(row);
            }
        }

        /**
        * Сортує всі стовпці у матриці за зростанням.
        * Кожен стовпець у матриці сортується окремо в порядку зростання.
        * @param void - немає параметрів на вхід. Змін зазнає сам об'єкт класу.
        * @return - немає повернутих значень.
        */
        public void sortColumns() {

            int numRows = matrix.length;
            int numCols = matrix[0].length;
    
            for (int col = 0; col < numCols; col++) {

                int[] colToSort = new int[numRows];
                for (int row = 0; row < numRows; row++) {
                    colToSort[row] = matrix[row][col];
                }
                Arrays.sort(colToSort);
                for (int row = 0; row < numRows; row++) {
                    matrix[row][col] = colToSort[row];
                }

            }

        }


        /* ---- Task 2_2 methodes --- */
        /**
        * Метод циклічного зсуву матриці на k позицій вправо.
        * Створює новий об'єкт класу Matrix з зміщенням положень елементів старого об'єкту за вказаним правилом.
        * @param k - ціле значення кількості позицій для зсуву в матриці.
        * @return - новий об'єкт класу Matrix.
        */
        public Matrix shiftRight(int k) {

            Matrix shifted = new Matrix(matrix.length, matrix[0].length);
    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    shifted.matrix[i][(j + k) % columns] = matrix[i][j];
                }
            }
            return shifted;

        }

        /**
        * Метод циклічного зсуву матриці на k позицій вліво.
        * Створює новий об'єкт класу Matrix з зміщенням положень елементів старого об'єкту за вказаним правилом.
        * @param k - ціле значення кількості позицій для зсуву в матриці.
        * @return - новий об'єкт класу Matrix.
        */
        public Matrix shiftLeft(int k) {
            Matrix shifted = new Matrix(matrix.length, matrix[0].length);
        
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    shifted.matrix[i][j] = matrix[i][(j + k) % columns];
                }
            }
        
            return shifted;
        }
        
        /**
        * Метод циклічного зсуву матриці на k позицій вгору.
        * Створює новий об'єкт класу Matrix з зміщенням положень елементів старого об'єкту за вказаним правилом.
        * @param k - ціле значення кількості позицій для зсуву в матриці.
        * @return - новий об'єкт класу Matrix.
        */
        public Matrix shiftUp(int k) {
            Matrix shifted = new Matrix(matrix.length, matrix[0].length);
        
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    shifted.matrix[i][j] = matrix[(i + k) % rows][j];
                }
            }
        
            return shifted;
        }
        
        /**
        * Метод циклічного зсуву матриці на k позицій вниз.
        * Створює новий об'єкт класу Matrix з зміщенням положень елементів старого об'єкту за вказаним правилом.
        * @param k - ціле значення кількості позицій для зсуву в матриці.
        * @return - новий об'єкт класу Matrix.
        */
        public Matrix shiftDown(int k) {
            Matrix shifted = new Matrix(matrix.length, matrix[0].length);
        
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    shifted.matrix[(i + k) % rows][j] = matrix[i][j];
                }
            }
        
            return shifted;
        }


        /* ---- Task 2_3 methode --- */
        /**
        * Метод пошуку та виведення довжини найдовшої послідовності зростаючих чисел у матриці.
        * Повертає довжину найдовшої послідовності зростаючих чисел у матриці.
        * @param void - немає параметрів на вхід.
        * @return - ціле число типу Integer.
        */
        public int lenOfLongestIncreaseSeqByRows() {

            int max_len = 0;
            int current_len = 1;
    
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns - 1; j++) {
                    if (matrix[i][j] < matrix[i][j + 1]) {
                        current_len++;
                    } else {
                        if (current_len > max_len) {
                            max_len = current_len;
                        }
                        current_len = 1;
                    }
                }
                if (i < rows -1 ){
                    if (matrix[i][rows - 1] < matrix[i + 1][0]) {
                        current_len++;
                    } else {
                        if (current_len > max_len) {
                            max_len = current_len;
                        }
                        current_len = 1;
                    }
                }
            }

            if (current_len > max_len) {
                max_len = current_len;
            }
            return max_len;

        }


        /* ---- Task 2_4 methode --- */
        /**
        * Метод пошуку та виведення суми всіх елементів, що знаходяться між першими двома додатними елементами у кожному рядку.
        * Вважається, що сума елементів між двома сусідніми додатними елементами рівна 0.
        * @param void - немає параметрів на вхід.
        * @return - ціле число типу Integer.
        */
        public int[] sumOfElBetween2positiveByRows(){

            int[] rowSums = new int[rows];

            for (int i = 0; i < rows; i++) {

                int sum = 0;
                int Ind1 = -1;
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] > 0) {
                        if (Ind1 != -1) {
                            for (int k = Ind1 + 1; k < j; k++) {
                                sum += matrix[i][k];
                            }
                            break;
                        } else {
                            Ind1 = j;
                        }
                    }
                }
                rowSums[i] = sum;

            }

            return rowSums;

        }
        

        public static void main(String[] args) {

            System.out.println();
            System.out.println("File \"Matrix.java\" is running!");
            System.out.println();
            System.out.println();
            System.out.println("Tasks 2.1 - 2.4 methodes test");
            System.out.println();

            Matrix matrix = new Matrix(3, 3);
            matrix.fillRandom(-100, 100);
            System.out.println("Created matrix with random elements:");
            matrix.display();

            System.out.println();
            System.out.println();
            System.out.println("Task 2.1 - sorting rows and columns methodes test");
            System.out.println();

            matrix.sortRows();
            System.out.println("After sorting the rows:");
            matrix.display();
            matrix.sortColumns();
            System.out.println("After sorting the columns:");
            matrix.display();

            System.out.println();
            System.out.println();
            System.out.println("Task 2.2 - matrix cycle shifting methodes test");
            System.out.println();

            Matrix shiftR = matrix.shiftRight(1);
            System.out.println("After shifting right for 1 position:");
            shiftR.display();
            Matrix shiftL = shiftR.shiftLeft(1);
            System.out.println("After shifting left for 1 position:");
            shiftL.display();
            Matrix shiftU = matrix.shiftUp(2);
            System.out.println("After shifting up for 2 positions:");
            shiftU.display();
            Matrix shiftD = shiftU.shiftDown(3);
            System.out.println("After shifting down for 3 positions:");
            shiftD.display();

            System.out.println();
            System.out.println();
            System.out.println("Task 2.3 - finding the length of longest sequence of increasing elements of matrix (by rows) methode test");
            System.out.println();

            Matrix matrix45 = new Matrix(4, 5);
            matrix45.fillRandom(-100, 100);
            System.out.println("Created matrix with random elements:");
            matrix45.display();
            int num1 = matrix45.lenOfLongestIncreaseSeqByRows();
            System.out.println("Answer: " + num1);
            System.out.println("Please note that the search occurs throughout the entire matrix in rows.");

            System.out.println();
            System.out.println();
            System.out.println("Task 2.4 - finding the sum of elements placed between first two positive elements (by rows) methode test");
            System.out.println();

            System.out.println("Using previous matrix.");
            int sum1[] = matrix45.sumOfElBetween2positiveByRows();
            System.out.println("Answer: ");
            for (int i = 0; i < sum1.length; i++) {
                System.out.println(sum1[i]);
            }

        }

}
