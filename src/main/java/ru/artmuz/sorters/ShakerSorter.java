package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

import java.util.Arrays;

/**
 * Шейкерная сортировка
 */
public class ShakerSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] originalArray) {
        int[] array = Arrays.copyOf(originalArray, originalArray.length);
        int cycles = 0;
        int count = 0;
        int exchange = 0;

        int temp;
        int left = 0;
        int right = array.length - 1;
        do {
            cycles++;
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

        logger.info(String.format("%s. Cycles: %d, Comparison: %d, Exchanges: %d", ShakerSorter.class.getSimpleName(), cycles, count, exchange));
        return new CommonResult(array, cycles, count, exchange);
    }
}
