package Part2;

import Interfaces.Flyable;

public class Eagle extends Bird implements Flyable {
    public Eagle() {
        super("eagle");
    }

    @Override
    public void fly() {
        System.out.println("The eagle is soaring");
    }
}
