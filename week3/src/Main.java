import Interfaces.Flyable;
import Part1.*;
import Part2.Eagle;
import Part2.Parrot;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<SuperHero> superHeroes = new ArrayList<>();
        Aquaman aquaman = new Aquaman();
        Batman batman = new Batman();
        WonderWoman wonderWoman = new WonderWoman();
        Superman superman = new Superman();
        Birdman birdman = new Birdman();

        superHeroes.add(aquaman);
        superHeroes.add(batman);
        superHeroes.add(wonderWoman);
        superHeroes.add(superman);
        superHeroes.add(birdman);

        for (SuperHero superHero : superHeroes) {
            superHero.saveTheWorld();
        }

        for (SuperHero superHero : superHeroes) {
            if (superHero instanceof Flyable) {
                ((Flyable) superHero).fly();
            }
        }
        System.out.println();

        ArrayList<Flyable> flyables = new ArrayList<>();

        Eagle eagle = new Eagle();
        Parrot parrot = new Parrot();

        flyables.add(eagle);
        flyables.add(parrot);
        flyables.add(superman);
        flyables.add(birdman);

        for (Flyable flyable : flyables) {
            flyable.fly();
        }
    }
}
