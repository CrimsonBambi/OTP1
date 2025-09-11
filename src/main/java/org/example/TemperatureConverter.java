package org.example;

public class TemperatureConverter {

    // Convert Fahrenheit to Celsius
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Convert Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Check if a Celsius temperature is extreme
    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    // Optional: main method for quick testing
    public static void main(String[] args) {
        TemperatureConverter converter = new TemperatureConverter();

        System.out.println("100°F to Celsius: " + converter.fahrenheitToCelsius(100));
        System.out.println("0°C to Fahrenheit: " + converter.celsiusToFahrenheit(0));
        System.out.println("-50°C is extreme? " + converter.isExtremeTemperature(-50));
        System.out.println("25°C is extreme? " + converter.isExtremeTemperature(25));
    }
}
