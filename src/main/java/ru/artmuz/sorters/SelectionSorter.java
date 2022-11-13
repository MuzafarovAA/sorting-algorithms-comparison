package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

/**
 * Сортировка выбором (Selection Sort)
 */
public class SelectionSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        long startTime = System.currentTimeMillis();

        long count = 0;
        long exchange = 0;

        int temp;
        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                count++;
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
            exchange++;
        }

        long endTime = System.currentTimeMillis();

        logger.info(String.format("%s. Time elapsed: %d ms, Comparisons: %d, Exchanges: %d",
                SelectionSorter.class.getSimpleName(), (endTime - startTime), count, exchange));
        return new CommonResult(array, count, exchange);
    }
}
