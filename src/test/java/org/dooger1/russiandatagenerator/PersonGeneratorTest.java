package org.dooger1.russiandatagenerator;

import org.dooger1.russiandatagenerator.generator.identity.PersonGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Field;
import java.util.List;

public class PersonGeneratorTest {

    @Test
    void testGenerateFullName() throws NoSuchFieldException, IllegalAccessException {
        PersonGenerator generator = new PersonGenerator();
        String fullName = generator.generate();

        assertNotNull(fullName, "ФИО не должно быть null");
        String[] parts = fullName.split(" ");
        assertEquals(3, parts.length, "ФИО должно состоять из трех частей");

        String lastName = parts[0];
        String firstName = parts[1];
        String middleName = parts[2];

        boolean isFemale = lastName.endsWith("а");
        String[] firstNames, middleNames;

        if (isFemale) {
            firstNames = getPrivateStaticField(PersonGenerator.class, "FIRST_NAMES_FEMALE");
            middleNames = getPrivateStaticField(PersonGenerator.class, "MIDDLE_NAMES_FEMALE");
        } else {
            firstNames = getPrivateStaticField(PersonGenerator.class, "FIRST_NAMES_MALE");
            middleNames = getPrivateStaticField(PersonGenerator.class, "MIDDLE_NAMES_MALE");
        }

        assertTrue(contains(firstNames, firstName), "Имя должно быть в списке");
        assertTrue(contains(middleNames, middleName), "Отчество должно быть в списке");
    }

    @Test
    void testGenerateMultipleFullNames() throws NoSuchFieldException, IllegalAccessException {
        PersonGenerator generator = new PersonGenerator();
        List<String> fullNames = generator.size(5);

        assertEquals(5, fullNames.size(), "Должно быть сгенерировано 5 ФИО");

        for (String fullName : fullNames) {
            assertNotNull(fullName, "ФИО не должно быть null");
            String[] parts = fullName.split(" ");
            assertEquals(3, parts.length, "ФИО должно состоять из трех частей");

            String lastName = parts[0];
            String firstName = parts[1];
            String middleName = parts[2];

            boolean isFemale = lastName.endsWith("а");
            String[] firstNames, middleNames;

            if (isFemale) {
                firstNames = getPrivateStaticField(PersonGenerator.class, "FIRST_NAMES_FEMALE");
                middleNames = getPrivateStaticField(PersonGenerator.class, "MIDDLE_NAMES_FEMALE");
            } else {
                firstNames = getPrivateStaticField(PersonGenerator.class, "FIRST_NAMES_MALE");
                middleNames = getPrivateStaticField(PersonGenerator.class, "MIDDLE_NAMES_MALE");
            }

            assertTrue(contains(firstNames, firstName), "Имя должно быть в списке");
            assertTrue(contains(middleNames, middleName), "Отчество должно быть в списке");
        }
    }

    private boolean contains(String[] array, String value) {
        for (String s : array) {
            if (s.equals(value)) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private static String[] getPrivateStaticField(Class<?> clazz, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        return (String[]) field.get(null);
    }
}
