package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class FelineTest {

    @Test
    void testEatMeatReturnsNonNullList() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertNotNull(food);
    }

    @Test
    void testEatMeatContainsAnimals() throws Exception {
        Feline feline = new Feline();
        List<String> food = feline.eatMeat();
        assertTrue(food.contains("Животные"));
    }

    @Test
    void testGetFamilyReturnsCorrectString() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    void testGetKittensDefault() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5})
    void testGetKittensWithParameter(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
