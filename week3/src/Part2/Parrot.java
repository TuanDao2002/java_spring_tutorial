package Part2;

import Interfaces.Flyable;

public class Parrot extends Bird implements Flyable {
    public Parrot() {
        super("parrot");
    }

    @Override
    public void fly() {
        System.out.println("The parrot is flying in all its glorified colour"  );
    }
}
