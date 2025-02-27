package org.dooger1.russiandatagenerator;

import java.util.Random;

public class RegionGenerator implements DataGenerator<String> {
    private static final String[] REGIONS = {
            "Республика Адыгея", "Республика Алтай", "Алтайский край", "Амурская область",
            "Архангельская область", "Астраханская область", "Республика Башкортостан",
            "Белгородская область", "Брянская область", "Республика Бурятия",
            "Владимирская область", "Волгоградская область", "Вологодская область", "Воронежская область"
    };
    private final Random random = new Random();

    @Override
    public String generate() {
        return REGIONS[random.nextInt(REGIONS.length)];
    }
}