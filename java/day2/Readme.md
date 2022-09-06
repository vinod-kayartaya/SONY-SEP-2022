# Java - Day 2

## OOP in Java

### Elements of OOP

-   4 Major elements
    -   Abstraction
    -   Encapsulation
    -   Modularity
    -   Hierarchy (arrangement of classes such that they are reusable)
        -   Aggregation / composition (HAS-A) - Whole/Part relationship
        -   Inheritance (IS-A) - Parent/Child or Super/Sub or Base/Derived or Generic/Specific
        -   Association (USES-A)
-   3 Minor elements
    -   Persistence
    -   Concurrency
    -   Typing

```java

class Employee {
    private int id;
    private String name;
    private double salary;

    public void setId(int id){
        if(id<0){
            throw new InvalidIdException("ID cannot be negative");
        }
        this.id = id;
    }
    public int getId(){
        return this.id;
    }
}

Employee e1 = new Employee();
e1.setId(123);

```

---

### Assignment 1

Create classes `Circle` and `Cylinder` as shown in the _UML_ diagram below:

<img src="https://github.com/kayartaya-vinod/2019_07_SAPIENT_BOOTCAMP/raw/master/JavaWorkspace/Assignments/images/ExerciseOOP_CircleCylinder.png">

In the `main()` function of a Program class, create an array of `Circle` references with the initialization shown below:

```java
Circle[] circles = {
	new Cylinder(12.34),
	new Cylinder(12.34, 10.0),
	new Cylinder(12.34, 10.0, "blue")
};

```

Print the area of the circular region of each cylinder along with the volume of the same.

---

### Assignment 2

Create the classes `Person`, `Student`, and `Staff` as shown in the _UML_ diagram below:

<img src="https://github.com/kayartaya-vinod/2019_07_SAPIENT_BOOTCAMP/raw/master/JavaWorkspace/Assignments/images/ExerciseOOP_PersonAndSubclasses.png">

In the `main()` function of a Program class, create an array of `Person` references with the initialization shown below:

```java
Person[] people = {
	new Student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
	new Staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0),
	new Staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0),
	new Student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
	new Student("Kiran", "Vasco, Goa", "Reactjs", 2017, 12500.0)
};

```

Print the details of all `Person` objects (using the `toString()`).

---

### Assignment 3

Create the classes `Shape`, `Circle`, `Rectangle`, and `Square` as shown in the _UML_ diagram below:

<img src="https://github.com/kayartaya-vinod/2019_07_SAPIENT_BOOTCAMP/raw/master/JavaWorkspace/Assignments/images/ExerciseOOP_ShapeAndSubclasses.png">

The `toString` function of the above classes should return text as given below:

| Classname | Sample return value from toString()                                                                                                          |
| --------- | -------------------------------------------------------------------------------------------------------------------------------------------- |
| Shape     | A Shape with color of xxx and filled/Not filled                                                                                              |
| Circle    | A Circle with radius=xxx, which is a subclass of yyy (where yyy is the output of the toString() method from the superclass)                  |
| Rectangle | A Rectangle with width=xxx and length=zzz, which is a subclass of yyy (where yyy is the output of the toString() method from the superclass) |
| Square    | A Square with side=xxx, which is a subclass of yyy (where yyy is the output of the toString() method from the superclass)                    |

In the `main()` method of a Program class, create an array of 10 `Shape` references containing a mixture of `Circle`, `Rectangle` and `Square` objects of different dimensions. Using a loop, print the `perimeter` and `area` for all of them.
