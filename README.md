# Russian Data Generator
[![Maven Central](https://img.shields.io/maven-central/v/io.github.dooger1/russian-data-generator.svg)](https://search.maven.org/artifact/io.github.dooger1/russian-data-generator/)
![Build](https://github.com/DooGer1/russian-data-generator/actions/workflows/build.yml/badge.svg)
![Coverage](https://img.shields.io/badge/coverage-96%25-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

## Описание
**Russian Data Generator** — это библиотека на Java для генерации случайных данных, соответствующих российскому формату. Она используется для тестирования, заполнения баз данных и анонимизации данных.

**Возможности**:
- Генерация **ФИО** (Фамилия, Имя, Отчество)
- Генерация **ИНН** (12-значного для физических лиц)
- Генерация **СНИЛС** (страхового номера индивидуального лицевого счета)
- Генерация **адресов** (область, район, город, улица, индекс, полный адрес)
- Генерация **номеров телефонов**

## Установка
### **Через Maven Central**
Библиотека доступна в **Maven Central** и может быть подключена напрямую.

#### **Maven**
Добавьте зависимость в `pom.xml`:
```xml
<dependency>
    <groupId>io.github.dooger1</groupId>
    <artifactId>russian-data-generator</artifactId>
    <version>1.0.0</version>
</dependency>
```

#### **Gradle (Kotlin DSL)**
```kotlin
dependencies {
    implementation("io.github.dooger1:russian-data-generator:1.0.0")
}
```

#### **Gradle (Groovy DSL)**
```gradle
dependencies {
    implementation 'io.github.dooger1:russian-data-generator:1.0.0'
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

### **Генерация СНИЛС**
```java
import io.github.dooger1.russiandatagenerator.SnilsGenerator;

public class Main {
    public static void main(String[] args) {
        SnilsGenerator generator = new SnilsGenerator();
        String snils = generator.generate();
        System.out.println("Случайный СНИЛС: " + snils);
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

## Лицензия
**Russian Data Generator** распространяется под лицензией **MIT**.

## Контакты
Если у вас есть предложения или ошибки, пожалуйста, создавайте issue на GitHub:  
🔗 [https://github.com/DooGer1/russian-data-generator/issues](https://github.com/DooGer1/russian-data-generator/issues)

