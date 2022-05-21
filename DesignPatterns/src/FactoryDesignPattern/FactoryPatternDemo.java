package FactoryDesignPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle vehicle1 = vehicleFactory.getVehicle("car");
        Vehicle vehicle2 = vehicleFactory.getVehicle("bus");

        vehicle1.run();
        vehicle2.run();
    }
}
