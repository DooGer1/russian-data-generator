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
        REGION_POSTAL_MAP.put("Еврейская автономная область", "679");
        REGION_POSTAL_MAP.put("Забайкальский край", "672");
        REGION_POSTAL_MAP.put("Ивановская область", "153");
        REGION_POSTAL_MAP.put("Иркутская область", "664");
        REGION_POSTAL_MAP.put("Калининградская область", "236");
        REGION_POSTAL_MAP.put("Калужская область", "248");
        REGION_POSTAL_MAP.put("Камчатский край", "683");
        REGION_POSTAL_MAP.put("Карачаево-Черкесская Республика", "369");
        REGION_POSTAL_MAP.put("Кемеровская область", "650");
        REGION_POSTAL_MAP.put("Кировская область", "610");
        REGION_POSTAL_MAP.put("Костромская область", "156");
        REGION_POSTAL_MAP.put("Краснодарский край", "350");
        REGION_POSTAL_MAP.put("Красноярский край", "660");
        REGION_POSTAL_MAP.put("Курганская область", "640");
        REGION_POSTAL_MAP.put("Курская область", "305");
        REGION_POSTAL_MAP.put("Ленинградская область", "187");
        REGION_POSTAL_MAP.put("Липецкая область", "398");
        REGION_POSTAL_MAP.put("Магаданская область", "685");
        REGION_POSTAL_MAP.put("Московская область", "140");
        REGION_POSTAL_MAP.put("Мурманская область", "183");
        REGION_POSTAL_MAP.put("Нижегородская область", "603");
        REGION_POSTAL_MAP.put("Новгородская область", "173");
        REGION_POSTAL_MAP.put("Новосибирская область", "630");
        REGION_POSTAL_MAP.put("Омская область", "644");
        REGION_POSTAL_MAP.put("Оренбургская область", "460");
        REGION_POSTAL_MAP.put("Орловская область", "302");
        REGION_POSTAL_MAP.put("Пензенская область", "440");
        REGION_POSTAL_MAP.put("Пермский край", "614");
        REGION_POSTAL_MAP.put("Приморский край", "690");
        REGION_POSTAL_MAP.put("Псковская область", "180");
        REGION_POSTAL_MAP.put("Республика Дагестан", "367");
        REGION_POSTAL_MAP.put("Республика Ингушетия", "386");
        REGION_POSTAL_MAP.put("Республика Калмыкия", "358");
        REGION_POSTAL_MAP.put("Республика Карелия", "185");
        REGION_POSTAL_MAP.put("Республика Коми", "167");
        REGION_POSTAL_MAP.put("Республика Марий Эл", "424");
        REGION_POSTAL_MAP.put("Республика Мордовия", "430");
        REGION_POSTAL_MAP.put("Республика Северная Осетия — Алания", "362");
        REGION_POSTAL_MAP.put("Республика Татарстан", "420");
        REGION_POSTAL_MAP.put("Республика Тыва", "667");
        REGION_POSTAL_MAP.put("Республика Хакасия", "655");
        REGION_POSTAL_MAP.put("Ростовская область", "344");
        REGION_POSTAL_MAP.put("Рязанская область", "390");
        REGION_POSTAL_MAP.put("Самарская область", "443");
        REGION_POSTAL_MAP.put("Саратовская область", "410");
        REGION_POSTAL_MAP.put("Сахалинская область", "693");
        REGION_POSTAL_MAP.put("Свердловская область", "620");
        REGION_POSTAL_MAP.put("Смоленская область", "214");
        REGION_POSTAL_MAP.put("Ставропольский край", "355");
        REGION_POSTAL_MAP.put("Тамбовская область", "392");
        REGION_POSTAL_MAP.put("Тверская область", "170");
        REGION_POSTAL_MAP.put("Томская область", "634");
        REGION_POSTAL_MAP.put("Тульская область", "300");
        REGION_POSTAL_MAP.put("Тюменская область", "625");
        REGION_POSTAL_MAP.put("Удмуртская Республика", "426");
        REGION_POSTAL_MAP.put("Ульяновская область", "432");
        REGION_POSTAL_MAP.put("Хабаровский край", "680");
        REGION_POSTAL_MAP.put("Ханты-Мансийский автономный округ", "628");
        REGION_POSTAL_MAP.put("Челябинская область", "454");
        REGION_POSTAL_MAP.put("Чеченская Республика", "366");
        REGION_POSTAL_MAP.put("Чувашская Республика", "428");
        REGION_POSTAL_MAP.put("Чукотский автономный округ", "689");
        REGION_POSTAL_MAP.put("Ямало-Ненецкий автономный округ", "629");
        REGION_POSTAL_MAP.put("Ярославская область", "150");
        REGION_POSTAL_MAP.put("г. Москва", "101");
        REGION_POSTAL_MAP.put("г. Санкт-Петербург", "190");
        REGION_POSTAL_MAP.put("г. Севастополь", "299");
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
