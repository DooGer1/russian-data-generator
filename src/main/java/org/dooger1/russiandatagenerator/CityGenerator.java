package org.dooger1.russiandatagenerator;

import java.util.Random;

public class CityGenerator implements DataGenerator<String> {
    private static final String[] CITIES = {
            "Москва", "Санкт-Петербург", "Новосибирск", "Екатеринбург", "Казань"
    };
    private final Random random = new Random();

    @Override
    public String generate() {
        return CITIES[random.nextInt(CITIES.length)];
    }
}
