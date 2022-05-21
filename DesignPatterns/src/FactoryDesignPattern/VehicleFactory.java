package FactoryDesignPattern;

interface Vehicle {
    public void run();
}

class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("Bus is running!!!");
    }
}


class Car implements Vehicle {
    @Override
    public void run() {
        System.out.println("Car is running!!!");
    }
}

public class VehicleFactory {
    public Vehicle getVehicle(String vehicleType) {
        if (vehicleType == null) {
            return  null;
        }

        if (vehicleType.equalsIgnoreCase("Car")) {
            return new Car();
        }

        if (vehicleType.equalsIgnoreCase("Bus")) {
            return new Bus();
        }

        return  null;
    }
}
