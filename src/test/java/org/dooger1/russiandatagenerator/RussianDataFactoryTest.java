package org.dooger1.russiandatagenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RussianDataFactoryTest {

    @Test
    void testGenerateFullName() {
        String fullName = RussianDataFactory.generateFullName();
        assertNotNull(fullName);
        assertTrue(fullName.split(" ").length == 3, "ФИО должно состоять из трех слов");
    }

    @Test
    void testGenerateSnils() {
        String snils = RussianDataFactory.generateSnils();
        assertNotNull(snils);
        assertTrue(snils.matches("\\d{3}-\\d{3}-\\d{3} \\d{2}"), "Формат СНИЛСа неверный");
    }

    @Test
    void testGenerateInn() {
        String inn = RussianDataFactory.generateInn();
        assertNotNull(inn);
        assertEquals(12, inn.length(), "ИНН должен состоять из 12 цифр");
    }

    @Test
    void testGeneratePhoneNumber() {
        String phoneNumber = RussianDataFactory.generatePhoneNumber();
        assertNotNull(phoneNumber);
        assertTrue(phoneNumber.matches("\\+7 \\(\\d{3}\\) \\d{3}-\\d{2}-\\d{2}"), "Формат телефона неверный");
    }

    @Test
    void testGenerateAddress() {
        String address = RussianDataFactory.generateAddress();
        assertNotNull(address);
        assertTrue(address.startsWith("ул. "), "Адрес должен начинаться с 'ул.'");
    }
}
