public class PowerOfTwo {

    /*
    * Write function to calculate sum of first N powers of 2 starting from 1.
    * You shouldn't use any built-in function for calculating power.
    * Implement the most efficient solution.
    */

    public static void main(String args[]) {
        int n = 5, sum = 0, i = 1;
        // 1
        for (int j = 1; j <= n; j++) {
            i = i << 1;
            sum += i;
        }
        // 2
        int bruteForce = 0;
        for (int j = 1; j <= n; j++) {
            bruteForce += Math.pow(2, j);
        }
        // 3
        int s = (2 << n) - 2;
        System.out.println(sum + " " + bruteForce + " " + s);

    }
}
