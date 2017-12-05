// http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
public class RotatedArray {

    static int check(int[] arr, int key, int l, int h) {
        if (l > h) {
            return -1;
        }
        int mid = (l + h) / 2;
        if (arr[mid] == key) {
            return mid;
        }

        // If left part is sorted
        if (arr[l] <= arr[mid]) {
            // check the left part
            if (key >= arr[l] && key <= arr[mid]) {
                return check(arr, key, l, mid - 1);
            }
            // if not - check the right part
            return check(arr, key, mid + 1, h);
        }

        // If left part is not sorted, then right part must be sorted
        else {
            // search in right part
            if (key >= arr[mid] && key <= arr[h]) {
                return check(arr, key, mid + 1, h);
            }
            // then search in left part
            return check(arr, key, l, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2};
        int k = 1;
        int m = arr.length;
        System.out.println(check(arr, k, 0, m - 1));
    }
}
