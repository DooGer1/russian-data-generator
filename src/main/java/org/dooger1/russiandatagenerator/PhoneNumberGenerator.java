package org.dooger1.russiandatagenerator;

import java.util.Random;

public class PhoneNumberGenerator implements DataGenerator<String> {
    private final Random random = new Random();

    @Override
    public String generate() {
        return String.format("+7 (%03d) %03d-%02d-%02d",
                random.nextInt(900) + 100,
                random.nextInt(900) + 100,
                random.nextInt(100),
                random.nextInt(100));
    }
}
