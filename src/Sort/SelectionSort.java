package Sort;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {98, 2, 5, 1, 78, 3, 10};
        int min = 0, temp = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            arr[i] = arr[min];
            arr[min] = temp;
        }
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}
