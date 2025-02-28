package org.dooger1.russiandatagenerator.generator.address.base;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;

import java.util.List;
import java.util.Random;

public class CityGenerator implements DataGenerator<String> {
    private final Random random = new Random();
    private final List<String> cities;

    public CityGenerator() {
        this.cities = ResourceLoader.loadResourceFile("address/cities.txt");
    }

    @Override
    public String generate() {
        return cities.get(random.nextInt(cities.size()));
    }
}
