package org.dooger1.russiandatagenerator;

import java.util.Random;

public class InnGenerator implements DataGenerator<String> {
    private static final int[] K1 = {7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private static final int[] K2 = {3, 7, 2, 4, 10, 3, 5, 9, 4, 6, 8};
    private final Random random = new Random();

    @Override
    public String generate() {
        int[] inn = new int[12];

        for (int i = 0; i < 10; i++) {
            inn[i] = random.nextInt(10);
        }

        inn[10] = calculateCRC1(inn);
        inn[11] = calculateCRC2(inn);

        StringBuilder innStr = new StringBuilder();
        for (int num : inn) {
            innStr.append(num);
        }
        return innStr.toString();
    }

    private int calculateCRC1(int[] num) {
        int crc = 0;
        for (int i = 0; i < 10; i++) {
            crc += num[i] * K1[i];
        }
        return crc % 11;
    }

    private int calculateCRC2(int[] num) {
        int crc = 0;
        for (int i = 0; i < 11; i++) {
            crc += num[i] * K2[i];
        }
        crc %= 11;
        return (crc == 10) ? 0 : crc;
    }
}