import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class FourWheelerSpotAssigner extends Handler{
    List<ParkingSpot> parkingSpotList;

    public FourWheelerSpotAssigner(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public ParkingSpot handleRequest(VehicleType v) {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.spotType.equals(SpotType.MEDIUM) && spot.isEmpty){
                return spot;
            }
        }
        return next.handleRequest(v);
    }
}
