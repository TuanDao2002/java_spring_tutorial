package DecoratorPattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Room room1 = new Chair(new RoomImpl());
        System.out.println(room1.decorate());

        Room room2 = new TV(new Chair(new Sofa(new RoomImpl())));
        System.out.println(room2.decorate());
    }
}
