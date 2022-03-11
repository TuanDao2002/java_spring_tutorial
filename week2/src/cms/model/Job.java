package cms.model;
public class Job {
    private int jobID;
    private double distance;
    private String registrationID;
    private double wearAndTearExpense;
    private double profit;
    private double cost;

    public Job(int jobID, double distance, String registrationID) {
        this.jobID = jobID;
        this.distance = distance;
        this.registrationID = registrationID;
    }

    public int getJobID() {
        return jobID;
    }

    public double getDistance() {
        return distance;
    }

    public double getExpense() {
        return wearAndTearExpense;
    }

    public double getProfit() {
        return profit;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void finalizeJobDetail(double wearAndTearExpense) {
        this.wearAndTearExpense = wearAndTearExpense;
        this.setCost(this.wearAndTearExpense * 1.5);
        this.profit = this.cost - this.wearAndTearExpense;
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Distance: %.2fkm, Cost: $%.2f, Expense: $%.2f, Profit: $%.2f",
                getJobID(), getDistance(), cost, getExpense(), getProfit());
    }
}
