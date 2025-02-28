package org.dooger1.russiandatagenerator;

import org.dooger1.russiandatagenerator.generator.address.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Map;

public class AddressTest {

    @Test
    void testGenerateRegion() {
        RegionGenerator generator = new RegionGenerator();
        String region = generator.generate();
        assertNotNull(region, "Регион не должен быть null");
        assertFalse(region.isEmpty(), "Регион не должен быть пустым");

        List<String> regions = generator.size(5);
        assertEquals(5, regions.size(), "Должно быть сгенерировано 5 регионов");
        regions.forEach(r -> assertNotNull(r));
    }

    @Test
    void testGenerateDistrict() {
        DistrictGenerator generator = new DistrictGenerator();
        String district = generator.generate();
        assertNotNull(district, "Район не должен быть null");
        assertFalse(district.isEmpty(), "Район не должен быть пустым");

        List<String> districts = generator.size(5);
        assertEquals(5, districts.size(), "Должно быть сгенерировано 5 районов");
        districts.forEach(d -> assertNotNull(d));
    }

    @Test
    void testGenerateCity() {
        CityGenerator generator = new CityGenerator();
        String city = generator.generate();
        assertNotNull(city, "Город не должен быть null");
        assertFalse(city.isEmpty(), "Город не должен быть пустым");

        List<String> cities = generator.size(5);
        assertEquals(5, cities.size(), "Должно быть сгенерировано 5 городов");
        cities.forEach(c -> assertNotNull(c));
    }

    @Test
    void testGenerateStreet() {
        StreetGenerator generator = new StreetGenerator();
        String street = generator.generate();
        assertNotNull(street, "Улица не должна быть null");
        assertFalse(street.isEmpty(), "Улица не должна быть пустой");

        List<String> streets = generator.size(5);
        assertEquals(5, streets.size(), "Должно быть сгенерировано 5 улиц");
        streets.forEach(s -> assertNotNull(s));
    }

    @Test
    void testGeneratePostalCode() {
        PostalCodeGenerator generator = new PostalCodeGenerator();
        String region = new RegionGenerator().generate();
        String postalCode = generator.generate(region);
        assertNotNull(postalCode, "Почтовый индекс не должен быть null");
        assertTrue(postalCode.matches("\\d{6}"), "Почтовый индекс должен состоять из 6 цифр");

        List<String> postalCodes = generator.size(5);
        assertEquals(5, postalCodes.size(), "Должно быть сгенерировано 5 почтовых индексов");
        postalCodes.forEach(pc -> assertTrue(pc.matches("\\d{6}")));
    }

    @Test
    void testGenerateFullAddress() {
        FullAddressGenerator generator = new FullAddressGenerator();
        String fullAddress = generator.generate();
        assertNotNull(fullAddress, "Полный адрес не должен быть null");
        assertFalse(fullAddress.isEmpty(), "Полный адрес не должен быть пустым");
        assertTrue(fullAddress.contains("д."), "Адрес должен содержать номер дома");

        // Проверка соответствия региона и почтового индекса
        String[] addressParts = fullAddress.split(", ");
        String region = addressParts[0];
        String postalCode = addressParts[addressParts.length - 1];

        Map<String, String> regionPostalCodeMap = PostalCodeGenerator.getRegionPostalCodeMap();
        assertTrue(regionPostalCodeMap.containsKey(region), "Регион должен быть в списке");
        assertTrue(postalCode.startsWith(regionPostalCodeMap.get(region)), "Почтовый индекс должен соответствовать региону");

        List<String> fullAddresses = generator.size(5);
        assertEquals(5, fullAddresses.size(), "Должно быть сгенерировано 5 полных адресов");
        fullAddresses.forEach(addr -> assertNotNull(addr));
    }
}
