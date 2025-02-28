package org.dooger1.russiandatagenerator.generator.identity;

import org.dooger1.russiandatagenerator.base.DataGenerator;

import java.util.Random;

public class SnilsGenerator implements DataGenerator<String> {
    private final Random random = new Random();

    @Override
    public String generate() {
        int[] snils = new int[11];
        int checksum = 0;

        for (int i = 0; i < 9; i++) {
            snils[i] = random.nextInt(10);
            checksum += snils[i] * (9 - i);
        }

        if (checksum < 100) {
            snils[9] = checksum / 10;
            snils[10] = checksum % 10;
        } else if (checksum == 100 || checksum == 101) {
            snils[9] = 0;
            snils[10] = 0;
        } else {
            int mod = checksum % 101;
            if (mod == 100) {
                mod = 0;
            }
            snils[9] = mod / 10;
            snils[10] = mod % 10;
        }

        return formatSnils(snils);
    }

    private String formatSnils(int[] snils) {
        return String.format("%03d-%03d-%03d %02d",
                snils[0] * 100 + snils[1] * 10 + snils[2],
                snils[3] * 100 + snils[4] * 10 + snils[5],
                snils[6] * 100 + snils[7] * 10 + snils[8],
                snils[9] * 10 + snils[10]);
    }
}