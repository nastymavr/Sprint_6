package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class AnimalTest {

    @Test
    void testGetFoodHerbivore() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Травоядное");
        assertNotNull(food);
        assertTrue(food.contains("Трава"));
    }

    @Test
    void testGetFoodPredator() throws Exception {
        Animal animal = new Animal();
        List<String> food = animal.getFood("Хищник");
        assertNotNull(food);
        assertTrue(food.contains("Животные"));
    }

    @Test
    void testGetFoodThrowsException() {
        Animal animal = new Animal();
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Неизвестно");
        });
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
    }

    @Test
    void testGetFamily() {
        Animal animal = new Animal();
        String family = animal.getFamily();
        assertNotNull(family);
        assertTrue(family.contains("семейств"));
    }
}
