package Part1;

import Interfaces.Flyable;

public class Birdman extends SuperHero implements Flyable {
    public Birdman() {
        super("Birdman");
    }

    @Override
    public void fly() {
        System.out.println("Birdman is flying close to the sun.");
    }
}
