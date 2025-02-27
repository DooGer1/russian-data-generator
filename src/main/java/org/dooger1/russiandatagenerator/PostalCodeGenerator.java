package org.dooger1.russiandatagenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PostalCodeGenerator implements DataGenerator<String> {
    private static final Map<String, String> REGION_POSTAL_MAP = new HashMap<>();
    private final Random random = new Random();
    private final RegionGenerator regionGenerator = new RegionGenerator();

    static {
        REGION_POSTAL_MAP.put("Республика Адыгея", "385");
        REGION_POSTAL_MAP.put("Республика Алтай", "649");
        REGION_POSTAL_MAP.put("Алтайский край", "656");
        REGION_POSTAL_MAP.put("Амурская область", "675");
        REGION_POSTAL_MAP.put("Архангельская область", "163");
        REGION_POSTAL_MAP.put("Астраханская область", "414");
        REGION_POSTAL_MAP.put("Республика Башкортостан", "450");
        REGION_POSTAL_MAP.put("Белгородская область", "308");
        REGION_POSTAL_MAP.put("Брянская область", "241");
        REGION_POSTAL_MAP.put("Республика Бурятия", "670");
        REGION_POSTAL_MAP.put("Владимирская область", "600");
        REGION_POSTAL_MAP.put("Волгоградская область", "400");
        REGION_POSTAL_MAP.put("Вологодская область", "160");
        REGION_POSTAL_MAP.put("Воронежская область", "394");
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
