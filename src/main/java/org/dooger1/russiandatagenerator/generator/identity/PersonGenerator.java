package org.dooger1.russiandatagenerator.generator.identity;

import org.dooger1.russiandatagenerator.base.DataGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;

import java.util.List;
import java.util.Random;

public class PersonGenerator implements DataGenerator<String> {
    private static final List<String> FIRST_NAMES_MALE;
    private static final List<String> FIRST_NAMES_FEMALE;
    private static final List<String> LAST_NAMES;
    private static final List<String> MIDDLE_NAMES_MALE;
    private static final List<String> MIDDLE_NAMES_FEMALE;

    private final Random random = new Random();

    static {
        FIRST_NAMES_MALE = ResourceLoader.loadResourceFile("identity/first_names_male.txt");
        FIRST_NAMES_FEMALE = ResourceLoader.loadResourceFile("identity/first_names_female.txt");
        LAST_NAMES = ResourceLoader.loadResourceFile("identity/last_names.txt");
        MIDDLE_NAMES_MALE = ResourceLoader.loadResourceFile("identity/middle_names_male.txt");
        MIDDLE_NAMES_FEMALE = ResourceLoader.loadResourceFile("identity/middle_names_female.txt");
    }

    @Override
    public String generate() {
        boolean isMale = random.nextBoolean();
        String firstName = isMale ? getRandomElement(FIRST_NAMES_MALE) : getRandomElement(FIRST_NAMES_FEMALE);
        String lastName = getRandomElement(LAST_NAMES);
        String middleName = isMale ? getRandomElement(MIDDLE_NAMES_MALE) : getRandomElement(MIDDLE_NAMES_FEMALE);

        if (!isMale) {
            lastName += "а"; // Добавляем окончание для женской фамилии
        }

        return lastName + " " + firstName + " " + middleName;
    }

    private String getRandomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }
}
