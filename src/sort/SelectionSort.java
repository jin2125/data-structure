package sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次都选出未排序数组里的较大或较小值，放在已排序队尾
 *
 * @author gewei
 * @date 2019/10/12
 */
public class SelectionSort {

    public void sort(int[] as) {
        int len = as.length;
        int minIndex, temp;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (as[j] < as[minIndex]) {
                    minIndex = j;
                }
            }
            temp = as[i];
            as[i] = as[minIndex];
            as[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 8, 7, 90, 80, 77};

        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }
}
