package org.dooger1.russiandatagenerator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InnTest {

    @Test
    void testGenerateInn() {
        InnGenerator generator = new InnGenerator();
        String inn = generator.generate();

        assertNotNull(inn, "ИНН не должен быть null");
        assertEquals(12, inn.length(), "ИНН должен состоять из 12 цифр");
        assertTrue(inn.matches("\\d{12}"), "ИНН должен содержать только цифры");

        int[] innDigits = inn.chars().map(c -> c - '0').toArray();
        assertEquals(calculateCRC1(innDigits), innDigits[10], "Неверная контрольная сумма CRC1");
        assertEquals(calculateCRC2(innDigits), innDigits[11], "Неверная контрольная сумма CRC2");
    }

    private int calculateCRC1(int[] num) {
        int[] K1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int crc = 0;
        for (int i = 0; i < 10; i++) {
            crc += num[i] * K1[i];
        }
        return crc % 11;
    }

    private int calculateCRC2(int[] num) {
        int[] K2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int crc = 0;
        for (int i = 0; i < 11; i++) {
            crc += num[i] * K2[i];
        }
        crc %= 11;
        return (crc == 10) ? 0 : crc;
    }
}