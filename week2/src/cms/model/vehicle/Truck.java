package cms.model.vehicle;

public class Truck extends Vehicle{
    private int capacity;
    final static int RATE_PER_TON = 50;

    public Truck(String regNum, String make, String model, int year, double odometerReading, double serviceInterval, int capacity) {
        super(regNum, make, model, year, odometerReading, serviceInterval);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getFlatRate() {
        return RATE_PER_TON * getCapacity();
    }

    @Override
    public String toString() {
        return String.format("Truck: Reg_Number: %s, Make: %s, Model: %s, Year: %d, Capacity: %dt\n" +
                        "Service History: Odometer: %.2fkm, Last Service: %.2fkm, Service interval: %.2fkm",
                getRegNum(), getMake(), getModel(), getYear(), getCapacity(), getOdometerReading(), getLastServicePoint(), getServiceInterval());
    }
}
