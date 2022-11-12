package ru.artmuz.sorters;

import org.junit.jupiter.api.Test;
import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleSorterTest {
    ISorter sorter = new BubbleSorter();

    /**
     * Кейс: условно-произвольный случай
     */
    @Test
    public void testSorter() {
        int[] array = {5, 1, -4, -8, 0, 2, 2, 8, 31, -1};
        int[] resultArray = {-8, -4, -1, 0, 1, 2, 2, 5, 8, 31};
        CommonResult commonResult = sorter.doSort(array);
        assertArrayEquals(resultArray, commonResult.getSortedArray());
    }

    /**
     * Кейс: худший случай
     */
    @Test
    public void testSorterWorstScenario() {
        int[] array = {5, 4, 3, 2, 1};
        int[] resultArray = {1, 2, 3, 4, 5};
        CommonResult commonResult = sorter.doSort(array);
        assertAll(
                () -> assertArrayEquals(resultArray, commonResult.getSortedArray()),
                () -> assertEquals((array.length - 1) * array.length, commonResult.getSortCount()),
                () -> assertEquals((array.length - 1) * array.length / 2, commonResult.getExchangesCount())
        );
    }

    /**
     * Кейс: лучший случай
     */
    @Test
    public void testSorterBestScenario() {
        int[] array = {1, 2, 3, 4, 5};
        CommonResult commonResult = sorter.doSort(array);
        assertAll(
                () -> assertArrayEquals(array, commonResult.getSortedArray()),
                () -> assertEquals(array.length - 1, commonResult.getSortCount()),
                () -> assertEquals(0, commonResult.getExchangesCount())
        );
    }

    /**
     * Кейс: рандомный массив, проверка подкапотным методом сортировки
     */
    @Test
    public void testRandomScenario() {
        int[] randomArray = IntStream.generate(() -> new Random().nextInt(-100, 100)).limit(25).toArray();
        CommonResult commonResult = sorter.doSort(randomArray);
        Arrays.sort(randomArray);
        assertArrayEquals(randomArray, commonResult.getSortedArray());
    }

}
