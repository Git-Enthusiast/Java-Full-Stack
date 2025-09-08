package com.example;
/*
=========================================================
      COMPLETE REVISION NOTES ON JAVA MEMORY MODEL
=========================================================

📌 Topics Covered:
1. Class, Objects, Static, Instance, Local Variables
2. String Pool vs Heap
3. Reference Variables (Stack vs Heap)
4. Method Area (Static variables storage)
5. Garbage Collection behavior
6. Memory Visualization

=========================================================
🔹 KEY CONCEPTS
=========================================================

1. Local variables → Stored in Stack (method frame)
   - Example: int x, String greeting inside main()

2. Instance variables → Stored in Heap (inside each object)
   - Example: name, roll, marks in Student class

3. Static variables → Stored in Method Area (Class-level memory)
   - Example: schoolName

4. String literals → Stored in String Pool (special part of Heap)
   - Example: "Hello", "ABC Public School"

5. new String("Hi") → Creates 2 objects
   - One in String Pool ("Hi")
   - One in Heap (new object wrapping "Hi")

6. Reference Variables → Lives in Stack, points to objects in Heap
   - Example: Student s1 = new Student(...)

=========================================================
🔹 MEMORY VISUALIZATION (JVM)
=========================================================

   Stack                Heap                  Method Area
-----------       -----------------       -----------------
 s1 --------->   Student Obj1 {          schoolName
                 name -> "Rajan"   --->  "ABC Public School"
                 roll=1
                 marks=88.5
               }

 s2 --------->   Student Obj2 {
                 name -> "Aman"
                 roll=2
                 marks=76.0
               }

 greeting --> "Hello" (String Pool)
 temp -----> Heap("Hi")

 String Pool (inside Heap):
   "ABC Public School"
   "Hello"
   "Hi"
   "Rajan"
   "Aman"

=========================================================
*/

class Student {
    // 🔹 Static variable → stored in Method Area (shared across objects)
    static String schoolName = "ABC Public School";

    // 🔹 Instance variables → each object has its own copy in Heap
    String name;   // default = null
    int roll;      // default = 0
    double marks;  // default = 0.0

    // 🔹 Constructor → initializes instance variables
    Student(String name, int roll, double marks) {
        this.name = name;
        this.roll = roll;
        this.marks = marks;
    }

    // 🔹 Method → uses local variable (stack)
    void printDetails() {
        // Local variable (stack)
        String details = "School: " + schoolName +
                         ", Name: " + name +
                         ", Roll: " + roll +
                         ", Marks: " + marks;

        System.out.println(details);

        // After method ends, "details" is removed from stack
    }
}

public class VariablesTypes {
    public static void main(String[] args) {
        // 🔹 Local variable in Stack, points to String literal in String Pool
        @SuppressWarnings("unused")
        String greeting = "Hello";          

        // 🔹 Creates 2 objects → one in Pool, one in Heap
        @SuppressWarnings("unused")
        String temp = new String("Hi");     

        // 🔹 Object creation → stored in Heap
        Student s1 = new Student("Rajan", 1, 88.5);
        Student s2 = new Student("Aman", 2, 76.0);

        // Print details (method call creates local variable "details" in Stack)
        s1.printDetails();
        s2.printDetails();
    }
}

/*
=========================================================
🔹 STEP-BY-STEP EXECUTION
=========================================================

1. Class loading:
   - Method Area stores:
     * Class info
     * Static variable schoolName = "ABC Public School"
   - String literal "ABC Public School" goes to String Pool.

2. main() starts:
   - greeting → "Hello" (String Pool)
   - temp → new String("Hi") (Heap) and also "Hi" (String Pool)

3. s1 = new Student("Rajan", 1, 88.5)
   - Heap allocates Student Object 1
   - name → "Rajan" (String Pool)
   - roll = 1
   - marks = 88.5

4. s2 = new Student("Aman", 2, 76.0)
   - Heap allocates Student Object 2
   - name → "Aman" (String Pool)
   - roll = 2
   - marks = 76.0

5. Method call s1.printDetails()
   - Creates local var "details" in Stack
   - Prints → "School: ABC Public School, Name: Rajan, Roll: 1, Marks: 88.5"

6. Method call s2.printDetails()
   - Creates local var "details" in Stack
   - Prints → "School: ABC Public School, Name: Aman, Roll: 2, Marks: 76.0"

=========================================================
🔹 GC (Garbage Collection) NOTES
=========================================================

- Objects in Heap are eligible for GC when no reference variable points to them.
- Static variables are in Method Area → not collected by GC until program ends.
- String literals in Pool are not garbage collected normally (until JVM exits).
- new String("x") creates an extra object in Heap → eligible for GC if no reference.

=========================================================
🔹 FINAL MEMORY LAYOUT
=========================================================

Stack:
  greeting ──► "Hello" (String Pool)
  temp ──────► Heap("Hi")
  s1 ────────► Heap(Student Obj1)
  s2 ────────► Heap(Student Obj2)

Heap:
  Object1 (new String) = "Hi"
  Student Obj1: name→"Rajan", roll=1, marks=88.5
  Student Obj2: name→"Aman", roll=2, marks=76.0

Method Area:
  schoolName ──► "ABC Public School" (in String Pool)

String Pool (inside Heap):
  "ABC Public School"
  "Hello"
  "Hi"
  "Rajan"
  "Aman"

=========================================================
*/
