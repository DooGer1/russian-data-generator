package org.dooger1.russiandatagenerator;

import org.dooger1.russiandatagenerator.generator.identity.PersonGenerator;
import org.dooger1.russiandatagenerator.utils.ResourceLoader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PersonGeneratorTest {

    @Test
    void testGenerateFullName() {
        PersonGenerator generator = new PersonGenerator();
        String fullName = generator.generate();

        assertNotNull(fullName, "ФИО не должно быть null");
        String[] parts = fullName.split(" ");
        assertEquals(3, parts.length, "ФИО должно состоять из трех частей");

        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];

        boolean isFemale = lastName.endsWith("а");

        List<String> firstNames = isFemale
                ? ResourceLoader.loadResourceFile("identity/first_names_female.txt")
                : ResourceLoader.loadResourceFile("identity/first_names_male.txt");

        List<String> middleNames = isFemale
                ? ResourceLoader.loadResourceFile("identity/middle_names_female.txt")
                : ResourceLoader.loadResourceFile("identity/middle_names_male.txt");

        assertTrue(firstNames.contains(firstName), "Имя должно быть в списке");
        assertTrue(middleNames.contains(middleName), "Отчество должно быть в списке");
    }

    @Test
    void testGenerateMultipleFullNames() {
        PersonGenerator generator = new PersonGenerator();
        List<String> fullNames = generator.size(5);

        assertEquals(5, fullNames.size(), "Должно быть сгенерировано 5 ФИО");
        fullNames.forEach(name -> assertNotNull(name, "ФИО не должно быть null"));
    }
}
