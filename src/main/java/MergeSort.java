import java.util.Arrays;

// Count Inversions in an array

public class MergeSort {
    private static long mergeSort(int[] arr, int[] tmp, int left, int right) {
        long count = 0;
        if (left < right) {
            int index = (left + right) / 2;
            count += mergeSort(arr, tmp, left, index);
            count += mergeSort(arr, tmp, index + 1, right);
            count += merge(arr, tmp, left, right);
        }
        return count;
    }

    private static long merge(int[] arr, int[] tmp, int leftStart, int rightStop) {
        long count = 0;
        int leftStop = (leftStart + rightStop) / 2;
        int rightStart = leftStop + 1;
        int size = rightStop - leftStart + 1;
        int index = leftStart;
        int left = leftStart;
        int right = rightStart;
        while (left <= leftStop && right <= rightStop) {
            if (arr[left] <= arr[right]) {
                tmp[index] = arr[left];
                left++;
            } else {
                tmp[index] = arr[right];
                right++;
                /* In merge process, let i is used for indexing left sub-array and j for right sub-array.
                At any step in merge(), if a[i] is greater than a[j], then there are (mid – i) inversions.
                Because left and right subarrays are sorted, so all the remaining elements in left-subarray
                (a[i+1], a[i+2] … a[mid]) will be greater than a[j] */
                count += leftStop - left + 1;
            }
            index++;
        }
        System.arraycopy(arr, left, tmp, index, leftStop - left + 1);
        System.arraycopy(arr, right, tmp, index, rightStop - right + 1);
        System.arraycopy(tmp, leftStart, arr, leftStart, size);
        return count;
    }

    private static long countInversions(int[] arr) {
        //tmp array to not create new array each time
        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 3, 1, 2};
        System.out.println(countInversions(arr));
        System.out.println(Arrays.toString(arr));
    }
}
