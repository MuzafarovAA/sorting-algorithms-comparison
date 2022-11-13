package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

/**
 * Сортировка пузырьком (Bubble sort)
 */
public class BubbleSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        long startTime = System.currentTimeMillis();

        long count = 0;
        long exchange = 0;

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

        long endTime = System.currentTimeMillis();

        logger.info(String.format("%s. Time elapsed: %d ms, Comparisons: %d, Exchanges: %d",
                BubbleSorter.class.getSimpleName(), (endTime - startTime), count, exchange));
        return new CommonResult(array, count, exchange);
    }
}
