import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class LargeVehicleAssigner extends Handler{
    List<ParkingSpot> parkingSpotList;

    public LargeVehicleAssigner(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public ParkingSpot handleRequest(VehicleType vehicleType) {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.spotType.equals(SpotType.LARGE) && spot.isEmpty){
                return spot;
            }
        }
        return next.handleRequest(vehicleType);
    }
}
