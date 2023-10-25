import enums.SpotType;
import enums.VehicleType;

import java.util.List;

public class TwoWheelerSpotAssigner extends Handler{
    List<ParkingSpot> parkingSpotList;

    public TwoWheelerSpotAssigner(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    @Override
    public ParkingSpot handleRequest(VehicleType v) {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.spotType.equals(SpotType.SMALL) && spot.isEmpty){
                return spot;
            }
        }
        return next.handleRequest(v);
    }
}
