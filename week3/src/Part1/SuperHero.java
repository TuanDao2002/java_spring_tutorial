package Part1;

public abstract class SuperHero {
    private String name;
    public SuperHero(String name) {
        this.name = name;
    }

    public void saveTheWorld() {
        System.out.println(name + " saves the world again!");
    }
}

