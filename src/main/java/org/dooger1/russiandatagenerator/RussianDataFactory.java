package org.dooger1.russiandatagenerator;

public class RussianDataFactory {
    public static String generateFullName() {
        return new PersonGenerator().generate();
    }
    public static String generateSnils() {
        return new SnilsGenerator().generate();
    }
    public static String generateInn() {
        return new InnGenerator().generate();
    }
    public static String generatePhoneNumber() {
        return new PhoneNumberGenerator().generate();
    }
    public static String generateAddress() {
        return new AddressGenerator().generate();
    }
}
