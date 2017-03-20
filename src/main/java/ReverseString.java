
public class ReverseString {


    public static void main(String[] args) {
        String hello = "HelloWorld";
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
        for (int i = 0; i < (str.length - 1) / 2; i++) {
            tmp = str[i];
            str[i] = str[str.length -1 - i];
            str[str.length -1 - i] = tmp;
        }
        System.out.println(str);

    }
}
