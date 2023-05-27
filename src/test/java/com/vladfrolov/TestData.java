package com.vladfrolov;

import com.github.javafaker.Faker;

public class TestData {

    private final static Faker FAKER = new Faker();
    public final static String FIRST_NAME = FAKER.name().firstName(),
            LAST_NAME = FAKER.name().lastName(),
            POST_CODE = FAKER.number().digits(5);
}