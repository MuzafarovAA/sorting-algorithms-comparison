package ru.artmuz.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.artmuz.entities.CommonResult;

public interface ISorter {
    Logger logger = LogManager.getLogger(ISorter.class);

    /**
     * Производит сортировку заданного массива
     *
     * @param array Массив
     * @return Ответ в виде сущности: отсортированный массив и количество операций сортировки
     */
    CommonResult doSort(int[] array);

}
