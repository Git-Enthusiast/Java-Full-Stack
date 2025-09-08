package com.example;



/**
 * 🚀 MASTER MEMORY REVISION FILE
 * ===========================================
 * This file contains:
 *   - Code examples
 *   - Memory visualization (ASCII diagrams)
 *   - Explanations of Stack, Heap, Method Area, String Pool
 *   - GC behavior
 *   - Comparison Table (Stack vs Heap vs Method Area vs String Pool)
 * 
 * Use this file as your "all-in-one" revision for JVM Memory.
 */
public class MemoryMaster {

    // 🔹 Static variable (lives in Method Area, one copy shared by all objects)
    static String schoolName = "ABC Public School";

    // 🔹 Instance variables (each object in Heap has its own copy)
    int roll;
    double marks;

    // Constructor for instance variables
    public MemoryMaster(int roll, double marks) {
        this.roll = roll;
        this.marks = marks;
    }

    // Constructor for static variable
    public MemoryMaster(String school) {
        schoolName = school;
    }

    // Method to print details
    public void print() {
        System.out.println("School: " + schoolName + ", Roll: " + roll + ", Marks: " + marks);
    }

    // ============================================================
    // CASE 1: Static + Instance + Local
    // ============================================================
    public static void main(String[] args) {
        System.out.println("====== CASE 1: Static + Instance + Local ======");

        int localVar = 100; // Local variable → Stack

        MemoryMaster s1 = new MemoryMaster(1, 95.5); // Heap
        MemoryMaster s2 = new MemoryMaster(2, 88.0); // Heap

        System.out.println("Local Variable: " + localVar);
        s1.print();
        s2.print();

        String str1 = "Hello";          // String literal → String Pool
        String str2 = new String("Hi"); // Heap + Pool

        System.out.println("String literal str1: " + str1);
        System.out.println("new String str2: " + str2);

        // 🔹 Anonymous object → eligible for GC
        new MemoryMaster(3, 77.0);

        /**
         * 📌 Memory Layout:
         * -----------------------------------------------------
         * Method Area:
         *   schoolName -> "ABC Public School"
         *
         * Heap:
         *   Obj#1 { roll=1, marks=95.5 }
         *   Obj#2 { roll=2, marks=88.0 }
         *   Obj#3 { roll=3, marks=77.0 } (GC candidate)
         *   HeapObj("Hi")
         *
         * Stack:
         *   localVar=100
         *   s1 → Obj#1
         *   s2 → Obj#2
         *   str1 → "Hello"
         *   str2 → HeapObj("Hi")
         *
         * String Pool (special Heap area):
         *   "ABC Public School"
         *   "Hello"
         *   "Hi"
         * -----------------------------------------------------
         */
    }

    // ============================================================
    // CASE 2: No static, only instance + local
    // ============================================================
    public static void main2(String[] args) {
        System.out.println("\n====== CASE 2: Without static variable ======");

        int localVar = 200; // Stack

        MemoryMaster s1 = new MemoryMaster(10, 85.0);
        MemoryMaster s2 = new MemoryMaster(20, 90.0);

        String schoolNameLocal = "XYZ Public School"; // String Pool

        System.out.println("Local Variable: " + localVar);
        System.out.println("Manual schoolName: " + schoolNameLocal);
        s1.print();
        s2.print();

        String str1 = "World";           // Pool
        String str2 = new String("Bye"); // Heap + Pool

        System.out.println("String literal str1: " + str1);
        System.out.println("new String str2: " + str2);

        new MemoryMaster(30, 70.0); // GC candidate

        /**
         * 📌 Memory Layout:
         * -----------------------------------------------------
         * Method Area:
         *   [ ]  (no static data)
         *
         * Heap:
         *   Obj#1 { roll=10, marks=85.0 }
         *   Obj#2 { roll=20, marks=90.0 }
         *   Obj#3 { roll=30, marks=70.0 } (GC candidate)
         *   HeapObj("Bye")
         *
         * Stack:
         *   localVar=200
         *   s1 → Obj#1
         *   s2 → Obj#2
         *   schoolNameLocal → "XYZ Public School"
         *   str1 → "World"
         *   str2 → HeapObj("Bye")
         *
         * String Pool:
         *   "XYZ Public School"
         *   "World"
         *   "Bye"
         * -----------------------------------------------------
         */
    }

    // ============================================================
    // CASE 3: String reassignment
    // ============================================================
    public static void main3(String[] args) {
        System.out.println("\n====== CASE 3: String Reassign ======");

        String s = "Hello";   // Pool
        s = "Rajan";          // New Pool entry, "Hello" still exists

        System.out.println("Now s = " + s);

        /**
         * 📌 Memory Layout:
         * -----------------------------------------------------
         * Stack:
         *   s → "Rajan"
         *
         * String Pool:
         *   "Hello" (unused but not GC-ed)
         *   "Rajan"
         *
         * 🔑 String Pool is never garbage collected during runtime,
         * so "Hello" stays even if not used.
         * -----------------------------------------------------
         */
    }

    // ============================================================
    // CASE 4: Static updated via object
    // ============================================================
    public static void main4(String[] args) {
        System.out.println("\n====== CASE 4: Static update via object ======");

        int local = 50; // Stack
        System.out.println("Local variable: " + local);
        MemoryMaster obj = new MemoryMaster(101, 99.9); // Heap

        obj.print(); // prints old static value
        // Suppress unused variable warning
        @SuppressWarnings("unused")
        int unused = local;
        // Update static value
        MemoryMaster.schoolName = "DEF School";
        obj.print(); // prints updated value

        /**
         * 📌 Memory Layout:
         * -----------------------------------------------------
         * Stack:
         *   local = 50
         *   obj → Obj#1 { roll=101, marks=99.9 }
         *
         * Heap:
         *   Obj#1 { roll=101, marks=99.9 }
         *
         * Method Area:
         *   schoolName = "DEF School"
         *
         * String Pool:
         *   "ABC Public School"
         *   "DEF School"
         * -----------------------------------------------------
         */
    }
}

/**
 * ============================================================
 * 📝 COMPARISON TABLE
 * ============================================================
 * 
 * AREA          | Stores                          | Lifetime             | GC?
 * --------------|--------------------------------|----------------------|----------------
 * STACK         | Local variables, references    | Until method ends    | Auto cleared
 * HEAP          | Objects, instance variables    | Until no ref exists  | ✅ Yes
 * METHOD AREA   | Class metadata, static fields  | Until program ends   | ❌ No
 * STRING POOL   | String literals (unique copy)  | Until JVM stops      | ❌ No (mostly)
 * 
 * ============================================================
 * ✅ Local Variables → Exist in Stack, removed automatically.
 * ✅ Instance Variables → Exist per object, inside Heap.
 * ✅ Static Variables → Exist only once in Method Area.
 * ✅ String Literals → Interned in String Pool (not GC).
 * ✅ "new String(...)" → Creates Pool + Heap object.
 * ✅ Anonymous Objects → Heap but GC candidate.
 * 
 * ------------------------------------------------------------
 */

