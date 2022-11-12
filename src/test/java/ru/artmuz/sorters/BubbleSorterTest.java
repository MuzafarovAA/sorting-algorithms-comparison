package ru.artmuz.sorters;

import org.junit.jupiter.api.Test;
import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSorterTest {
    ISorter sorter = new BubbleSorter();
    int[] array = {5, 1, -4, -8, 0, 2, 2, 8, 31, -1};
    int[] resultArray = {-8, -4, -1, 0, 1, 2, 2, 5, 8, 31};

    @Test
    public void testSorter() {
        CommonResult commonResult = sorter.doSort(array);
        assertArrayEquals(resultArray, commonResult.getSortedArray());
    }
}
