package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;

public abstract class Vehicle {
    String name;
    int normalSpeed;
    int actualSpeed;
    int distanceTravelled;


    protected Vehicle(int normalSpeed) {
        this.name = setName();
        this.normalSpeed = normalSpeed;
        this.distanceTravelled = 0;
    }

    public void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }

    public abstract String setName();

    public abstract void prepareForLap(Race race);

    public void setActualSpeed(int actualSpeed) {
        this.actualSpeed = actualSpeed;
    }

    @Override
    public String toString() {
        String sb = "{" +
                "distance travelled: " +
                distanceTravelled +
                ", " +
                "type: " +
                getClass().getSimpleName() +
                ", " +
                "name: " +
                name +
                "}";
        return sb;
    }
}
