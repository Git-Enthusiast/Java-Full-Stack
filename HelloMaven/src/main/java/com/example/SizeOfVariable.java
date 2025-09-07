package com.example;

public class SizeOfVariable {
    /*
     * 
     * Size of Variables in Java
     * 
     * byte: 1 byte (8 bits)
     * short: 2 bytes (16 bits)
     * int: 4 bytes (32 bits)
     * long: 8 bytes (64 bits)
     * float: 4 bytes (32 bits)
     * double: 8 bytes (64 bits)
     * char: 2 bytes (16 bits) - Unicode character
     * boolean: not precisely defined, typically 1 bit
     * 
     */

     public static void main(String[] args) {
        System.out.println("Size of byte: " + Byte.BYTES + " bytes");
        System.out.println("Size of short: " + Short.BYTES + " bytes");
        System.out.println("Size of int: " + Integer.BYTES + " bytes");
        System.out.println("Size of long: " + Long.BYTES + " bytes");
        System.out.println("Size of float: " + Float.BYTES + " bytes");
        System.out.println("Size of double: " + Double.BYTES + " bytes");
        System.out.println("Size of char: " + Character.BYTES + " bytes");
        // Note: Size of boolean is not defined in Java, typically considered as 1 bit

        // Minimum and Maximum values of each data type
        System.out.println("Range of byte: " + Byte.MIN_VALUE + " to " +    Byte.MAX_VALUE);
        System.out.println("Range of short: " + Short.MIN_VALUE + " to " + Short.MAX_VALUE);
        System.out.println("Range of int: " + Integer.MIN_VALUE + " to " + Integer.MAX_VALUE);
        System.out.println("Range of long: " + Long.MIN_VALUE + " to " + Long.MAX_VALUE);
        System.out.println("Range of float: " + Float.MIN_VALUE + " to " +  Float.MAX_VALUE);
        System.out.println("Range of double: " + Double.MIN_VALUE + " to " +Double.MAX_VALUE);
        System.out.println("Range of char: " + (int) Character.MIN_VALUE + " to " + (int) Character.MAX_VALUE);

        // Note: boolean does not have a range of values
        // It can only be true or false

        // Default values of each data type
        System.out.println("Default value of byte: " + 0);  // Default value is 0
        System.out.println("Default value of short: " + 0); // Default value is 0
        System.out.println("Default value of int: " + 0);   // Default value is 0
        System.out.println("Default value of long: " + 0L); // Default value is 0L
        System.out.println("Default value of float: " + 0.0f); // Default value is 0.0f
        System.out.println("Default value of double: " + 0.0d); // Default value is 0.0d
        System.out.println("Default value of char: " + '\u0000'); // Default value is '\u0000'
        System.out.println("Default value of boolean: " + false); // Default value is false
        
     }
    
}
