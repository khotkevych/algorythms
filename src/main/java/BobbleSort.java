import java.util.Arrays;

public class BobbleSort {

    private static void bubblesort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean is_sorted = true;

            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = false;
                }
            }
            System.out.println(Arrays.toString(a));
            if (is_sorted) return;
        }
    }

    private static void bubblesortBack(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean is_sorted = true;

            for (int j = 0; j < a.length - 1 -i ; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = false;
                }
            }
            System.out.println(Arrays.toString(a));
            if (is_sorted) return;
        }
    }

    private static void bubblesortFast(int[] a) {
        int lastSwap = a.length - 1;
        for (int i = 1; i < a.length; i++) {
            boolean is_sorted = true;
            int currentSwap = -1;

            for (int j = 0; j < lastSwap; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = false;
                    currentSwap = j;
                }
            }
            System.out.println(Arrays.toString(a));
            if (is_sorted) return;
            lastSwap = currentSwap;
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{5, 3, 7, 8, 4, 9, 1};
        System.out.println(Arrays.toString(a));
        bubblesort(a);
        //bubblesortBack(a);
    }
}
