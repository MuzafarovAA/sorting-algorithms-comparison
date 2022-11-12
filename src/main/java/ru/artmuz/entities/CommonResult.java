package ru.artmuz.entities;

import java.util.Arrays;

/**
 * Сущность для формирования результата сортировки
 */
public final class CommonResult {
    /**
     * Отсортированный массив
     */
    private final int[] sortedArray;

    /**
     * Количество операций сортировки
     */
    private final int count;

    public CommonResult(int[] sortedArray, int count) {
        this.sortedArray = sortedArray;
        this.count = count;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommonResult that = (CommonResult) o;

        return Arrays.equals(sortedArray, that.sortedArray);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sortedArray);
    }
}
