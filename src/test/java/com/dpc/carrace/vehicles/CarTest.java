package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CarTest {
    private Car underTest;
    private Race race;

    @BeforeEach
    void setUp() {
        underTest = new Car();
        race = mock(Race.class);
    }

    @Test
    @DisplayName("test normal speed calculation")
    void testNormalSpeedCalculation() {
        assertTrue(underTest.normalSpeed > 75 && underTest.normalSpeed <= 110);
    }

    @Test
    void testMoveForAnHour() {
        // given
        int currentDistance = underTest.distanceTravelled;

        // when
        underTest.moveForAnHour();
        int newDistance = underTest.distanceTravelled;
        int actualSpeed = underTest.actualSpeed;

        int expectedDistance = currentDistance + actualSpeed;

        assertEquals(expectedDistance, newDistance);
    }

    @Test
    void reducedSpeedIfYellowFlagActive() {
        when(race.isYellowFlagActive()).thenReturn(true);
        underTest.prepareForLap(race);

        int expectedSpeed = 75;
        int actualSpeed = underTest.actualSpeed;

        assertEquals(actualSpeed, expectedSpeed);
    }

    @Test
    void normalSpeedIfYellowFlagNotActive() {
        when(race.isYellowFlagActive()).thenReturn(false);
        underTest.prepareForLap(race);

        int expectedSpeed = underTest.actualSpeed;
        int actualSpeed = underTest.actualSpeed;

        assertEquals(expectedSpeed, actualSpeed);
    }

    @Test
    void testToStringMethod() {
        String expectedResult = "{" +
                "distance travelled: " +
                underTest.distanceTravelled +
                ", " +
                "type: " +
                "Car" +
                ", " +
                "name: " +
                underTest.name +
                "}";
        String actualResult = underTest.toString();

        assertEquals(expectedResult, actualResult);
    }
}