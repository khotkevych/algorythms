// You are given an array [a1 To an] and we have to construct another array [b1 To bn] where
// bi = a1*a2*…*an/ai. you are allowed to use only constant space and the time complexity is O(n).
// No divisions are allowed.

import java.util.Arrays;

public class NoDivision {

    public static void main(String[] args) {
        int a[] = {2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = a.length, temp;
        int b[] = new int[n];
        /*
        At each position i,we need to assign A[i], the product of all the elements in the array except A[i].
        This amounts to same as putting A[i]=a*b,where a=cumulative product of all those elements to the left of A[i]
        and b=cumulative product of all those elements to the right of A[i].
        * */
        temp = 1;
        for (int i = 0; i < n; i++) {
            // everything from the left
            b[i] = temp;
            temp *= a[i];
        }
        temp = 1;
        for (int i = n - 1; i >= 0; i--) {
            // everything from the right
            b[i] *= temp;
            temp *= a[i];
        }

        System.out.println(Arrays.toString(b));
        System.out.println(b[1] + " " + (2 * 4 * 5 * 6 * 7 * 8 * 9));
    }
}
