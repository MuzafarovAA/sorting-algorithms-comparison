package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;
import ru.artmuz.util.Swapper;

/**
 * Быстрая сортировка (Quick Sort)
 */
public class QuickSorter implements ISorter {

    long count;
    long exchange;

    @Override
    public CommonResult doSort(int[] array) {
        long time = System.currentTimeMillis();

        count = 0;
        exchange = 0;

        doSort(array, 0, array.length - 1);

        time = System.currentTimeMillis() - time;

        return new CommonResult(array, time, count, exchange);
    }

    private void doSort(int[] array, int from, int to) {
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
                        Swapper.doSwap(array, left, right);
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
