package org.dooger1.russiandatagenerator.generator.address.composite;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.PostalCodeGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.RegionGenerator;

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
