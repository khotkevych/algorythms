public class PowerOfTwo {

    /*
    * Write function to calculate sum of first N powers of 2 starting from 1.
    * You shouldn't use any built-in function for calculating power.
    * Implement the most efficient solution.
    */

    public static void main(String args[]) {
        int n = 17, sum = 0, i = 1;
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

    /*
    N = 1 -> 0000010  (2^1 or 1<<1)
    N = 2 -> 0000100  (2^2 or 1<<2)
    N = 3 -> 0001000  (2^3 or 1<<3)
    N = 4 -> 0010000  (2^4 or 1<<4)

    sum   -> 0011110
    We can compute 0011110 as 0100000 - "2"
    So the answer is (1<<(N+1))-2 or (2<<N)-2
    */
}
