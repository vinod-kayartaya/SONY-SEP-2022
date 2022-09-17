# Java Collections

![](./concepts.dio.png)

![](./multi-tiered-apps.dio.png)

---

### Assignment 1

Interface _Movable_ and its implementations _MovablePoint_ and _MovableCircle_

Write two concrete classes - MovablePoint and MovableCircle - that implement the Movable interface.

<img src="https://github.com/kayartaya-vinod/2021-MARCH-EPSILON-JAVA-SPRING/raw/master/Assignments/images/ExerciseOOP_Movable.png">

For the MovablePoint class, declare the instance variable x, y, xSpeed and ySpeed with package access as shown with '~' in the class diagram (i.e., classes in the same package can access these variables directly). For the MovableCircle class, use a MovablePoint to represent its center (which contains four variable x, y, xSpeed and ySpeed). In other words, the MovableCircle composes a MovablePoint, and its radius.

```java
public class MovablePoint implements Movable {
   // instance variables
   int x, y, xSpeed, ySpeed;     // package access

   // Constructor
   public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
      this.x = x;
      ......
   }
   ......

   // Implement abstract methods declared in the interface Movable
   @Override
   public void moveUp() {
      y -= ySpeed;   // y-axis pointing down for 2D graphics
   }
   ......
}
```

```java
public class MovableCircle implements Movable { // saved as "MovableCircle.java"
   // instance variables
   private MovablePoint center;   // can use center.x, center.y directly
                                  //  because they are package accessible
   private int radius;

   // Constructor
   public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
      // Call the MovablePoint's constructor to allocate the center instance.
      center = new MovablePoint(x, y, xSpeed, ySpeed);
      ......
   }
   ......

   // Implement abstract methods declared in the interface Movable
   @Override
   public void moveUp() {
      center.y -= center.ySpeed;
   }
   ......
}
```

Write a test program and try out these statements:

```java
Movable m1 = new MovablePoint(5, 6, 10, 15);     // upcast
System.out.println(m1);
m1.moveLeft();
System.out.println(m1);

Movable m2 = new MovableCircle(1, 2, 3, 4, 20);  // upcast
System.out.println(m2);
m2.moveRight();
System.out.println(m2);
```

Write a new class called _MovableRectangle_, which composes two _MovablePoint_ objects (representing the top-left and bottom-right corners) and implementing the _Movable_ Interface. Make sure that the two points has the same speed.

<img src="https://github.com/kayartaya-vinod/2021-MARCH-EPSILON-JAVA-SPRING/raw/master/Assignments/images/ExerciseOOP_MovableRectangle.png">

In the test program, add the following code to test the new implementation:

```java

Movable m3 = new MovableRectangle(1, 2, 3, 4, 25, 35);  // upcast
System.out.println(m3);
m3.moveUp();
System.out.println(m3);
```

---

### Assignment 2

Class: _com.kvinod.training.entity.Contact_

```java
public class Contact {

	private int id;
	private String firstname;
	private String lastname;
	private Gender gender = Gender.MALE;
	private String email;
	private String phone;
	private String address;
	private String city = "Bangalore";
	private String state = "Karnataka";
	private Integer pincode;
	private String country = "India";
	private Date birthDate;

	// constructor/s

	// getters and setters

   // toString

}
```

Interface _com.kvinod.training.dao.ContactsDao_

```java
public interface ContactsDao {
	// CRUD operations
	public void addContact(Contact contact) throws DaoException;
	public Contact getContact(int id) throws DaoException;
	public void updateContact(Contact contact) throws DaoException;
	public void deleteContact(int id) throws DaoException;

	// Queries
	public Contact getContactByEmail(String email) throws DaoException;
	public Contact getContactByPhone(String phone) throws DaoException;
	public List<Contact> getContactsByLastname(String lastname) throws DaoException;
	public List<Contact> getContactsByCity(String city) throws DaoException;
	public List<Contact> getContacts() throws DaoException;
	public List<Contact> getContactsByBirthDate(Date from, Date to) throws DaoException;
}
```

Create an implementation for the above interface that uses collections for storing/manipulating the data. Note that the data will be available only till the time application is running. So, initialize few contacts in the constructor.

## Create a menu driven application using Java to provide the following options:

1. Add new contact
2. List all contacts
3. Search by lastname
4. Search by email address
5. Search by phone number
6. Search by city
7. Search by date of birth range
8. Delete contact
9. Edit contact

---
