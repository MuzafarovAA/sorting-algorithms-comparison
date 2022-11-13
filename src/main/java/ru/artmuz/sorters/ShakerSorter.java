package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

/**
 * Шейкерная сортировка
 */
public class ShakerSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        long startTime = System.currentTimeMillis();

        long count = 0;
        long exchange = 0;

        int temp;
        int left = 0;
        int right = array.length - 1;
        do {
            for (int i = left; i < right; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    exchange++;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                count++;
                if (array[i] < array[i - 1]) {
                    temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    exchange++;
                }
            }
            left++;

        } while (left < right);

        long endTime = System.currentTimeMillis();

        logger.info(String.format("%s. Time elapsed: %d ms, Comparisons: %d, Exchanges: %d",
                ShakerSorter.class.getSimpleName(), (endTime - startTime), count, exchange));
        return new CommonResult(array, count, exchange);
    }
}
