package DecoratorPattern;

interface Room {
    String decorate();
}

class RoomImpl implements Room {

    @Override
    public String decorate() {
        return "Room";
    }
}

public class RoomDecorator implements Room {
    private Room room;

    public RoomDecorator(Room room) {
        this.room = room;
    }

    @Override
    public String decorate() {
        return room.decorate();
    }
}


class TV extends RoomDecorator {

    public TV(Room room) {
        super(room);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithTV();
    }

    public String decorateWithTV() {
        return " with TV";
    }
}

class Sofa extends RoomDecorator {

    public Sofa(Room room) {
        super(room);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithSofa();
    }

    public String decorateWithSofa() {
        return " with sofa";
    }
}

class Chair extends RoomDecorator {

    public Chair(Room room) {
        super(room);
    }

    @Override
    public String decorate() {
        return super.decorate() + decorateWithChair();
    }

    public String decorateWithChair() {
        return " with chair";
    }
}
