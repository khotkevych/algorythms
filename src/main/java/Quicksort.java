import java.util.Random;

public class Quicksort {

    public static void main(String[] args){
        int[] a = new int[]{6,8,3,9,1,4,5};
        Random rand = new Random();
        int payload = a[rand.nextInt(a.length)];
    }
}
