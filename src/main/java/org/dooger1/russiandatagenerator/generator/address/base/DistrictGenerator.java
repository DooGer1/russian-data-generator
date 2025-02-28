package org.dooger1.russiandatagenerator.generator.address.base;

import org.dooger1.russiandatagenerator.base.DataGenerator;

import java.util.Random;

public class DistrictGenerator implements DataGenerator<String> {
    private static final String[] DISTRICTS = {
            "Центральный район", "Советский район", "Октябрьский район",
            "Ленинский район", "Кировский район"
    };
    private final Random random = new Random();

    @Override
    public String generate() {
        return DISTRICTS[random.nextInt(DISTRICTS.length)];
    }
}
