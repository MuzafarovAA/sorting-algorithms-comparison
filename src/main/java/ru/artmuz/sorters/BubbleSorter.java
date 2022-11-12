package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

import java.util.Arrays;

/**
 * Сортировка пузырьком (Bubble sort)
 */
public class BubbleSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] originalArray) {
        int[] array = Arrays.copyOf(originalArray, originalArray.length);
        int count = 0;
        int exchange = 0;

        int temp;
        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSwapped = true;
                    exchange++;
                }
            }

        } while (isSwapped);

        logger.info(String.format("%s. Comparison: %d, Exchanges: %d", BubbleSorter.class.getSimpleName(), count, exchange));
        return new CommonResult(array, count, exchange);
    }
}
