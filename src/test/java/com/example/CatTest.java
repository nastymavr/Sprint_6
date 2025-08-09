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
    void testGetFoodCallsEatMeat() throws Exception {
        Predator predator = mock(Predator.class);
        List<String> mockFood = List.of("Мыши", "Птицы");
        when(predator.eatMeat()).thenReturn(mockFood);

        Cat cat = new Cat(predator);
        List<String> food = cat.getFood();

        assertEquals(mockFood, food);
        verify(predator, times(1)).eatMeat();
    }
}
