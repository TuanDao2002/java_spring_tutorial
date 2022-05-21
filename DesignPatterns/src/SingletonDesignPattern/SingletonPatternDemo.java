package SingletonDesignPattern;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        Government government = Government.getInstance();
        System.out.println(government.toString());
    }
}
