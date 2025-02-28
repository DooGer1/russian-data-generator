package org.dooger1.russiandatagenerator.generator.address.base;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;

import java.util.List;
import java.util.Random;

public class StreetGenerator implements DataGenerator<String> {
    private final List<String> streets;
    private final Random random = new Random();

    public StreetGenerator() {
        this.streets = ResourceLoader.loadResourceFile("address/streets.txt");
    }

    @Override
    public String generate() {
        return "ул. " + streets.get(random.nextInt(streets.size()));
    }
}
