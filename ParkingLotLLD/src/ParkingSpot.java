import enums.SpotType;

public abstract class ParkingSpot {
    int spot_id;
    Vehicle vehicle;
    Boolean isEmpty;
    SpotType spotType;

    public ParkingSpot(int spot_id, Vehicle vehicle, Boolean isEmpty, SpotType spotType) {
        this.spot_id = spot_id;
        this.vehicle = vehicle;
        this.isEmpty = isEmpty;
        this.spotType = spotType;
    }

    public void parkVehicle(Vehicle v){
        this.vehicle = v;
        this.isEmpty = false;
    }
    public void removeVehicle(Vehicle v){
        v = null;
        this.vehicle = v;
        this.isEmpty = true;
    }

}
