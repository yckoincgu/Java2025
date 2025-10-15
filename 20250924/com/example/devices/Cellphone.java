// Cellphone.java
package com.example.devices; // Declares that this class belongs to this package

public class Cellphone {
    private String model;

    public Cellphone(String model) {
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Device Model: " + model);
    }
}