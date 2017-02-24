import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// Given a function which produces a random integer in the range 1 to 5, write a function which produces a random integer in the range 1 to 7.
public class Random15 {

    private static int rand5() {
        int min = 1, max = 5;
        //int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
        return new Random().nextInt((max - min) + 1) + min;
    }

    private static int rand25() {
        return rand5() + 5 * rand5() - 5;
    }

    private static int rand7() {
       /* int x = 8;
        while( x > 7) {
            x = rand25();
        }
        return x;*/
        int x = 22;
        while (x > 21)
            x = rand5() + 5 * rand5() - 5;
        return 1 + (x % 7);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(rand7());
        }
    }
}
