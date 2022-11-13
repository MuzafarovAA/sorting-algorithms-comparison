package ru.artmuz.factories;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;
import ru.artmuz.interfaces.ISorterFactory;
import ru.artmuz.sorters.BubbleSorter;
import ru.artmuz.sorters.QuickSorter;
import ru.artmuz.sorters.SelectionSorter;
import ru.artmuz.sorters.ShakerSorter;

import java.util.*;

public class SorterFactory implements ISorterFactory {

    private final List<ISorter> sorters = new ArrayList<>();

    public SorterFactory() {
        sorters.add(new BubbleSorter());
        sorters.add(new ShakerSorter());
        sorters.add(new SelectionSorter());
        sorters.add(new QuickSorter());
    }

    @Override
    public Map<ISorter, Long> doSort(int[] array) {
        Map<ISorter, Long> hashMap = new HashMap<>();

        for (ISorter sorter : sorters) {
            CommonResult result = sorter.doSort(Arrays.copyOf(array, array.length));
            hashMap.put(sorter, result.getCount());
            logger.info(String.format("%s. Time elapsed: %d ms, Comparisons: %d, Exchanges: %d",
                    sorter.getClass().getSimpleName(), result.getTime(), result.getCount(), result.getExchange()));
        }

        return hashMap;
    }
}
