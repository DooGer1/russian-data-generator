package org.dooger1.russiandatagenerator.generator.address.base;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PostalCodeGenerator implements DataGenerator<String> {
    private static final Map<String, String> REGION_POSTAL_MAP = new HashMap<>();
    private final Random random = new Random();
    private final RegionGenerator regionGenerator = new RegionGenerator();

    static {
        loadPostalCodes();
    }

    private static void loadPostalCodes() {
        List<String> lines = ResourceLoader.loadResourceFile("address/postal_codes.txt");
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                REGION_POSTAL_MAP.put(parts[0].trim(), parts[1].trim());
            }
        }
    }

    @Override
    public String generate() {
        // Если вызывается метод без аргумента, выбираем случайный регион
        String region = regionGenerator.generate();
        return generate(region);
    }

    public String generate(String region) {
        String prefix = REGION_POSTAL_MAP.getOrDefault(region, "100");
        return prefix + String.format("%03d", random.nextInt(1000));
    }

    public static Map<String, String> getRegionPostalCodeMap() {
        return REGION_POSTAL_MAP;
    }
}
