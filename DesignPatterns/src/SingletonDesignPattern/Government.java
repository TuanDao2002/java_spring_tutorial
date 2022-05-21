package SingletonDesignPattern;

public class Government {
    private final static Government instance = new Government();

    private Government(){}

    public static Government getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return "Only 1 government!!!";
    }
}
