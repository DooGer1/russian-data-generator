package org.dooger1.russiandatagenerator.base;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface DataGenerator<T> {
    T generate(); // Одиночное значение

    default List<T> size(int count) { // Создает список из count значений
        return IntStream.range(0, count)
                .mapToObj(i -> generate())
                .collect(Collectors.toList());
    }
}
