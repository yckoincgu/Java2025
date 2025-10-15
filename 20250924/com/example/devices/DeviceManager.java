package com.example.devices;

public class DeviceManager {

    public static void main(String[] args) {
        System.out.println("--- Using the 'com.example.devices' Package ---");
        
        // Use the Cellphone class, which is now accessible via the import statement
        Cellphone phone = new Cellphone("iPhone 15 Pro");
        
        phone.displayInfo();
    }
}