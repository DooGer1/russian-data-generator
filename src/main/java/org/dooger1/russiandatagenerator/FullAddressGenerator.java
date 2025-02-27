package org.dooger1.russiandatagenerator;

import java.util.Random;

public class FullAddressGenerator implements DataGenerator<String> {
    private final RegionGenerator regionGenerator = new RegionGenerator();
    private final PostalCodeGenerator postalCodeGenerator = new PostalCodeGenerator();
    private final Random random = new Random();

    @Override
    public String generate() {
        String region = regionGenerator.generate();
        String postalCode = postalCodeGenerator.generate(region);
        return String.format("%s, д. %d, %s",
                region,
                random.nextInt(100) + 1,
                postalCode);
    }
}
