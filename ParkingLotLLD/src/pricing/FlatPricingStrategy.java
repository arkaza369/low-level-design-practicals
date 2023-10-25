package pricing;

import enums.VehicleType;

import java.util.Map;

public class FlatPricingStrategy implements PricingStrategy{
        Map<VehicleType, Double> dailyrate;
    Map<VehicleType, Double> hourlyrate;
    public void init(){
        hourlyrate.put(VehicleType.TWOWHEELER, 20.0);
        hourlyrate.put(VehicleType.FOURWHEELER, 40.0);
        hourlyrate.put(VehicleType.LARGEVEHICLE, 100.0);

        dailyrate.put(VehicleType.TWOWHEELER, 500.0);
        dailyrate.put(VehicleType.FOURWHEELER, 1000.0);
        dailyrate.put(VehicleType.LARGEVEHICLE, 1500.0);
    }

    @Override
    public double calculatePrice(VehicleType vehicleType, Duration duration) {
        init();
        return dailyrate.get(vehicleType)*duration.days + hourlyrate.get(vehicleType)*duration.hrs;
    }

}
