import enums.SpotType;

public class LargeParkingSpot extends ParkingSpot{
    public LargeParkingSpot(int spot_id, Vehicle vehicle, Boolean isEmpty, SpotType spotType) {
        super(spot_id, vehicle, isEmpty, spotType);
    }
}
