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
     * Время выполнения сортировки
     */
    private final long time;

    /**
     * Количество операций сортировки
     */
    private final long count;

    /**
     * Количество операций обмена
     */
    private final long exchange;

    public CommonResult(int[] sortedArray, long time, long count, long exchange) {
        this.sortedArray = sortedArray;
        this.time = time;
        this.count = count;
        this.exchange = exchange;
    }

    public int[] getSortedArray() {
        return sortedArray;
    }

    public long getTime() {
        return time;
    }

    public long getCount() {
        return count;
    }

    public long getExchange() {
        return exchange;
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
