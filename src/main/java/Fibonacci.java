// Write a function that takes in 2 integers, the first is the number to continue from,
// the second is the number of iterations and writes the Fibonacci sequence


// http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/

public class Fibonacci {

    // O(2^n)
    private static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    // O(n). space O(n). We can store an array instead of a and b.
    // It will be space O(n)
    private static int fib(int n)
    {
        int a = 0, b = 1, c;
        if (n == 0)
            return a;
        for (int i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    private static void fibonacci(int start, int iter) {
        int n = 0;
        while(fib(n) != start){
            n++;
        }
        for (int i=0;i<iter;i++){
            System.out.print(fib(n) + " ");
            n++;
        }
    }

    public static void main(String args[]) {
        fibonacci(2, 10);
    }
}
