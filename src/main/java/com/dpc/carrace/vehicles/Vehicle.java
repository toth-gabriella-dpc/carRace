package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;

import java.util.Random;

public abstract class Vehicle {
    Random random = new Random();
    String name;
    int normalSpeed;
    int actualSpeed;
    int distanceTravelled;


    protected Vehicle() {
        this.name = setName();
        this.normalSpeed = setNormalSpeed();
        this.distanceTravelled = 0;
    }

    public void moveForAnHour() {
        distanceTravelled += actualSpeed;
    }

    public abstract String setName();

    public abstract int setNormalSpeed();

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
