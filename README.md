# Russian Data Generator

![Build](https://github.com/DooGer1/russian-data-generator/actions/workflows/build.yml/badge.svg)
![Coverage](https://img.shields.io/badge/coverage-96%25-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)
![Maven Central](https://img.shields.io/maven-central/v/io.github.dooger1/russian-data-generator)

## Описание
**Russian Data Generator** — это библиотека на Java для генерации случайных данных, соответствующих российскому формату. Она используется для тестирования, заполнения баз данных и анонимизации данных.

**Возможности**:
- Генерация **ФИО** (Фамилия, Имя, Отчество)
- Генерация **ИНН** (12-значного для физических лиц)
- Генерация **СНИЛС** (страхового номера индивидуального лицевого счета)
- Генерация **адресов** (область, район, город, улица, индекс, полный адрес)
- Генерация **номеров телефонов**
- Поддержка генерации массивов данных с помощью `.size(n)`

## Установка
### **Через Maven Central**
Библиотека доступна в **Maven Central** и может быть подключена напрямую.

#### **Maven**
Добавьте зависимость в `pom.xml`:
```xml
<dependency>
    <groupId>io.github.dooger1</groupId>
    <artifactId>russian-data-generator</artifactId>
    <version>1.1.0</version>
</dependency>
```

#### **Gradle**
```gradle
dependencies {
    implementation 'io.github.dooger1:russian-data-generator:1.1.0'
}
```

## Использование
### **Генерация ФИО**
```java
import io.github.dooger1.russiandatagenerator.PersonGenerator;

public class Main {
    public static void main(String[] args) {
        PersonGenerator generator = new PersonGenerator();
        String fullName = generator.generate();
        System.out.println("Случайное ФИО: " + fullName);
    }
}
```

### **Генерация нескольких ФИО**
```java
List<String> fullNames = new PersonGenerator().size(5);
fullNames.forEach(System.out::println);
```

### **Генерация ИНН**
```java
import io.github.dooger1.russiandatagenerator.InnGenerator;

public class Main {
    public static void main(String[] args) {
        InnGenerator generator = new InnGenerator();
        String inn = generator.generate();
        System.out.println("Случайный ИНН: " + inn);
    }
}
```

### **Генерация полного адреса**
```java
import io.github.dooger1.russiandatagenerator.FullAddressGenerator;

public class Main {
    public static void main(String[] args) {
        FullAddressGenerator generator = new FullAddressGenerator();
        String address = generator.generate();
        System.out.println("Случайный адрес: " + address);
    }
}
```

### **Генерация нескольких адресов**
```java
List<String> addresses = new AddressGenerator().size(5);
addresses.forEach(System.out::println);
```

### **Генерация номеров телефонов**
```java
import io.github.dooger1.russiandatagenerator.PhoneNumberGenerator;

public class Main {
    public static void main(String[] args) {
        PhoneNumberGenerator generator = new PhoneNumberGenerator();
        String phone = generator.generate();
        System.out.println("Случайный номер телефона: " + phone);
    }
}
```

## 📦 Хранение ресурсов
Для удобства генерации **списки регионов, городов и улиц** хранятся в файлах **в ресурсах (`resources/`)**:
- `regions.txt` – список регионов
- `cities.txt` – список городов
- `streets.txt` – список улиц
- `districts.txt` – список районов
- `postal_codes.csv` – соответствие регионов и почтовых индексов

Пример `postal_codes.csv`:
```
Московская область,140
Санкт-Петербург,190
Челябинская область,454
...
```
Пример загрузки:
```java
List<String> regions = ResourceLoader.loadList("regions.txt");
```

## Лицензия
**Russian Data Generator** распространяется под лицензией **MIT**.

## Контакты
Если у вас есть предложения или ошибки, пожалуйста, создавайте issue на GitHub:  
🔗 [https://github.com/DooGer1/russian-data-generator/issues](https://github.com/DooGer1/russian-data-generator/issues)

