import enums.VehicleType;

import java.util.List;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpotList;
    Handler spotAssigner;

    public ParkingSpotManager(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }
    //chain of responsibility pattern for finding parking slot
    public void init(){
        Handler twoWheeleHhandler = new TwoWheelerSpotAssigner(parkingSpotList);
        Handler largeVehicleHhandler = new LargeVehicleAssigner(parkingSpotList);
        Handler fourWheeleHhandler = new FourWheelerSpotAssigner(parkingSpotList);
        twoWheeleHhandler.setNextHandler(fourWheeleHhandler);
        fourWheeleHhandler.setNextHandler(largeVehicleHhandler);
    }

    public ParkingSpot findParkingSpot(VehicleType vehicleType){
        init();
        ParkingSpot parkingSpot = spotAssigner.handleRequest(vehicleType);
        return parkingSpot;
    }
    public void addParkingSpot(ParkingSpot parkingSpot){
        parkingSpotList.add(parkingSpot);
    }
    public void removeParkingSpot(ParkingSpot parkingSpot){
        parkingSpotList.remove(parkingSpot);
    }
    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.parkVehicle(vehicle);

    }
    public void removeVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpot.removeVehicle(vehicle);
    }
}
