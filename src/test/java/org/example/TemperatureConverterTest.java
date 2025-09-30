package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    private TemperatureConverter converter;

    @BeforeEach
    void setUp() {
        converter = new TemperatureConverter();
    }

    @Test
    void fahrenheitToCelsius() {
        assertEquals(0, converter.fahrenheitToCelsius(32), 0.0001);
        assertEquals(100, converter.fahrenheitToCelsius(212), 0.0001);
        assertEquals(-40, converter.fahrenheitToCelsius(-40), 0.0001);
    }

    @Test
    void celsiusToFahrenheit() {
        assertEquals(32, converter.celsiusToFahrenheit(0), 0.0001);
        assertEquals(212, converter.celsiusToFahrenheit(100), 0.0001);
        assertEquals(-40, converter.celsiusToFahrenheit(-40), 0.0001);
    }

    @Test
    void isExtremeTemperature() {
        assertTrue(converter.isExtremeTemperature(-50));  // below -40°C
        assertTrue(converter.isExtremeTemperature(51));   // above 50°C
        assertFalse(converter.isExtremeTemperature(25));  // normal temperature
        assertFalse(converter.isExtremeTemperature(0));   // normal temperature
    }

    // New test
    @Test
    void kelvinToCelsius() {
        assertEquals(0, converter.kelvinToCelsius(273.15), 0.0001);      // freezing point
        assertEquals(100, converter.kelvinToCelsius(373.15), 0.0001);    // boiling point
        assertEquals(26.85, converter.kelvinToCelsius(300), 0.0001);     // example case
        assertEquals(-273.15, converter.kelvinToCelsius(0), 0.0001);     // absolute zero
    }

    @Test
    void mainMethodRuns() {
        String[] args = {};
        TemperatureConverter.main(args);
    }
}