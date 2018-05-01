package com.thanglequoc.github.solid_java.l;

public abstract class Bird {
    private String name;
    private String location;
    private int flightDistance;
    private boolean flyable = true;
    
    public void setName(String name) {
	this.name = name;
    }
    
    public String getName() {
	return name;
    }
    
    public void setLocation(String location) {
	this.location = location;
    }
    
    public String getLocation() {
	return location;
    }
    
    public void setFlightDistance(int flightDistance) {
	this.flightDistance = flightDistance;
    }
    
    public int getFlightDistance() {
	return flightDistance;
    }
    
    public void setFlyable(boolean flyable) {
	this.flyable = flyable;
    }
    
    public boolean isFlyable() {
	return flyable;
    }
    
}
