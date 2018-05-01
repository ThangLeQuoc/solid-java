package com.thanglequoc.github.solid_java.l.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.thanglequoc.github.solid_java.l.Bat;
import com.thanglequoc.github.solid_java.l.Bird;
import com.thanglequoc.github.solid_java.l.Eagle;
import com.thanglequoc.github.solid_java.l.Flyable;
import com.thanglequoc.github.solid_java.l.MallardDuck;
import com.thanglequoc.github.solid_java.l.Penguin;

public class BirdRunnerTest {
    
    @Test
    public void testFlyableBirds() {
	Bird eagle = new Eagle();
	Bird mallardDuck = new MallardDuck();
	Bird penguin = new Penguin();
	List<Bird> birds = new ArrayList<>(Arrays.asList(eagle, mallardDuck, penguin));
	
	/*test fly */
	/*
	for (Bird bird : birds) {
	    if (bird.isFlyable()) {
		bird.fly();
	    }
	}
	*/
	
    }
    
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
}
