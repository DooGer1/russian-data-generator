package org.dooger1.russiandatagenerator;

import org.dooger1.russiandatagenerator.generator.address.composite.AddressGenerator;
import org.dooger1.russiandatagenerator.generator.address.composite.FullAddressGenerator;
import org.dooger1.russiandatagenerator.generator.contact.PhoneNumberGenerator;
import org.dooger1.russiandatagenerator.generator.identity.InnGenerator;
import org.dooger1.russiandatagenerator.generator.identity.PersonGenerator;
import org.dooger1.russiandatagenerator.generator.identity.SnilsGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class RussianDataFactoryTest {

    @Test
    void testGenerateFullName() {
        PersonGenerator generator = new PersonGenerator();
        String fullName = generator.generate();
        assertNotNull(fullName);
        assertTrue(fullName.split(" ").length == 3, "ФИО должно состоять из трех слов");
    }

    @Test
    void testGenerateMultipleFullNames() {
        PersonGenerator generator = new PersonGenerator();
        List<String> fullNames = generator.size(5);
        assertEquals(5, fullNames.size(), "Должно быть сгенерировано 5 ФИО");

        fullNames.forEach(fullName -> {
            assertNotNull(fullName);
            assertTrue(fullName.split(" ").length == 3, "ФИО должно состоять из трех слов");
        });
    }

    @Test
    void testGenerateSnils() {
        SnilsGenerator generator = new SnilsGenerator();
        String snils = generator.generate();
        assertNotNull(snils);
        assertTrue(snils.matches("\\d{3}-\\d{3}-\\d{3} \\d{2}"), "Формат СНИЛСа неверный");
    }

    @Test
    void testGenerateMultipleSnils() {
        SnilsGenerator generator = new SnilsGenerator();
        List<String> snilsList = generator.size(5);
        assertEquals(5, snilsList.size(), "Должно быть сгенерировано 5 СНИЛСов");

        snilsList.forEach(snils -> {
            assertNotNull(snils);
            assertTrue(snils.matches("\\d{3}-\\d{3}-\\d{3} \\d{2}"), "Формат СНИЛСа неверный");
        });
    }

    @Test
    void testGenerateInn() {
        InnGenerator generator = new InnGenerator();
        String inn = generator.generate();
        assertNotNull(inn);
        assertEquals(12, inn.length(), "ИНН должен состоять из 12 цифр");
    }

    @Test
    void testGenerateMultipleInn() {
        InnGenerator generator = new InnGenerator();
        List<String> inns = generator.size(5);
        assertEquals(5, inns.size(), "Должно быть сгенерировано 5 ИНН");

        inns.forEach(inn -> {
            assertNotNull(inn);
            assertEquals(12, inn.length(), "ИНН должен состоять из 12 цифр");
        });
    }

    @Test
    void testGeneratePhoneNumber() {
        PhoneNumberGenerator generator = new PhoneNumberGenerator();
        String phoneNumber = generator.generate();
        assertNotNull(phoneNumber);
        assertTrue(phoneNumber.matches("\\+7 \\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}"), "Формат телефона неверный");
    }

    @Test
    void testGenerateMultiplePhoneNumbers() {
        PhoneNumberGenerator generator = new PhoneNumberGenerator();
        List<String> phoneNumbers = generator.size(5);
        assertEquals(5, phoneNumbers.size(), "Должно быть сгенерировано 5 номеров телефонов");

        phoneNumbers.forEach(phoneNumber -> {
            assertNotNull(phoneNumber);
            assertTrue(phoneNumber.matches("\\+7 \\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}"), "Формат телефона неверный");
        });
    }

    @Test
    void testGenerateAddress() {
        AddressGenerator generator = new AddressGenerator();
        String address = generator.generate();
        assertNotNull(address);
        assertTrue(address.matches("^[А-Яа-яЁё\\-\\s]+, ул\\. [А-Яа-яЁё\\d\\-\\s]+, д\\. \\d+$"),
                "Формат адреса неверный: " + address);
    }

    @Test
    void testGenerateMultipleAddresses() {
        AddressGenerator generator = new AddressGenerator();
        List<String> addresses = generator.size(5);
        assertEquals(5, addresses.size(), "Должно быть сгенерировано 5 адресов");

        addresses.forEach(address -> {
            assertNotNull(address, "Адрес не должен быть null");
            assertTrue(
                    address.matches("^[А-Яа-яЁё\\-\\s]+, ул\\. [А-Яа-яЁё\\d\\-\\s]+, д\\. \\d+$"),
                    "Формат адреса неверный: " + address
            );
        });
    }
    @Test
    void testGenerateMultipleFullAddresses() {
        FullAddressGenerator generator = new FullAddressGenerator();
        List<String> addresses = generator.size(5);
        assertEquals(5, addresses.size(), "Должно быть сгенерировано 5 полных адресов");

        addresses.forEach(address -> {
            assertNotNull(address, "Полный адрес не должен быть null");
            assertTrue(
                    address.matches("^[А-Яа-яЁё\\-\\s]+, [А-Яа-яЁё\\-\\s]+, ул\\. [А-Яа-яЁё\\d\\-\\s]+, д\\. \\d+, \\d{6}$"),
                    "Формат полного адреса неверный: " + address
            );
        });
    }
}
