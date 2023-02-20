package com.dpc.carrace;

import com.dpc.carrace.vehicles.Truck;
import com.dpc.carrace.vehicles.Vehicle;

import java.util.LinkedList;
import java.util.List;

public class Race {
    private static final List<Vehicle> vehicles = new LinkedList<>();
    private boolean brokenTruck;

    public Race() {
        simulateRace();
    }

    private boolean getBrokenTruckStatus() {
        return
                vehicles.stream()
                        .filter(vehicle -> vehicle instanceof Truck)
                        .map(truck -> ((Truck) truck))
                        .anyMatch(Truck::isBrokenDown);
    }

    public boolean isYellowFlagActive() {
        return brokenTruck;
    }

    public void registerRacer(Vehicle racer) {
        vehicles.add(racer);
    }

    public void simulateRace() {
        int NUM_OF_LAPS = 50;
        for (int i = 0; i < NUM_OF_LAPS; i++) {
            for (Vehicle vehicle : vehicles) {
                vehicle.prepareForLap(this);
                vehicle.moveForAnHour();
            }
            Weather.randomize();
            brokenTruck = getBrokenTruckStatus();
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
