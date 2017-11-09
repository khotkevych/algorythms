import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

// Write some code to find all permutations of the letters in a particular string.
public class LetterPermutations {
    // arrangement Akn = n! / (n-k)! - with order
    // combination Ckn = n! / k!(n-k)! - without order
    // permutation Pn = n!

    private static List<String> permutation(String str) {
        return permutation("", str);
    }

    private static List<String> permutation(String prefix, String str) {
        List<String> permutations = new ArrayList<>();
        int n = str.length();
        System.out.println("prefix=\"" + prefix + "\" str=\"" + str + "\"");
        if (n == 1) {
            System.out.println(prefix + str);
            permutations.add(prefix + str);
            return permutations;
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println("In i=" + i + " n=" + n);
                permutations.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
                System.out.println("Out i=" + i + " n=" + n);
            }
        }
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


        String str = "1234";
        List<String> permutations = permutation(str);
        System.out.println("\n\n\n" + factorial(str.length()) + " " + permutations.size());
        System.out.println(permutations);
    }
}
