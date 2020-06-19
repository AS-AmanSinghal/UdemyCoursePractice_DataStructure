package Sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 2, 1, 34, 76, 7, 8};
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }
}
