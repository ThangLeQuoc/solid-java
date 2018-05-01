package com.thanglequoc.github.solid_java.l;

public class Penguin extends Bird {

    public Penguin() {
	super.setFlyable(false);
    }
    @Override
    public void fly() {
	//This bird is not suppose to fly !, it's weird to implement this method
    }

}
