package com.sony.programs;

//NOTE: it is highly recomendded that we create one class per source file.
//This is only for the sake of simplicity, so that we can refer to all the classes in the same file.

// abstract class is an incomplete class, which should not be used for creating objects
abstract class Animal {
	// abstract methods do not have method body; 
	// abstract methods must be in an abstract class
	public abstract void whoAmI();
}

// Cat IS-A Animal
class Cat extends Animal {
	// overriding hides the visibility of the inherited function, so JRE cannot
	// invoke the inherited method
	@Override
	public void whoAmI() {
		System.out.println("I am a Cat");
	}

	public void talk() {
		System.out.println("Meow...");
	}
}

// Dog IS-A Animal
class Dog extends Animal {
	@Override
	public void whoAmI() {
		System.out.println("I am a Dog!");
	}

	public void talk() {
		System.out.println("Bow bow...");
	}
}

// Lion IS-A Animal
class Lion extends Animal {

	@Override
	public void whoAmI() {
		System.out.println("I am a Lion");
	}
	
	@Override // instruction to the compiler to verify this function exists in the class hierarchy
	public String toString() {
		return "This is a lion object";
	}

}

public class InheritanceAndPolymorphism {

	public static void main(String[] args) {

		Animal a1; // reference to an "Animal" object
		// a1 = new Animal(); // abstract classes cannot be used for creating objects

		a1 = new Cat(); // Cat object is also an object of "Animal"
		// RHS is an objet of "Cat", as well as an object of "Animal"
		a1.whoAmI();
		// At this point in time "a1" refers to an object of "Cat", which is also an
		// object of "Animal"
		// "a1" is a reference of type "Animal". The compiler checks if "a1" can invoke
		// "whoAmI()" by checkig
		// its presence in "Animal". But, at the runtime, a1 refers to an object of
		// "Cat" class, which now has
		// 2 whoAmI() methods (one defined in the Cat class, and another one is
		// inherited from Animal class).
		// JRE always invokes the overridden function
		((Cat) a1).talk(); // downcasting; must be explicit

		a1 = new Dog(); // upcasting; implicitly done
		a1.whoAmI();

		// At this point in time, a1 refers to an object of Dog class at the runtime.
		// Can we call a1.talk() ????
		// Answer - NO!
		// Compiler checks if "talk()" method is present in the datatype of "a1" -
		// Animal
		if (a1 instanceof Dog) {
			Dog d1 = (Dog) a1;
			d1.talk();
		}

		a1 = new Lion();
		a1.whoAmI();
		if (a1 instanceof Dog d1) { // jdk 16+
			d1.talk();
		}
		
		System.out.println("a1 is " + a1);
	}
}
