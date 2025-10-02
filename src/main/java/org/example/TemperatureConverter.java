package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TemperatureConverter extends Application {

    @Override
    public void start(Stage stage) {
        // celsius to fahrenheit
        Label labelCtoF = new Label("Enter Celsius:");
        TextField inputCtoF = new TextField();
        Button btnCtoF = new Button("Celsius to Fahrenheit");
        Label resultCtoF = new Label();
        btnCtoF.setOnAction(e -> {
            try {
                double celsius = Double.parseDouble(inputCtoF.getText());
                resultCtoF.setText("Fahrenheit: " + celsiusToFahrenheit(celsius));
            } catch (NumberFormatException ex) {
                resultCtoF.setText("Invalid input!");
            }
        });

        // fahrenheit to celsius
        Label labelFtoC = new Label("Enter Fahrenheit:");
        TextField inputFtoC = new TextField();
        Button btnFtoC = new Button("Fahrenheit to Celsius");
        Label resultFtoC = new Label();
        btnFtoC.setOnAction(e -> {
            try {
                double fahrenheit = Double.parseDouble(inputFtoC.getText());
                resultFtoC.setText("Celsius: " + fahrenheitToCelsius(fahrenheit));
            } catch (NumberFormatException ex) {
                resultFtoC.setText("Invalid input!");
            }
        });

        // celsius to kelvin
        Label labelCtoK = new Label("Enter Celsius:");
        TextField inputCtoK = new TextField();
        Button btnCtoK = new Button("Celsius to Kelvin");
        Label resultCtoK = new Label();
        btnCtoK.setOnAction(e -> {
            try {
                double celsius = Double.parseDouble(inputCtoK.getText());
                resultCtoK.setText("Kelvin: " + celsiusToKelvin(celsius));
            } catch (NumberFormatException ex) {
                resultCtoK.setText("Invalid input!");
            }
        });

        // kelvin to celsius
        Label labelKtoC = new Label("Enter Kelvin:");
        TextField inputKtoC = new TextField();
        Button btnKtoC = new Button("Kelvin to Celsius");
        Label resultKtoC = new Label();
        btnKtoC.setOnAction(e -> {
            try {
                double kelvin = Double.parseDouble(inputKtoC.getText());
                resultKtoC.setText("Celsius: " + kelvinToCelsius(kelvin));
            } catch (NumberFormatException ex) {
                resultKtoC.setText("Invalid input!");
            }
        });

        VBox root = new VBox(10,
                labelCtoF, inputCtoF, btnCtoF, resultCtoF,
                labelFtoC, inputFtoC, btnFtoC, resultFtoC,
                labelCtoK, inputCtoK, btnCtoK, resultCtoK,
                labelKtoC, inputKtoC, btnKtoC, resultKtoC
        );

        Scene scene = new Scene(root, 300, 500);
        stage.setTitle("Temperature Converter");
        stage.setScene(scene);
        stage.show();
    }


    // Convert Fahrenheit to Celsius
    public double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    // Convert Celsius to Fahrenheit
    public double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    // Convert Kelvin to Celsius
    public double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    // Convert Celsius to Kelvin
    public double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    // Check if a Celsius temperature is extreme
    public boolean isExtremeTemperature(double celsius) {
        return celsius < -40 || celsius > 50;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
