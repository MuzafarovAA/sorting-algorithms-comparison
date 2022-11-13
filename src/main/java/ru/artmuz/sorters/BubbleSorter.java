package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;
import ru.artmuz.util.Swapper;

/**
 * Сортировка пузырьком (Bubble Sort)
 */
public class BubbleSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        long time = System.currentTimeMillis();

        long count = 0;
        long exchange = 0;

        boolean isSwapped;
        do {
            isSwapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                count++;
                if (array[i] > array[i + 1]) {
                    Swapper.doSwap(array, i, i + 1);
                    isSwapped = true;
                    exchange++;
                }
            }

        } while (isSwapped);

        time = System.currentTimeMillis() - time;

        return new CommonResult(array, time, count, exchange);
    }
}
