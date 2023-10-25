import enums.SpotType;

public class MediumParkingSpot extends ParkingSpot{
    public MediumParkingSpot(int spot_id, Vehicle vehicle, Boolean isEmpty, SpotType spotType) {
        super(spot_id, vehicle, isEmpty, spotType);
    }
}
