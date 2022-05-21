package AdapterDesignPattern;

public class AdapterPatternDemo {
    static void turnOnACBulb(ACBulb acBulb) {
        acBulb.connectAC();
        acBulb.turnOn();
    }

    static void turnOnDCBulb(DCBulb dcBulb) {
        dcBulb.connectDC();
        dcBulb.turnOn();
    }

    public static void main(String[] args) {
        FluorescentBulb fluorescentBulb = new FluorescentBulb();
        FilamentBulb filamentBulb = new FilamentBulb();

        System.out.println("Turn on fluorescent bulb with AC electricity");
        turnOnACBulb(fluorescentBulb);

        System.out.println("Turn on filament bulb with DC electricity");
        turnOnDCBulb(filamentBulb);

        System.out.println("Turn on fluorescent bulb with DC electricity");
        turnOnDCBulb(new ACtoDCAdapter(fluorescentBulb));
    }
}
