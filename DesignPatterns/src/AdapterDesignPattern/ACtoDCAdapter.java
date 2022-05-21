package AdapterDesignPattern;

interface ACBulb {
    void connectAC();
    void turnOn();
}

interface DCBulb {
    void connectDC();
    void turnOn();
}

class FluorescentBulb implements ACBulb {

    @Override
    public void connectAC() {
        System.out.println("Connected to AC electricity");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on the fluorescent bulb");
    }
}

class FilamentBulb implements DCBulb {

    @Override
    public void connectDC() {
        System.out.println("Connected to DC electricity");
    }

    @Override
    public void turnOn() {
        System.out.println("Turn on the filament bulb");
    }
}

class ACtoDCAdapter implements DCBulb {
    private final ACBulb acBulb;

    public ACtoDCAdapter(ACBulb acBulb) {
        this.acBulb = acBulb;
    }

    @Override
    public void connectDC() {
        System.out.println("Connected to DC electricity");
    }

    @Override
    public void turnOn() {
        acBulb.turnOn();
    }
}
