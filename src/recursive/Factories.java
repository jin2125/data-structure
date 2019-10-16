package recursive;

import java.math.BigInteger;

/**
 * 演示递归求阶乘
 *
 * @author gewei
 * @date 2019/10/16
 */
public class Factories {
    public BigInteger factories(BigInteger n) {
        if (BigInteger.ONE.compareTo(n) == 0) {
            return BigInteger.ONE;
        }
        return n.multiply(factories(n.subtract(BigInteger.ONE)));
    }

    public static void main(String[] args) {
        Factories factories = new Factories();
        System.out.println("ret==" + factories.factories(new BigInteger("5")));
    }
}
