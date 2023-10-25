import enums.VehicleType;
import pricing.Duration;
import pricing.FlatPricingStrategy;
import pricing.PricingStrategyContext;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        //create parking lot
        parkingLot.init();
        //create vehicle
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle vehicle = vehicleFactory.getVehicle(1, VehicleType.FOURWHEELER);
        //set duration
        Duration duration = new Duration(1,5);
        //set pricing strategy
        PricingStrategyContext pricingStrategyContext= new PricingStrategyContext();
        pricingStrategyContext.setPricingStrategy(new FlatPricingStrategy());
        //get ticket
        Ticket ticket = parkingLot.generateTicket(vehicle, duration, pricingStrategyContext);
        //park vehicle
        parkingLot.parkVehicle(vehicle, ticket.parkingSpot);

        //to remove vehicle
        parkingLot.removeVehicle(vehicle, ticket.parkingSpot);
    }
}