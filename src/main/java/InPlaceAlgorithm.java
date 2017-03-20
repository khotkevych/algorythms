import java.util.Arrays;

public class InPlaceAlgorithm {

    public static void main(String[] args) {
        Object array[] = {0, 1, 2, 3, 4, 5,"a", "b", "c", "d", "e", "f"};
        int n = array.length;
        Object tmp;
        int j = 1;
        for (int i = 1; i < n - 1; i = i + 2) {
            tmp = array[n / 2 - 1 + j];
            for (int k = n / 2 - 1 + j; k > i; k--) {
                array[k] = array[k - 1];
            }
            array[i] =tmp;
            j++;
            System.out.println(Arrays.toString(array));
        }
    }
}
