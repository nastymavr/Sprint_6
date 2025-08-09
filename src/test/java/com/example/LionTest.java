package com.example;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class LionTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    void testDoesHaveMane(String sex, boolean expectedHasMane) throws Exception {
        Feline feline = mock(Feline.class);
        Lion lion = new Lion(sex, feline);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void testConstructorThrowsExceptionForInvalidSex() {
        Feline feline = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("неизвестно", feline);
        });
        assertTrue(exception.getMessage().contains("Используйте допустимые значения пола животного"));
    }

    @Test
    void testGetKittensDelegatesToFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Самец", feline);
        assertEquals(3, lion.getKittens());
        verify(feline).getKittens();
    }

    @Test
    void testGetFoodDelegatesToFeline() throws Exception {
        Feline feline = mock(Feline.class);
        List<String> food = List.of("Животные", "Птицы");
        when(feline.getFood("Хищник")).thenReturn(food);

        Lion lion = new Lion("Самка", feline);
        List<String> result = lion.getFood();

        assertEquals(food, result);
        verify(feline).getFood("Хищник");
    }
}
