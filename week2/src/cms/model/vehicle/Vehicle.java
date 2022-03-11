package cms.model.vehicle;

public abstract class Vehicle {
    private String regNum;
    private int year;
    private String make;
    private String model;
    private double odometerReading;
    private double lastServicePoint;
    private double serviceInterval;
    private double flatRate;

    public Vehicle(String regNum, String make, String model, int year, double odometerReading, double serviceInterval) {
        this.regNum = regNum;
        this.year = year;
        this.make = make;
        this.model = model;
        this.odometerReading = odometerReading;
        this.serviceInterval = serviceInterval;

        this.lastServicePoint = 0;
    }

    public String getRegNum() {
        return regNum;
    }

    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public double getOdometerReading() {
        return odometerReading;
    }

    public double getLastServicePoint() {
        return lastServicePoint;
    }

    public double getServiceInterval() {
        return serviceInterval;
    }

    public void setOdometerReading(double odometerReading) {
        this.odometerReading = odometerReading;
    }

    public void setLastServicePoint(double lastServicePoint) {
        this.lastServicePoint = lastServicePoint;
    }

    public void setFlatRate(double flatRate) {
        this.flatRate = flatRate;
    }

    public double getFlatRate() {
        return flatRate;
    }

    public double getWearAndTears(double distance) {
        return flatRate * distance;
    }

    @Override
    public abstract String toString();

}
