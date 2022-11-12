package ru.artmuz.interfaces;

import java.util.Map;

public interface ISorterFactory {

    /**
     * Вызывает поочередно все методы сортировки для заданного массива
     *
     * @param array Массив
     * @return Хеш-таблица: ключ - тип сортировки; значение - количество операция
     */
    Map<ISorter, Integer> doSort(int[] array);

}
