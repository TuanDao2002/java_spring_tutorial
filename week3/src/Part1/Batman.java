package Part1;

public class Batman extends SuperHero {
    public Batman() {
        super("Batman");
    }

    @Override
    public void saveTheWorld() {
        System.out.println("Batman saves Gotham City again!");
    }
}
