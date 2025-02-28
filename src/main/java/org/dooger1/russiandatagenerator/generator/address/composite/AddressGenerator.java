package org.dooger1.russiandatagenerator.generator.address.composite;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.CityGenerator;
import org.dooger1.russiandatagenerator.generator.address.base.StreetGenerator;

import java.util.Random;

public class AddressGenerator implements DataGenerator<String> {
    private final CityGenerator cityGenerator = new CityGenerator();
    private final StreetGenerator streetGenerator = new StreetGenerator();
    private final Random random = new Random();

    @Override
    public String generate() {
        String city = cityGenerator.generate();
        String street = streetGenerator.generate();
        int houseNumber = random.nextInt(200) + 1; // Номер дома от 1 до 200

        return String.format("%s, %s, д. %d", city, street, houseNumber);
    }
}