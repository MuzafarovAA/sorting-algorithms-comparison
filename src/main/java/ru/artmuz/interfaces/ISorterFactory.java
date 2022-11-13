package ru.artmuz.interfaces;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public interface ISorterFactory {
    Logger logger = LogManager.getLogger(ISorterFactory.class);

    /**
     * Вызывает поочередно все методы сортировки для заданного массива
     *
     * @param array Массив
     * @return Хеш-таблица: ключ - тип сортировки; значение - количество операция
     */
    Map<ISorter, Long> doSort(int[] array);

}
