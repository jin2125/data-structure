package recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * 背包问题（通过递归找到解）
 *
 * @author gewei
 * @date 2019/10/16
 */
public class Bags {
    public void bag(int[] as, int targetWeight, int nowIndex, List<Integer> listResult) {
        if (nowIndex == as.length) {
            return;
        }
        if (as[nowIndex] > targetWeight) {
            this.bag(as, targetWeight, ++nowIndex, listResult);
        } else if (as[nowIndex] == targetWeight) {
            listResult.add(as[nowIndex]);
            System.out.println("one result==" + listResult);
            listResult.clear();
        } else {
            listResult.add(as[nowIndex]);
            this.bag(as, targetWeight - as[nowIndex], ++nowIndex, listResult);
        }
    }

    public static void main(String[] args) {
        int[] bags = {11, 8, 7, 5};

        Bags bags1 = new Bags();
        for (int i = 0; i < bags.length; i++) {
            bags1.bag(bags, 15, i, new ArrayList<Integer>());
        }
    }
}
