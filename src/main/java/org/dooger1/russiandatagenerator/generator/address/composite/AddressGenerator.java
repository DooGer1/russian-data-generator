package org.dooger1.russiandatagenerator.generator.address.composite;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.CityGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.PostalCodeGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.RegionGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.StreetGenerator;

import java.util.Random;

public class AddressGenerator implements DataGenerator<String> {
    private final RegionGenerator regionGenerator = new RegionGenerator();
    private final CityGenerator cityGenerator = new CityGenerator();
    private final StreetGenerator streetGenerator = new StreetGenerator();
    private final PostalCodeGenerator postalCodeGenerator = new PostalCodeGenerator();
    private final Random random = new Random();

    @Override
    public String generate() {
        String region = regionGenerator.generate();
        String city = cityGenerator.generate();
        String street = streetGenerator.generate();
        int houseNumber = random.nextInt(200) + 1; // Генерируем номер дома от 1 до 200
        String postalCode = postalCodeGenerator.generate();

        return String.format("%s, %s, %s, д. %d, %s", region, city, street, houseNumber, postalCode);
    }
}
