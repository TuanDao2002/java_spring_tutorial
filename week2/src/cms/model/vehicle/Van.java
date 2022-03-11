package cms.model.vehicle;

public class Van extends Vehicle{

    public Van(String regNum, String make, String model, int year, double odometerReading, double serviceInterval) {
        super(regNum, make, model, year, odometerReading, serviceInterval);
        super.setFlatRate(0.6);
    }

    @Override
    public String toString() {
        return String.format("Van: Reg_Number: %s, Make: %s, Model: %s, Year: %d\n" +
                "Odometer: %.2fkm, Last Service: %.2fkm, Service interval: %.2fkm",
                getRegNum(), getMake(), getModel(), getYear(), getOdometerReading(), getLastServicePoint(), getServiceInterval());
    }
}
