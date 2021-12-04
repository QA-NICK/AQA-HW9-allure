package ru.netology.data;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    ;


//    @Test
//    public void generateCity() {
//        Faker faker = new Faker(new Locale("ru"));
//        String city = faker.address().city();
//        String name = faker.name().fullName();
//        String phone = faker.phoneNumber().phoneNumber();
//
//
//        System.out.println(city + " " + name + " " + phone);
//    }

    public static String generateCity() {
        Faker faker = new Faker(new Locale("ru"));
        String city = faker.address().city();
        return city;
    }
    public static String generateData(int days) {
        String date = LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;


    }

    public static String generateName() {
        Faker faker = new Faker(new Locale("ru"));
        String name = faker.name().fullName();
        return name;
    }
    public static String generatePhone() {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

}
