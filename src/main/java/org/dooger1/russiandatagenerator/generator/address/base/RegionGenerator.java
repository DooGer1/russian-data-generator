package org.dooger1.russiandatagenerator.generator.address.base;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;

import java.util.List;
import java.util.Random;

public class RegionGenerator implements DataGenerator<String> {
    private final List<String> regions;
    private final Random random = new Random();

    public RegionGenerator() {
        this.regions = ResourceLoader.loadResourceFile("address/regions.txt");
    }

    @Override
    public String generate() {
        return regions.get(random.nextInt(regions.size()));
    }
}