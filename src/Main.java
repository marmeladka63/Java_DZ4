
/*
1. arr = {1 , -5, 2, 5, 9, -1, 7}
2. pivot = arr[6] опортный элемент
3. Вызвать шаги 1- 2 для подмасива слева от pivot и справа от pivot
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(" Введите целые числа массива через пробел");
        Scanner st = new Scanner(System.in);
        String[] num = st.nextLine().split(" ");
        int[] arr = new int[num.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(num[i]);
        }
        System.out.println("Не сортированный массив " + Arrays.toString(arr));


        int[] res = quickSort(arr, 0, arr.length - 1);
        System.out.println("Сортированный массив    " + Arrays.toString(res));
    }

    public static int[] quickSort(int[] inputArray, int minIndex, int maxIndex) { //рекурсия сортировки справа и слева от опорного элемента
        if (minIndex >= maxIndex) return inputArray;
        int pivot = getPivotIndex(inputArray, minIndex, maxIndex);
        quickSort(inputArray, minIndex, pivot - 1);
        quickSort(inputArray, pivot + 1, maxIndex);
        return inputArray;
    }

    public static int getPivotIndex(int[] inputArray, int minIndex, int maxIndex) {
        int pivotIndex = minIndex - 1;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (inputArray[i] < inputArray[maxIndex]) {// когда элемент меньше опорного мы увеличиваем индекс и
                pivotIndex++;
                Swap(inputArray, i, pivotIndex);


            }

        }
        pivotIndex++;
        Swap(inputArray, pivotIndex, maxIndex);
        return pivotIndex;
    }

    public static void Swap(int[] inputArray, int leftValue, int rightValue) { //меняем два элемента массива
        int temp = inputArray[leftValue];
        inputArray[leftValue] = inputArray[rightValue];
        inputArray[rightValue] = temp;

    }


}