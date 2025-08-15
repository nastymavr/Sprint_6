package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class LionTest {

    @Test
    void testGetKittensReturnsCorrectValue() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);

        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
    }

    @Test
    void testGetKittensCallsFelineMethod() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самец", feline);

        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    void testGetFoodReturnsCorrectList() throws Exception {
        Feline feline = mock(Feline.class);
        List<String> food = List.of("Животные", "Птицы");
        when(feline.getFood("Хищник")).thenReturn(food);

        Lion lion = new Lion("Самка", feline);
        List<String> result = lion.getFood();

        assertEquals(food, result);
    }

    @Test
    void testGetFoodCallsFelineMethod() throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion("Самка", feline);

        lion.getFood();
        verify(feline).getFood("Хищник");
    }
}