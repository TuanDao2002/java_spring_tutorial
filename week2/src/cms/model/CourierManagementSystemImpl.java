package cms.model;

import cms.model.interfaces.CourierManagementSystem;
import cms.model.vehicle.Vehicle;

import java.util.ArrayList;

public class CourierManagementSystemImpl implements CourierManagementSystem {
    private ArrayList<Vehicle> vehicleList;
    private ArrayList<Job> scheduledJobList;
    private static int count = 0;
    public CourierManagementSystemImpl() {
        vehicleList = new ArrayList<>();
        scheduledJobList = new ArrayList<>();
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        if (vehicleList.contains(vehicle)) {
            return;
        }
        vehicleList.add(vehicle);
    }

    @Override
    public void displayVehicleInfo(String regNum) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getRegNum().equals(regNum)) {
                System.out.println(vehicle);
                return;
            }
        }

        System.out.println("No vehicle with the registration with ID: " + regNum);
    }

    @Override
    public void displayAllVehicles() {
        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle);
        }
    }

    @Override
    public void serviceVehicle(String regNum) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getRegNum().equals(regNum)) {
                vehicle.setLastServicePoint(vehicle.getOdometerReading());
                return;
            }
        }

        System.out.println("No vehicle with the registration with ID: " + regNum);
    }

    @Override
    public boolean scheduleJob(double distance, String regNum) {
        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getRegNum().equals(regNum)) {
                Job newJob = new Job(count, distance, regNum);
                count++;

                if (vehicle.getOdometerReading() + distance > vehicle.getLastServicePoint() + vehicle.getServiceInterval()) {
                    return false;
                } else {
                    scheduledJobList.add(newJob);
                    newJob.finalizeJobDetail(vehicle.getWearAndTears(distance));
                    vehicle.setOdometerReading(vehicle.getOdometerReading() + distance);
                    return true;
                }
            }
        }

        System.out.println("No vehicle with the registration with ID: " + regNum);
        return false;
    }

    @Override
    public void displayAllJobs() {
        for (Job job : scheduledJobList) {
            System.out.println(job);
        }
    }
}
