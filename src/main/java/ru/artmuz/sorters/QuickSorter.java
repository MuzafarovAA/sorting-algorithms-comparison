package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

/**
 * Быстрая сортировка (Quick Sort)
 */
public class QuickSorter implements ISorter {

    long count;
    long exchange;

    @Override
    public CommonResult doSort(int[] array) {
        long startTime = System.currentTimeMillis();

        count = 0;
        exchange = 0;

        doSort(array, 0, array.length - 1);

        long endTime = System.currentTimeMillis();

        logger.info(String.format("%s. Time: %d ms, Comparison: %d, Exchanges: %d",
                QuickSorter.class.getSimpleName(), (endTime - startTime), count, exchange));
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
