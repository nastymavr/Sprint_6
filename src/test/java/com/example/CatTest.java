package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.List;

public class CatTest {

    @Test
    void testGetSound() {
        Predator predator = mock(Predator.class);
        Cat cat = new Cat(predator);
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void testGetFoodReturnsExpectedList() throws Exception {
        Predator predator = mock(Predator.class);
        List<String> mockFood = List.of("Мыши", "Птицы");
        when(predator.eatMeat()).thenReturn(mockFood);

        Cat cat = new Cat(predator);
        List<String> food = cat.getFood();

        assertEquals(mockFood, food);
    }

    @Test
    void testGetFoodCallsEatMeatOnce() throws Exception {
        Predator predator = mock(Predator.class);
        when(predator.eatMeat()).thenReturn(List.of("Мыши", "Птицы"));

        Cat cat = new Cat(predator);
        cat.getFood();

        verify(predator, times(1)).eatMeat();
    }
}
