import java.util.Random;

public class QuickSort {

    private void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = left + (right - left) / 2;
        //Random rand = new Random();
        //int index = rand.nextInt(arr.length);
        int pivot = arr[index];
        int l = left, r = right;
        while (l <= r) {
            while (arr[l] < pivot) {
                l++;
            }
            while (arr[r] > pivot) {
                r--;
            }
            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
        if (left < r) {
            sort(arr, left, r);
        }
        if (right > l) {
            sort(arr, l, right);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 8, 1, 4, 6, 5, 9};
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
