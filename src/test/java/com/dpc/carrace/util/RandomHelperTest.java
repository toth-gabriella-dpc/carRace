package com.dpc.carrace.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomHelperTest {
    private final Random RANDOM = new Random();
    private List<String> testList;

    @BeforeEach
    void setUp() {
    }

    @Test
    void nullListShouldThrowException() {
        // given
        String expectedErrorMessage = "Possibilities should be a non-empty array of Strings.";

        // when
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            RandomHelper.chooseOne(testList);
        });

        String givenErrorMessage = exception.getMessage();

        // then
        assertEquals(expectedErrorMessage, givenErrorMessage);
    }

    @Test
    void emptyListShouldThrowException() {
        // given
        String expectedErrorMessage = "Possibilities should be a non-empty array of Strings.";
        testList = new ArrayList<>();

        // when
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            RandomHelper.chooseOne(testList);
        });

        String givenErrorMessage = exception.getMessage();

        // then
        assertEquals(expectedErrorMessage, givenErrorMessage);
    }

    @Test
    void listWithElementsShouldRandomlyChooseOne() {
        // given
        testList = List.of("a", "b", "c");

        String actualValue = RandomHelper.chooseOne(testList);

        // when
        assertTrue(testList.contains(actualValue));
    }

    @Test
    void getRandomValueInRange() {
        // given
        int max = 10;
        int min = 1;

        int actual = RandomHelper.randomizeNumberInRange(max, min);

        assertTrue(actual <= max && actual > min);

        // given
        int max2 = 20;
        int min2 = 10;

        int actual2 = RandomHelper.randomizeNumberInRange(max2, min2);

        assertTrue(actual2 <= max2 && actual2 > min2);
    }

    @Test
    void testRandomizeWithProbability() {
        
    }
}
