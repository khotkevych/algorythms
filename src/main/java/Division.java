// Implement division (without using the divide operator, obviously).
public class Division {
    // todo complex
    private static int accuracy = 6;

    private static Double divide(Double a, Double b) {
        if (a == 0.0 || b == 1.0) {
            return a;
        }
        if (b == 0.0) {
            return null;
        }
        boolean isNegative = false;
        if (a < 0.0 ^ b < 0.0) {
            isNegative = true;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        Integer res = 0;
        while (a >= b) {
            a -= b;
            res++;
        }
        String result = res.toString();
        if (a != 0) {
            int i = 0;
            result += '.';
            while (i < accuracy && a != 0) {
                a = a * 10.0 - b;
                result += a.toString().charAt(0);
                i++;
            }
        }
        return isNegative ? (-1.0) * new Double(result) : new Double(result);
    }

    public static void main(String[] args) {
        System.out.println(divide(9.0, 6.0));

    }

}
