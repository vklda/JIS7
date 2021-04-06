package homework.arrays;
//*******Checked**********
import java.util.Arrays;

public class ArraysFirstTask {
    static int[] masOne = new int[5];
    static int[] masTwo;


    public static void main(String[] args) {
        fill(masOne); // fills array with a random int value.

        Arrays.sort(masOne); // sort array

        masTwo = reverse(masOne); // reverse array №1 and put result into №2 array

        additionArrays(masOne, masTwo);

    }

    private static void additionArrays(int[] masOne, int[] masTwo) {
        int resultArraySize = masOne.length + masTwo.length;
        int[] resultArray = new int[resultArraySize];
        for (int i = 0; i < resultArraySize; i++) {
            if (i < (resultArraySize / 2)) {
                resultArray[i] = masOne[i];
            } else if (i < resultArraySize) {
                resultArray[i] = masTwo[i-(resultArraySize/2)];
            }
        }
        for(int x: resultArray){
            System.out.print(x+" ");
        }
    }

    private static int[] reverse(int[] mas) {
        int[] temp = new int[mas.length];
        int k = mas.length - 1;
        for (int i = 0; i < mas.length; i++) {
            temp[k] = mas[i];
            k--;
        }
        return temp;
    }

    public static void fill(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 15);
        }
    }


}

// 1) создать массив целых чисел длиной 5 элементов и заполнить значениями в произв. порядке
// 2) отсортировать любым методом.
// 3) Написать метод, который принимает этот массив и в этом методе из текущего массива
//создает перевернутый массив и возвращает из метода этот новый массив
// 4) Написать метод, который принимает оба массива и объединяет их в один массив, а затем распечатывает в консоль.
