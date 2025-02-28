package org.dooger1.russiandatagenerator.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

public class ResourceLoader {

    public static List<String> loadResourceFile(String filePath) {
        try (InputStream inputStream = ResourceLoader.class.getClassLoader().getResourceAsStream(filePath);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            if (inputStream == null) {
                throw new IllegalArgumentException("Файл не найден: " + filePath);
            }
            return reader.lines().collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки файла: " + filePath, e);
        }
    }
}
