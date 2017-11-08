import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Write some code to find all permutations of the letters in a particular string.
public class LetterPermutations {
    // arrangement Akn = n! / (n-k)! - with order
    // combination Ckn = n! / k!(n-k)! - without order
    // permutation Pn = n!

    private static List<String> getPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        return permutations;
    }

    /* todo try Gamma function https://introcs.cs.princeton.edu/java/91float/Gamma.java.html
       also http://www.luschny.de/math/factorial/FastFactorialFunctions.htm
     */
    private static BigInteger factorialRecursive(int num) {
        // stack frame
        if (num < 0) {
            throw new RuntimeException("Number should be >= 0");
        }
        if (num == 0) {
            return BigInteger.ONE;
        }
        System.out.println(num);
        return BigInteger.valueOf(num).multiply(factorialRecursive(num - 1));
    }

    private static BigInteger factorial(int num) {
        if (num < 0) {
            throw new RuntimeException("Number should be >= 0");
        }
        if (num == 0) {
            return BigInteger.ONE;
        } else {
            BigInteger result = BigInteger.ONE;
            for (long i = 2; i <= num; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            return result;
        }
    }

    private static BigInteger recfact(long start, long n) {
        long i;
        if (n <= 16) {
            BigInteger r = BigInteger.valueOf(start);
            for (i = start + 1; i < start + n; i++) r = r.multiply(BigInteger.valueOf(i));
            return r;
        }
        i = n / 2;
        return recfact(start, i).multiply(recfact(start + i, n - i));
    }

    // ? not faster at all
    private static BigInteger factorialFast(int n) {
        return recfact(1, n);
    }

    public static void main(String[] args) {
        /*long startTime = System.nanoTime();
        System.out.println(factorial(1000000));
        long endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);

        startTime = System.nanoTime();
        System.out.println(factorialRecursive(100000));
         endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);

        startTime = System.nanoTime();
        System.out.println(factorialFast(10000000));
         endTime = System.nanoTime();
        System.out.println((endTime - startTime) / 1000000);*/


        String str = "hello";
        List<String> permutations = getPermutations(str);
        System.out.println(factorial(str.length()) + " " + permutations.size());
        System.out.println(permutations);
    }
}
