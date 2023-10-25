import enums.SpotType;

public class SmallParkingSpot extends ParkingSpot{
    public SmallParkingSpot(int spot_id, Vehicle vehicle, Boolean isEmpty, SpotType spotType) {
        super(spot_id, vehicle, isEmpty, spotType);
    }
}
