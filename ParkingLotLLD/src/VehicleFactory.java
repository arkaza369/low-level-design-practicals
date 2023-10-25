import enums.VehicleType;

public class VehicleFactory {
    public Vehicle getVehicle(int vehicle_no, VehicleType vehicleType){
        if(vehicleType.equals(VehicleType.TWOWHEELER)){
            return new TwoWheeler(vehicle_no, vehicleType);
        }
        else if(vehicleType.equals(VehicleType.FOURWHEELER)){
            return new FourWheeler(vehicle_no, vehicleType);
        }
        else if(vehicleType.equals(VehicleType.LARGEVEHICLE)){
            return new LargeVehicle(vehicle_no, vehicleType);
        }
        else return null;
    }
}
