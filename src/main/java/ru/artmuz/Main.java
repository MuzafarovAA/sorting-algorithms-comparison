package ru.artmuz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.artmuz.factories.SorterFactory;
import ru.artmuz.interfaces.ISorter;

import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static final int RANDOM_ARRAY_INT_BOUND = 100;
    public static final int RANDOM_ARRAY_MIN_SIZE = 1;
    public static final int RANDOM_ARRAY_MAX_SIZE = 25;
    public static final int RANDOM_ARRAYS_COUNT = 25;
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        SorterFactory sorterFactory = new SorterFactory();

        List<int[]> arrays = initRandomArrays();
        logger.info("Random arrays initialized");

        for (int[] array : arrays) {
            logger.info(String.format("Sorting array of %d elements: %s", array.length,
                    array.length > 1000 ? String.format("viewing only first 1000 elements: %s", Arrays.toString(Arrays.copyOf(array, 1000))) : Arrays.toString(array)));
            Map<ISorter, Long> map = sorterFactory.doSort(array);

            Map.Entry<ISorter, Long> min = Collections.min(map.entrySet(), Map.Entry.comparingByValue());
            logger.info("The best sorter for array is: " + min.getKey().getClass().getSimpleName());
        }

    }

    private static List<int[]> initRandomArrays() {
        List<int[]> arrays = new ArrayList<>(RANDOM_ARRAYS_COUNT);
        for (int i = 0; i < RANDOM_ARRAYS_COUNT; i++) {
            int[] randomIntsArray = IntStream.generate(
                            () -> new Random().nextInt(-RANDOM_ARRAY_INT_BOUND, RANDOM_ARRAY_INT_BOUND)
                    ).limit(new Random().nextInt(RANDOM_ARRAY_MIN_SIZE, RANDOM_ARRAY_MAX_SIZE))
                    .toArray();
            arrays.add(randomIntsArray);
        }
        return arrays;
    }

    private static List<int[]> initRandomArray(int size, int bound) {
        int[] randomIntsArray = IntStream.generate(
                        () -> new Random().nextInt(-bound, bound))
                .limit(size)
                .toArray();
        return Collections.singletonList(randomIntsArray);
    }
}
