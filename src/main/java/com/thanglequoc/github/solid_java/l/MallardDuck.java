package com.thanglequoc.github.solid_java.l;

public class MallardDuck extends Bird implements Flyable {

    @Override
    public void fly() {
	System.out.println("I can fly at small distance");
    }
    
}
