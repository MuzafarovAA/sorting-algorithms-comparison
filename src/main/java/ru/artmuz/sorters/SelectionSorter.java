package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;
import ru.artmuz.util.Swapper;

/**
 * Сортировка выбором (Selection Sort)
 */
public class SelectionSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        long time = System.currentTimeMillis();

        long count = 0;
        long exchange = 0;

        int min;
        for (int i = 0; i < array.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
                count++;
            }
            Swapper.doSwap(array, i, min);
            exchange++;
        }

        time = System.currentTimeMillis() - time;

        return new CommonResult(array, time, count, exchange);
    }
}
