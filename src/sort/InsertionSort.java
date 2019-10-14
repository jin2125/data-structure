package sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author gewei
 * @date 2019/10/12
 */
public class InsertionSort {
    public void sort(int[] as) {
        int len = as.length;
        int preIndex, current;
        for (int i = 1; i < len; i++) {
            preIndex = i - 1;
            current = as[i];
            while (current < as[preIndex] && preIndex >= 0) {
                as[preIndex + 1] = as[preIndex];
                preIndex--;
            }
            as[preIndex + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 8, 7, 90, 80, 77};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
