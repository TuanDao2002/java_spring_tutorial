package cms.model.vehicle;

public abstract class Vehicle {
    private String regNum;
    private int year;
    private String make;
    private String model;
    private double odometerReading;
    private double lastServicePoint;
    private double serviceInterval;

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

    public void setServiceInterval(double serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public abstract int getFlatRate();

    @Override
    public abstract String toString();

}
