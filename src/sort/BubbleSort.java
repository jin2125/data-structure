package sort;

import java.util.Arrays;

/**
 * @author gewei
 * @date 2019/10/12
 */
public class BubbleSort {
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

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 8, 7, 90, 80, 88};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);
        Arrays.stream(arr).forEach(i -> System.out.println(i));
    }

}
