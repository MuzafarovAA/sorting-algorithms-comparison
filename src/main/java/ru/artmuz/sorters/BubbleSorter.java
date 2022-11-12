package ru.artmuz.sorters;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

/**
 * Сортировка пузырьком (Bubble sort)
 */
public class BubbleSorter implements ISorter {
    @Override
    public CommonResult doSort(int[] array) {
        logger.info("doSort Method for BubbleSorter");
        int count = 0;
        //todo: bubble sort
        return new CommonResult(array, count);
    }
}
