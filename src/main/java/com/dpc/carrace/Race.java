package com.dpc.carrace;

import com.dpc.carrace.vehicles.Truck;
import com.dpc.carrace.vehicles.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Race {
    private static final List<Vehicle> vehicles = new LinkedList<>();

    public Race() {
        simulateRace();
    }

    public boolean isYellowFlagActive() {
        return
                vehicles.stream()
                        .filter(vehicle -> vehicle instanceof Truck)
                        .map(truck -> ((Truck) truck).isBrokenDown()).isParallel();
    }

    public void registerRacer(Vehicle racer) {
        vehicles.add(racer);
    }

    public void simulateRace() {
        int LENGTH_OF_RACE = 50;
        for (int i = 0; i < LENGTH_OF_RACE; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }
            Weather.isRaining();
        }
    }

    public void printResults() {
        System.out.println("Race results: \n");
        vehicles.forEach(System.out::println);
    }

    public boolean isRaining() {
        return Weather.isRaining();
    }
}
