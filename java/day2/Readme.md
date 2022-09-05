# Java - Day 2

## OOP in Java

### Elements of OOP

-   4 Major elements
    -   Abstraction
    -   Encapsulation
    -   Modularity
    -   Hierarchy
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
