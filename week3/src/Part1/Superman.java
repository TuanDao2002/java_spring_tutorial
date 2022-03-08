package Part1;

import Interfaces.Flyable;

public class Superman extends SuperHero implements Flyable {
    public Superman() {
        super("Superman");
    }

    @Override
    public void saveTheWorld() {
        System.out.println("Superman saves the world and Lois Lane again!");
    }

    @Override
    public void fly() {
        System.out.println("Superman is flying to the fortress of solitude");
    }
}
