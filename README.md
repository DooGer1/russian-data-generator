# Russian Data Generator

![Build](https://github.com/dooger1/russian-data-generator/actions/workflows/build.yml/badge.svg)
![Coverage](https://img.shields.io/badge/coverage-96%25-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue)

## Описание
**Russian Data Generator** — это библиотека на Java, предназначенная для генерации случайных данных, соответствующих российскому формату. Она может использоваться для тестирования, заполнения баз данных, а также анонимизации данных. Библиотека позволяет генерировать:

- ФИО (Фамилия, Имя, Отчество)
- ИНН физических лиц (12 знаков)
- СНИЛС (страховой номер индивидуального лицевого счета)
- Адреса (область, район, город, улица, индекс, полный адрес)
- Номера телефонов

## Совместимость
Библиотека написана на Java и поддерживает версии **Java 8 и выше**.

## Установка
### Установка через релиз на GitHub
1. Перейдите в раздел **Releases** репозитория:  
   [GitHub Releases](https://github.com/ВАШ_GITHUB_АККАУНТ/russian-data-generator/releases)
2. Скачайте `JAR`-файл последнего релиза (`russian-data-generator-1.0.0.jar`).
3. Подключите библиотеку в ваш проект.

#### Для **Maven**-проекта
1. Скопируйте скачанный `JAR` в локальный репозиторий Maven:
   ```sh
   mvn install:install-file -Dfile=путь_до_JAR -DgroupId=org.dooger1 -DartifactId=russian-data-generator -Dversion=1.0.0 -Dpackaging=jar
   ```
2. Добавьте зависимость в `pom.xml`:
   ```xml
   <dependency>
       <groupId>org.dooger1</groupId>
       <artifactId>russian-data-generator</artifactId>
       <version>1.0.0</version>
   </dependency>
   ```

#### Для **Gradle**-проекта
1. Переместите скачанный `JAR` в папку `libs` внутри проекта.
2. Добавьте в `build.gradle`:
   ```gradle
   repositories {
       flatDir {
           dirs 'libs'
       }
   }
   dependencies {
       implementation name: 'russian-data-generator-1.0.0'
   }
   ```

## Использование
### Генерация ФИО
```java
import org.dooger1.russiandatagenerator.PersonGenerator;

public class Main {
    public static void main(String[] args) {
        PersonGenerator generator = new PersonGenerator();
        String fullName = generator.generate();
        System.out.println("Случайное ФИО: " + fullName);
    }
}
```

### Генерация ИНН
```java
import org.dooger1.russiandatagenerator.InnGenerator;

public class Main {
    public static void main(String[] args) {
        InnGenerator generator = new InnGenerator();
        String inn = generator.generate();
        System.out.println("Случайный ИНН: " + inn);
    }
}
```

### Генерация СНИЛС
```java
import org.dooger1.russiandatagenerator.SnilsGenerator;

public class Main {
    public static void main(String[] args) {
        SnilsGenerator generator = new SnilsGenerator();
        String snils = generator.generate();
        System.out.println("Случайный СНИЛС: " + snils);
    }
}
```

### Генерация полного адреса
```java
import org.dooger1.russiandatagenerator.FullAddressGenerator;

public class Main {
    public static void main(String[] args) {
        FullAddressGenerator generator = new FullAddressGenerator();
        String address = generator.generate();
        System.out.println("Случайный адрес: " + address);
    }
}
```

## Локализация
Библиотека поддерживает генерацию данных только в российском формате.

## Лицензия
**Russian Data Generator** распространяется под лицензией **MIT**.

## Авторы
- **dooger1** - основной разработчик

Если у вас есть предложения или ошибки, пожалуйста, создавайте issue на GitHub-репозитории проекта.

