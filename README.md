# S.O.L.I.D In Java

## **L** : The Liskov Substitution Principle
The Liskov Substitution Principle (LSP) is a concept in Object Oriented Programming that states:

>Functions that use pointers or references to base classes must be able to use objects of derived classes without knowing it.

If _S_ is a subtype of _T_ , then object with type _T_ may be replaced with objects with type _S_  (e.g: an object with type T may be substituted with any object of subtype _S_) without altering any desirable properties of the program (correctness, task performed, etc..)
The **LSP** is a particular definition of subtyping relation, called **(strong) behavioral subtyping**.

Let's move to the real case study:  (reference from [this article][Tom Dalling - The Liskov Substitution principle])

Let's create a bird simulator program. A bird start with basic stuff: _name_, _location_ and _flight distance_, and a _fly_ behavior
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
It's time to create some birds for a test run:
```
@Test
public void testBirdRun() {
  Bird bird = new Eagle();
  bird.fly();

  bird = new MallardDuck();
  bird.fly();
}
```

>I'm flying high, across the mountain !
I can fly at small distance


And some new types of bird come: **Penguin** and **Ostrich**, the truth be told, **they can't fly** !

```
public class Penguin extends Bird {

    @Override
    public void fly() {
	//This bird is not suppose to fly !, it's weird to implement this method
    }

}
```
>If an override method **does nothing** or just **throws an exception**, then you're probably violating the LSP.

At first, the design isn't good. **Bird** class is making assumption that every bird can fly.

#### Solution 1: Create a flag in **Bird** to indicate if this bird can fly
```
public abstract class Bird {
    private String name;
    private String location;
    private int flightDistance;
    private boolean flyable = true;
}
```
We set it to _true_ as most of the bird can fly, and for the rest of flightless birds, this flag will be overridden

```
public class Penguin extends Bird {

    public Penguin() {
	super.setFlyable(false);
    }
}
```

When the client want a bird to _fly_, it has to check if the bird can fly to make sure that nothing goes wrong
```
@Test
public void testFlyableBirds() {
  Bird eagle = new Eagle();
  Bird mallardDuck = new MallardDuck();
  Bird penguin = new Penguin();
  List<Bird> birds = new ArrayList<>(Arrays.asList(eagle, mallardDuck, penguin));

  /*test fly */
  for (Bird bird : birds) {
    if (bird.isFlyable()) {
      bird.fly();
    }
  }

}
```

>This is really a band-aid solution. It hasn't fixed the underlying problem. It just provides a way to check whether the problem exists for a particular object.

#### Solution 2: Create interface _flyable_
We create an interface _Flyable_ , and only bird type which can fly will implement this interface. The _fly_ behavior of abstract class _Bird_ is removed since we finally find out not every bird can fly.
```
public interface Flyable {
    public void fly();
}
```

```
public class Eagle extends Bird implements Flyable {
    @Override
    public void fly() {
	System.out.println("I'm flying high, across the mountain !");
    }
}
```

Extracting the behavior out of the abstract class seem to be a good way. Later on, the bird simulator expands at bigger scale to be **Animal Simulator** program. **Bat** is added, it's not a bird but it can fly. The implementation is easy, we don't have to change anything.

```
public class Bat implements Flyable{
    @Override
    public void fly() {
	System.out.println("I often fly at night, like Batman");
    }
}
```

```
@Test
public void testFlyableAnimal_WithInterfaceImplementation() {
    Flyable eagle = new Eagle();
    Flyable mallardDuck = new MallardDuck();
    Flyable bat = new Bat();
    List<Flyable> flyableAnimals = new ArrayList<>(Arrays.asList(eagle, mallardDuck, bat));
    for (Flyable flyable : flyableAnimals) {
        flyable.fly();
    }
}
```
This approach consider a **_Flyable_** animal and a **Bird** type animal respectively.




[Tom Dalling - The Liskov Substitution principle]: https://www.tomdalling.com/blog/software-design/solid-class-design-the-liskov-substitution-principle/


