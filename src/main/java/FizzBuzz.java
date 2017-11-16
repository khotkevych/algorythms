public class FizzBuzz {

    public static void main(String[] args) {
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < 101; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                res.append(i).append(" ");
            }else{
                if(i % 3 == 0){
                    res.append("fizz").append(" ");
                }
                if(i % 5 == 0){
                    res.append("buzz").append(" ");
                }
            }
        }
        System.out.println(res);
    }

}
