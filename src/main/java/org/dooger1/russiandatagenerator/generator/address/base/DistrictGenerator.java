package org.dooger1.russiandatagenerator.generator.address.base;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;

import java.util.List;
import java.util.Random;

public class DistrictGenerator implements DataGenerator<String> {

    private final Random random = new Random();
    private final List<String> districts;

    public DistrictGenerator() {
        this.districts = ResourceLoader.loadResourceFile("address/districts.txt");
    }

    @Override
    public String generate() {
        return districts.get(random.nextInt(districts.size()));
    }
}
