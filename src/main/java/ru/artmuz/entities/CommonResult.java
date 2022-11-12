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
     * Количество циклов сортировки
     */
    private final int cycleCount;

    /**
     * Количество операций сортировки
     */
    private final int sortCount;

    /**
     * Количество операций обмена
     */
    private final int exchangesCount;

    public CommonResult(int[] sortedArray, int cycleCount, int sortCount, int exchangesCount) {
        this.cycleCount = cycleCount;
        this.sortedArray = sortedArray;
        this.sortCount = sortCount;
        this.exchangesCount = exchangesCount;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public int getCycleCount() {
        return cycleCount;
    }

    public int getSortCount() {
        return sortCount;
    }

    public int getExchangesCount() {
        return exchangesCount;
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
