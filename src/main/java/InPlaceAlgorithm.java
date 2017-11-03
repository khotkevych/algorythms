import java.util.Arrays;

// Given a Data Structure having first n integers and next n chars.
// A = i1 i2 i3 … iN c1 c2 c3 … cN.
// Write an in-place algorithm to rearrange the elements of the array ass A = i1 c1 i2 c2 … in cn
public class InPlaceAlgorithm {

    public static void main(String[] args) {
        Object array[] = {0, 1, 2, 3, 4, 5, "a", "b", "c", "d", "e", "f"};
        int n = array.length;
        Object tmp;
        for (int i = 1, j = 1; i < n - 1; i = i + 2, j++) {
            tmp = array[n / 2 - 1 + j];
            System.out.println("Moving element " + tmp);
            /*for (int k = n / 2 - 1 + j; k > i; k--) {
                array[k] = array[k - 1];
            }*/
            System.out.println("Moving array from the position " + i + " to the right");
            System.arraycopy(array, i, array, i + 1, n / 2 - 1 + j - i);
            System.out.println("Setting element '" + tmp + "' to the position " + i);
            array[i] = tmp;
            System.out.println(Arrays.toString(array));
            System.out.println();
        }
    }

}