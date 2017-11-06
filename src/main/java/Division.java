// Implement division (without using the divide operator, obviously).
public class Division {
    // todo complex
    // todo remove Math.pow and use binary division
    private static int accuracy = 8;

    private static Double divide(double a, double b) {
        if (a == 0.0 || b == 1.0) {
            return a;
        }
        if (b == 0.0) {
            return null;
        }
        Integer mantissa = 0, exponent = 0, sign = 1;
        if (a < 0.0 ^ b < 0.0) {
            sign = -1;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == b) {
            return new Double(sign);
        }
        while (a >= b) {
            a -= b;
            mantissa++;
        }
        if (a != 0) {
            int i = 0;
            while (i < accuracy && a != 0) {
                // todo round
                mantissa *= 10;
                a *= 10;
                while (a >= b) {
                    a -= b;
                    mantissa++;
                }
                i++;
                exponent--;
            }
        }
        return sign * mantissa * Math.pow(10, exponent); // use * 0.1 instead ?
    }

    public static void main(String[] args) {
        System.out.println(divide(-55.4, -7.6));
    }

}
