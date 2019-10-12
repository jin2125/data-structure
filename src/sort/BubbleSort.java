package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 比较相邻的元素大小，进行交换
 *
 * @author gewei
 * @date 2019/10/12
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param as
     */
    public void sort(int[] as) {
        int temp;
        for (int i = 0; i < as.length - 1; i++) {
            for (int currentIndex = 0; currentIndex < as.length - 1 - i; currentIndex++) {
                if (as[currentIndex] > as[currentIndex + 1]) {
                    temp = as[currentIndex];
                    as[currentIndex] = as[currentIndex + 1];
                    as[currentIndex + 1] = temp;
                }
            }
        }
    }

    /**
     * 优化冒泡
     *
     * @param as
     */
    public void optimizeSort(int[] as) {
        int i = 0;
        int tmp;
        for (i = 0; i < as.length - 1; i++) {
            int j = 0;
            int flag = 0;
            for (j = 0; j < as.length - 1 - i; j++) {
                if (as[j] > as[j + 1]) {
                    tmp = as[j];
                    as[j] = as[j + 1];
                    as[j + 1] = tmp;
                    flag = 1;
                }
            }
            if (flag == 0) {
                return;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 8, 7, 90, 80, 77};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
        System.out.println("优化后输出------");
        int[] arr1 = {3, 5, 4, 8, 7, 90, 80, 77};
        bubbleSort.sort(arr1);
        Arrays.stream(arr).forEach(i -> System.out.println(i));


    }

}
