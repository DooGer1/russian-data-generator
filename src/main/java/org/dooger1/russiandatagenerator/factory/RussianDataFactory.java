package org.dooger1.russiandatagenerator.factory;

import org.dooger1.russiandatagenerator.generator.address.AddressGenerator;
import org.dooger1.russiandatagenerator.generator.contact.PhoneNumberGenerator;
import org.dooger1.russiandatagenerator.generator.identity.InnGenerator;
import org.dooger1.russiandatagenerator.generator.identity.PersonGenerator;
import org.dooger1.russiandatagenerator.generator.identity.SnilsGenerator;

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
