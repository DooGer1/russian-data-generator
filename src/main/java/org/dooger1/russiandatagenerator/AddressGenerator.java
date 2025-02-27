package org.dooger1.russiandatagenerator;

import java.util.Random;

public class AddressGenerator implements DataGenerator<String> {
    private static final String[] STREETS = {"Ленина", "Пушкина", "Гагарина", "Мира"};
    private final Random random = new Random();

    @Override
    public String generate() {
        int house = random.nextInt(100) + 1;
        return "ул. " + STREETS[random.nextInt(STREETS.length)] + ", д. " + house;
    }
}
