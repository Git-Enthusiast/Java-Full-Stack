package com.example;

public class TypeCasting {
    /*
     * 
     * TypeCasting in Java
     * 
     * Widening Conversion (Implicit) – small → large (int → double).
     * 
     * Narrowing Conversion (Explicit) – large → small (double → int).
     * 
     * Byte ↔ Int Conversion.
     * 
     * Char ↔ Int Conversion (ASCII values).
     * 
     * Boolean (no casting allowed).
     * 
     * String → Primitive (parseInt, parseDouble).
     * 
     * Primitive → String (String.valueOf, toString).
     * 
     * Upcasting (Subclass → Superclass).
     * 
     * Downcasting (Superclass → Subclass).
     */

    public static void main(String[] args) {
        // Widening Conversion (Implicit TypeCasting)
        int intValue = 42;
        double doubleValue = intValue; // Implicitly converts int to double
        System.out.println("Widening Conversion: " + doubleValue);

        // Narrowing Conversion (Explicit TypeCasting)
        double anotherDoubleValue = 42.99;
        int anotherIntValue = (int) anotherDoubleValue; // Explicitly converts double to int
        System.out.println("Narrowing Conversion: " + anotherIntValue);

        // Byte ↔ Int Conversion
        byte byteValue = 10;
        int intFromByte = byteValue; // Implicitly converts byte to int
        byte byteFromInt = (byte) intFromByte; // Explicitly converts int to byte
        System.out.println("Byte to Int: " + intFromByte + ", Int to Byte: " + byteFromInt);

        // Char ↔ Int Conversion
        char charValue = 'A';
        int intFromChar = charValue; // Implicitly converts char to int (ASCII value)
        char charFromInt = (char) intFromChar; // Explicitly converts int to char
        System.out.println("Char to Int: " + intFromChar + ", Int to Char: " + charFromInt);

        // String → Primitive
        String strNumber = "123";
        int parsedInt = Integer.parseInt(strNumber); // Converts String to int
        System.out.println("String to Primitive (int): " + parsedInt);

        // Primitive → String
        int number = 456;
        String strFromInt = String.valueOf(number); // Converts int to String
        System.out.println("Primitive to String: " + strFromInt);

        // Upcasting and Downcasting with Classes
        class Animal {
            void sound() {
                System.out.println("Animal sound");
            }
        }
        class Dog extends Animal {
            void sound() {
                System.out.println("Dog barks");
            }

            void fetch() {
                System.out.println("Dog fetches");
            }
        }
        // Upcasting
        Animal myDog = new Dog(); // Implicitly upcasts Dog to Animal
        myDog.sound(); // Calls Dog's sound method
        // Downcasting
        if (myDog instanceof Dog) {
            Dog specificDog = (Dog) myDog; // Explicitly downcasts Animal to Dog
            specificDog.fetch(); // Calls Dog's fetch method
        }

    }
}
