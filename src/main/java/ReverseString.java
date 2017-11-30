import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseString {

    // todo deal with punctuation marks
    private static String swapSentence(String sentence) {
        String[] str = sentence.split(" ");
        for (int i=0;i<str.length;i++) {
            if (str[i].length() > 1) {
                str[i] = swapWord(str[i]);
            }
        }
        List<String> list = new ArrayList<>(Arrays.asList(str));
        Collections.reverse(list);
        return String.join(" ", list);
    }

    private static String swapWord(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < word.length() / 2; i++) {
            swap(arr, i, word.length() - 1 - i);
        }
        return new String(arr);
    }

    private static void swap(char[] arr, int x, int y) {
        char tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(swapSentence("Hello World, 1!"));
        /*String hello = "HelloWorld123456789";
        char str[] = hello.toCharArray();
        char tmp;
        for (int i = 0; i < str.length - 1; i++) {
            for (int j = 0; j < str.length - 1 - i; j++) {
                tmp = str[j + 1];
                str[j + 1] = str[j];
                str[j] = tmp;
            }
        }
        System.out.println(str);
        str = hello.toCharArray();
        for (int i = 0; i < (str.length - 1) / 2 + 1; i++) {
            tmp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = tmp;
        }
        System.out.println(str);*/

    }
}
