package com.kastro.lesson2;

/*1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо числа),
надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.
3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и MyArrayDataException
 и вывести результат расчета.

 */
public class Lesson2 {
    public static void main(String[] args) {
        try {
            System.out.println(myMatrix());
        } catch (MyArraySizeException sizeException) {
            System.out.println("Произошло исключение MyArraySizeException: " + sizeException);
            sizeException.printStackTrace();
        } catch (MyArrayDataException dataException) {
            System.out.println("Произошло исключение MyArrayDataException: " + dataException);
            dataException.printStackTrace();
        }
    }

    private static int myMatrix() {
        String[][] matrix = getMatrix();
        int sum = 0;


        for (int i = 0; i < matrix.length; i++) {

            if (matrix.length != 4 || matrix[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum = sum + Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException("Ошибка в строке: " + i + ", в столбце: " + j);
                }

            }

        }
        return sum;
    }

    private static String[][] getMatrix() {
        String[][] matrix = {
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"}

        };

        return matrix;
    }
}
