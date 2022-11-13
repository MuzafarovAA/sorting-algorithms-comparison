package ru.artmuz.util;

public class Swapper {

    /**
     * Меняет местами элементы с заданными индексами
     *
     * @param array Массив
     * @param pos1  Индекс первого элемента
     * @param pos2  Индекс второго элемента
     */
    public static void doSwap(int[] array, int pos1, int pos2) {
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}
