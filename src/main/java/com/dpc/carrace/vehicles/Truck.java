package com.dpc.carrace.vehicles;

import com.dpc.carrace.Race;
import com.dpc.carrace.util.RandomHelper;

import static com.dpc.carrace.util.RandomHelper.randomizeNumberInRange;

public class Truck extends Vehicle {
    private static final int TURNS_NEEDED_TO_FIX_TRUCK = 2;
    private static final int NORMAL_SPEED = 100;
    private static final int BROKEN_DOWN_SPEED = 0;
    private static final int BREAK_DOWN_CHANCE = 5;
    private State state = State.OPERATIONAL;
    private int breakdownTurnsLeft;

    public Truck() {
        super(NORMAL_SPEED);
    }

    public boolean isBrokenDown() {
        return state != State.OPERATIONAL;
    }

    private State nextState() {
        switch (state) {
            case OPERATIONAL -> {
                if (RandomHelper.randomizeWithChance(BREAK_DOWN_CHANCE)) {
                    breakdownTurnsLeft = TURNS_NEEDED_TO_FIX_TRUCK;
                    return State.BROKEN_DOWN;
                }
            }
            case BROKEN_DOWN -> {
                if (breakdownTurnsLeft-- > 0) {
                    return State.BROKEN_DOWN;
                }
            }
        }
        return State.OPERATIONAL;
    }

    @Override
    public String setName() {
        return String.valueOf(randomizeNumberInRange(1001, 0));
    }

    @Override
    public void prepareForLap(Race race) {
        if (isBrokenDown()) actualSpeed = BROKEN_DOWN_SPEED;
        else actualSpeed = NORMAL_SPEED;

        state = nextState();
    }

    public enum State {
        OPERATIONAL,
        BROKEN_DOWN
    }
}
