package training5;

import java.math.BigInteger;

public class MyAckermann {

    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger ackermann(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        if (x.equals(BigInteger.ZERO))
            return y.multiply(TWO);
        if (y.equals(BigInteger.ONE))
            return TWO;
        else
            return ackermann(x.subtract(BigInteger.ONE),
                    ackermann(x, y.subtract(BigInteger.ONE)));
    }

    public static void test() {
        // 20
        System.out.println(ackermann(BigInteger.ZERO, BigInteger.TEN));
        // 65536
        System.out.println(ackermann(TWO, TWO.multiply(TWO)));
        // 65536
        System.out.println(ackermann(TWO.add(BigInteger.ONE),
                TWO.add(BigInteger.ONE)));
    }
}
