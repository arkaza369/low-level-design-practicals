import enums.VehicleType;

public abstract class Handler {
    Handler next;
    public void setNextHandler(Handler h){
        next=h;
    }
    public abstract ParkingSpot handleRequest(VehicleType vehicleType);
}
