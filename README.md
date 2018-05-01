# S.O.L.I.D In Java

## **L** : The Liskov Substitution Principle
The Liskov Substitution Principle (LSP) is a concept in Object Oriented Programming that states:

>Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.

If _S_ is a subtype of _T_ , then object with type _T_ may be replaced with objects with type _S_  (e.g: an object with type T may be substituted with any object of subtype _S_) without altering any desirable properties of the program (correctness, task performed, etc..)
The **LSP** is a particular definition of subtyping relation, called **(strong) behavioral subtyping**.

Let's move to the real case study:  (reference from [this article][Tom Dalling - The Liskov Substitution principle])

Let's create a bird simulator program. Bird start with basic stuff: _name_, _location_ and _flight distance_
```
public abstract class Bird {
    private String name;
    private String location;
    private int flightDistance;
    /* getters and setters */
    public abstract void fly();
}
```
Let's make some concrete bird subtype the **Bird** abstract class, **Eagle** and **MallardDuck**

```
public class Eagle extends Bird {
    @Override
    public void fly() {
	System.out.println("I'm flying high, across the mountain !");
    }
}

public class MallardDuck extends Bird
    @Override
    public void fly() {
	System.out.println("I can fly at small distance");
    }
}
```

And a new type of bird come, **Penguin** and **Ostrich**, and the truth be told, **they can't fly** !




[Tom Dalling - The Liskov Substitution principle]: https://www.tomdalling.com/blog/software-design/solid-class-design-the-liskov-substitution-principle/


