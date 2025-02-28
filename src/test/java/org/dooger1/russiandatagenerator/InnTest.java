package org.dooger1.russiandatagenerator;

import org.dooger1.russiandatagenerator.generator.identity.InnGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class InnTest {

    @Test
    void testGenerateInn() {
        InnGenerator generator = new InnGenerator();
        String inn = generator.generate();

        assertNotNull(inn, "ИНН не должен быть null");
        assertEquals(12, inn.length(), "ИНН должен состоять из 12 цифр");
        assertTrue(inn.matches("\\d{12}"), "ИНН должен содержать только цифры");

        int[] innDigits = inn.chars().map(c -> c - '0').toArray();
        int expectedCrc1 = calculateCRC1(innDigits);
        int expectedCrc2 = calculateCRC2(innDigits);

        assertEquals(expectedCrc1, innDigits[10], "Неверная контрольная сумма CRC1");
        assertEquals(expectedCrc2, innDigits[11], "Неверная контрольная сумма CRC2");
    }

    @Test
    void testGenerateMultipleInns() {
        InnGenerator generator = new InnGenerator();
        List<String> inns = generator.size(5);

        assertEquals(5, inns.size(), "Должно быть сгенерировано 5 ИНН");
        inns.forEach(inn -> {
            assertNotNull(inn, "ИНН не должен быть null");
            assertEquals(12, inn.length(), "ИНН должен состоять из 12 цифр");
            assertTrue(inn.matches("\\d{12}"), "ИНН должен содержать только цифры");

            int[] innDigits = inn.chars().map(c -> c - '0').toArray();
            int expectedCrc1 = calculateCRC1(innDigits);
            int expectedCrc2 = calculateCRC2(innDigits);

            assertEquals(expectedCrc1, innDigits[10], "Неверная контрольная сумма CRC1");
            assertEquals(expectedCrc2, innDigits[11], "Неверная контрольная сумма CRC2");
        });
    }

    private int calculateCRC1(int[] num) {
        int[] K1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int crc = 0;
        for (int i = 0; i < 10; i++) {
            crc += num[i] * K1[i];
        }
        crc %= 11;
        return (crc == 10) ? 0 : crc; // Теперь в тесте тоже заменяем 10 на 0
    }

    private int calculateCRC2(int[] num) {
        int[] K2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
        int crc = 0;
        for (int i = 0; i < 11; i++) {
            crc += num[i] * K2[i];
        }
        crc %= 11;
        return (crc == 10) ? 0 : crc; // Теперь в тесте тоже заменяем 10 на 0
    }
}
