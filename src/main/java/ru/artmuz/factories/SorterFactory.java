package ru.artmuz.factories;

import ru.artmuz.entities.CommonResult;
import ru.artmuz.interfaces.ISorter;
import ru.artmuz.interfaces.ISorterFactory;
import ru.artmuz.sorters.BubbleSorter;
import ru.artmuz.sorters.QuickSorter;
import ru.artmuz.sorters.ShakerSorter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SorterFactory implements ISorterFactory {

    private final List<ISorter> sorters = new ArrayList<>();

    public SorterFactory() {
        sorters.add(new BubbleSorter());
        sorters.add(new ShakerSorter());
        sorters.add(new QuickSorter());
    }

    @Override
    public Map<ISorter, Integer> doSort(int[] array) {
        Map<ISorter, Integer> hashMap = new HashMap<>();

        for (ISorter sorter : sorters) {
            CommonResult result = sorter.doSort(array);
            hashMap.put(sorter, result.getSortCount());
        }

        return hashMap;
    }
}
