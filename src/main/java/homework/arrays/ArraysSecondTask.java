package homework.arrays;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



/*  Arrays.Task2:
 *   1)  Создать массив целых чисел, не заполняя его
 *   2)  Написать метод, который принимает параметр int
 *   и отвечает за последовательное заполнение вашего статического массива
 *   3) В методе написать проверку: если счетчик равен длине массива, то создать новый массив,
 *   который длиннее предыдущего на 50% и, последовательно через цикл переписать в него значения,
 *   а старый удалить.
 * */

public class ArraysSecondTask {
    private static final Logger logger = Logger.getLogger(ArraysSecondTask.class);
    static int[] mas;

    public static void main(String[] args) throws IOException {
        initializeArray(readLine());
        logger.info(Arrays.toString(mas));
    }

    private static int readLine() throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));
        logger.info("Введите желаемый размер массива: ");
        int masSize = Integer.parseInt(reader.readLine());
        return masSize;
    }

    private static void initializeArray(int masSize) {
        mas = new int[masSize];
        logger.info("Массив будет заполнен случайными целыми числами [0;30)");
        for (int i = 1; i <= masSize; i++) {
            mas[i - 1] = (int) (Math.random() * 30);

            if (i == masSize) {
                int[] newArray = new int[masSize * 3 / 2];
                for (int k = 0; k < mas.length; k++) {
                    newArray[k] = mas[k];
                    if(k == mas.length-1){
                        mas = newArray;
                    }
                }
            }
        }

    }


}
