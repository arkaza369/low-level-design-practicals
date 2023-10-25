import enums.SpotType;
import pricing.Duration;
import pricing.PricingStrategyContext;

import java.util.List;

public class ParkingLot {
    //initially keeping vehicle is null because spot is vacant.
    List<ParkingSpot>parkingSpotList;
    ParkingSpotManager parkingSpotManager;

    ParkingSpot smallParkingSpot1 = new SmallParkingSpot(1,null,true, SpotType.SMALL);
    ParkingSpot smallParkingSpot2 = new SmallParkingSpot(2,null,true, SpotType.SMALL);
    ParkingSpot smallParkingSpot3 = new SmallParkingSpot(3,null,true, SpotType.SMALL);
    ParkingSpot smallParkingSpot4 = new SmallParkingSpot(4,null,true, SpotType.SMALL);
    ParkingSpot smallParkingSpot5 = new SmallParkingSpot(5,null,true, SpotType.SMALL);
    ParkingSpot mediumParkingSpot1 = new MediumParkingSpot(1,null,true, SpotType.MEDIUM);
    ParkingSpot mediumParkingSpot2 = new MediumParkingSpot(2,null,true, SpotType.MEDIUM);
    ParkingSpot mediumParkingSpot3 = new MediumParkingSpot(3,null,true, SpotType.MEDIUM);
    ParkingSpot mediumParkingSpot4 = new MediumParkingSpot(4,null,true, SpotType.MEDIUM);
    ParkingSpot mediumParkingSpot5 = new MediumParkingSpot(5,null,true, SpotType.MEDIUM);

    ParkingSpot largeParkingSpot1 = new LargeParkingSpot(1,null,true, SpotType.LARGE);
    ParkingSpot largeParkingSpot2 = new LargeParkingSpot(2,null,true, SpotType.LARGE);
    ParkingSpot largeParkingSpot3 = new LargeParkingSpot(3,null,true, SpotType.LARGE);
    ParkingSpot largeParkingSpot4 = new LargeParkingSpot(4,null,true, SpotType.LARGE);
    ParkingSpot largeParkingSpot5 = new LargeParkingSpot(5,null,true, SpotType.LARGE);

    public void init(){
        parkingSpotList.add(smallParkingSpot1);
        parkingSpotList.add(smallParkingSpot2);
        parkingSpotList.add(smallParkingSpot3);
        parkingSpotList.add(smallParkingSpot4);
        parkingSpotList.add(smallParkingSpot5);

        parkingSpotList.add(mediumParkingSpot1);
        parkingSpotList.add(mediumParkingSpot1);
        parkingSpotList.add(mediumParkingSpot1);
        parkingSpotList.add(mediumParkingSpot1);
        parkingSpotList.add(mediumParkingSpot1);

        parkingSpotList.add(largeParkingSpot1);
        parkingSpotList.add(largeParkingSpot1);
        parkingSpotList.add(largeParkingSpot1);
        parkingSpotList.add(largeParkingSpot1);
        parkingSpotList.add(largeParkingSpot1);

        parkingSpotManager = new ParkingSpotManager(parkingSpotList);

    }
    public Ticket generateTicket(Vehicle vehicle, Duration duration, PricingStrategyContext pricingStrategyContext){
        Ticket ticket = new Ticket();
        //find parking spot
        ParkingSpot parkingSpot = parkingSpotManager.findParkingSpot(vehicle.vehicleType);
        double price = pricingStrategyContext.calculatePrice(vehicle.vehicleType, duration);
        ticket.parkingSpot = parkingSpot;
        ticket.vehicle = vehicle;
        ticket.price = price;
        return ticket;

    }
    public void parkVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpotManager.parkVehicle(vehicle, parkingSpot);
    }
    public void removeVehicle(Vehicle vehicle, ParkingSpot parkingSpot){
        parkingSpotManager.removeVehicle(vehicle, parkingSpot);
    }
}
