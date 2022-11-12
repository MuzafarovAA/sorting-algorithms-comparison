package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

import java.util.Arrays;

/**
 * Быстрая сортировка (Quick Sort)
 */
public class QuickSorter implements ISorter {

    int count;
    int exchange;

    @Override
    public CommonResult doSort(int[] originalArray) {
        int[] array = Arrays.copyOf(originalArray, originalArray.length);

        count = 0;
        exchange = 0;

        doSort(array, 0, array.length - 1);
        logger.info(String.format("%s. Comparison: %d, Exchanges: %d", QuickSorter.class.getSimpleName(), count, exchange));
        return new CommonResult(array, count, exchange);
    }

    private void doSort(int[] array, int from, int to) {
        int temp;
        int left = from;
        int right = to;
        if (left != right) {
            int pivot = array[(left + right) / 2];
            do {
                while (array[left] < pivot) {
                    count++;
                    left++;
                }
                while (array[right] > pivot) {
                    count++;
                    right--;
                }
                if (left <= right) {
                    if (left < right) {
                        temp = array[left];
                        array[left] = array[right];
                        array[right] = temp;
                        exchange++;
                    }
                    left++;
                    right--;
                }
            } while (left <= right);

            if (from < right) {
                doSort(array, from, right);
            }
            if (left < to) {
                doSort(array, left, to);
            }
        }
    }
}
