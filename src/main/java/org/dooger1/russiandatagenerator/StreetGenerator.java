package org.dooger1.russiandatagenerator;

import java.util.Random;

public class StreetGenerator implements DataGenerator<String> {
    private static final String[] STREETS = {
            "ул. Ленина", "ул. Пушкина", "ул. Гагарина", "ул. Мира", "ул. Советская"
    };
    private final Random random = new Random();

    @Override
    public String generate() {
        return STREETS[random.nextInt(STREETS.length)];
    }
}
