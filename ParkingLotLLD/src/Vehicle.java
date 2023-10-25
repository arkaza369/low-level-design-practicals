import enums.VehicleType;

public abstract class Vehicle {
    int vehicle_no;
    VehicleType vehicleType;

    public Vehicle(int vehicle_no, VehicleType vehicleType) {
        this.vehicle_no = vehicle_no;
        this.vehicleType = vehicleType;
    }
}
