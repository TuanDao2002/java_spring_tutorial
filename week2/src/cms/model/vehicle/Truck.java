package cms.model.vehicle;

public class Truck extends Vehicle{
    private int capacity;

    public Truck(String regNum, String make, String model, int year, double odometerReading, double serviceInterval, int capacity) {
        super(regNum, make, model, year, odometerReading, serviceInterval);
        this.capacity = capacity;
        super.setFlatRate(0.5);
    }

    public int getCapacity() {
        return capacity;
    }


    @Override
    public double getWearAndTears(double distance) {
        return super.getWearAndTears(distance) * capacity;
    }

    @Override
    public String toString() {
        return String.format("Truck: Reg_Number: %s, Make: %s, Model: %s, Year: %d, Capacity: %dt\n" +
                        "Service History: Odometer: %.2fkm, Last Service: %.2fkm, Service interval: %.2fkm",
                getRegNum(), getMake(), getModel(), getYear(), getCapacity(), getOdometerReading(), getLastServicePoint(), getServiceInterval());
    }
}
