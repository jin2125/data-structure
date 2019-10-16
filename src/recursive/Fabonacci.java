package recursive;

/**
 * @author gewei
 * @date 2019/10/16
 */
public class Fabonacci {

    /**
     * 斐波那契数列
     * @param num
     * @return
     */
    public int getN(int num) {
        if (num == 1) {
            return 0;
        }

        if (num == 2) {
            return 1;
        }
        return getN(num - 1) + getN(num - 2);
    }

    public int sum(int num) {
        if (num == 1) {
            return 0;
        }

        return getN(num) + sum(num - 1);
    }

    public static void main(String[] args) {
        Fabonacci fabonacci = new Fabonacci();
        int ret = fabonacci.getN(7);
        System.out.println("ret==" + ret);

        int sum = fabonacci.sum(7);
        System.out.println("sum==" + sum);

    }
}
