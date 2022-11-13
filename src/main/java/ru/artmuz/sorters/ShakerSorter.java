package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;
import ru.artmuz.util.Swapper;

/**
 * Шейкерная сортировка (Shaker Sort)
 */
public class ShakerSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        long time = System.currentTimeMillis();

        long count = 0;
        long exchange = 0;

        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    Swapper.doSwap(array, i, i + 1);
                    exchange++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                count++;
                if (array[i] < array[i - 1]) {
                    Swapper.doSwap(array, i, i - 1);
                    exchange++;
                }
            }
            left++;

        } while (left < right);

        time = System.currentTimeMillis() - time;

        return new CommonResult(array, time, count, exchange);
    }
}
