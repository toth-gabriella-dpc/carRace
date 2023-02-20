package com.dpc.carrace;

import com.dpc.carrace.vehicles.Car;
import com.dpc.carrace.vehicles.Motorcycle;
import com.dpc.carrace.vehicles.Truck;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CarRaceApplication {
    private static Race race;

    public static void main(String[] args) {
        race = new Race();
        SpringApplication.run(CarRaceApplication.class, args);
        createVehicles();
        race.simulateRace();
        race.printResults();
    }

    public static void createVehicles() {
        for (int i = 0; i < 10; i++) {
            race.registerRacer(new Car());
            race.registerRacer(new Truck());
            race.registerRacer(new Motorcycle());
        }
    }

}
