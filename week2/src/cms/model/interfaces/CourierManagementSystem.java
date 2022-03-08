package cms.model.interfaces;

import cms.model.vehicle.Vehicle;

public interface CourierManagementSystem {
    void addVehicle(Vehicle vehicle);
    void displayVehicleInfo(String regNum);
    void displayAllVehicles();
    void serviceVehicle(String regNum);
    boolean scheduleJob(double distance, String regNum);
    void displayAllJobs();
}
