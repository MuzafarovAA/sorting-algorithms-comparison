package ru.artmuz.interfaces;

import ru.artmuz.entities.CommonResult;

public interface ISorter {

    /**
     * Производит сортировку заданного массива
     *
     * @param array Массив
     * @return Ответ в виде сущности: отсортированный массив и количество операций сортировки
     */
    CommonResult doSort(int[] array);

}
