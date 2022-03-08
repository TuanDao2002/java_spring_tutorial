package cms.model;

import cms.model.vehicle.Vehicle;

public class Job {
    private int jobID;
    private double distance;
    private Vehicle vehicle;
    private double expense;
    private double profit;
    private final static int PROFIT_MARGIN = 50;

    public Job(int jobID, double distance, Vehicle vehicle) {
        this.jobID = jobID;
        this.distance = distance;
        this.vehicle = vehicle;
    }

    public int getJobID() {
        return jobID;
    }

    public double getDistance() {
        return distance;
    }

    public double getExpense() {
        return expense;
    }

    public double getProfit() {
        return profit;
    }

    public boolean isServiceable() {
        double odometerReading = vehicle.getOdometerReading();
        double lastServicePoint = vehicle.getLastServicePoint();
        double serviceInterval = vehicle.getServiceInterval();

        if (serviceInterval - odometerReading + lastServicePoint < distance) {
            return false;
        }

        vehicle.setOdometerReading(odometerReading + distance);
        this.expense = (vehicle.getFlatRate() * distance) / 100;
        this.profit = (this.expense * PROFIT_MARGIN) / 100;
        return true;
    }

    @Override
    public String toString() {
        double cost = getExpense() + getProfit();
        return String.format("ID: %d, Distance: %.2fkm, Cost: $%.2f, Expense: $%.2f, Profit: $%.2f",
                getJobID(), getDistance(), cost, getExpense(), getProfit());
    }
}
