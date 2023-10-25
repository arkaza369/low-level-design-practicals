package price;

import enums.VehicleType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SlabwisePricingStrategy implements PricingStrategy{
    Map<VehicleType, List<Slab>> dailyrate;
    Map<VehicleType, List<Slab>> hourlyrate;
    public void init(){
        hourlyrate.put(VehicleType.TWOWHEELER,
                Arrays.asList( new Slab(1,3,25), new Slab(4,6,30), new Slab(7,Integer.MAX_VALUE,40)));
        hourlyrate.put(VehicleType.FOURWHEELER,
                Arrays.asList( new Slab(1,3,25), new Slab(4,6,30), new Slab(7,Integer.MAX_VALUE,40)));
        hourlyrate.put(VehicleType.TWOWHEELER,
                Arrays.asList( new Slab(1,3,25), new Slab(4,6,30), new Slab(7,Integer.MAX_VALUE,40)));

        dailyrate.put(VehicleType.TWOWHEELER,
                Arrays.asList( new Slab(Integer.MIN_VALUE,1,600), new Slab(2,3,800), new Slab(4,Integer.MAX_VALUE,900)));
        dailyrate.put(VehicleType.FOURWHEELER,
                Arrays.asList( new Slab(Integer.MIN_VALUE,1,600), new Slab(2,3,800), new Slab(4,Integer.MAX_VALUE,900)));
        dailyrate.put(VehicleType.LARGEVEHICLE,
                Arrays.asList( new Slab(Integer.MIN_VALUE,1,600), new Slab(2,3,800), new Slab(4,Integer.MAX_VALUE,900)));

    }

    @Override
    public double calculatePrice(VehicleType vehicleType, Duration duration){
        double daily_rate = 0.0;
        List<Slab> dailyrates = dailyrate.get(vehicleType);
        for(Slab price : dailyrates){
            Slab slab = price;
            if(price.min <= duration.days && price.max >= duration.days){
                daily_rate = (duration.days) * (price.price);
                break;
            }

        }
        double hourly_rate = 0.0;
        List<Slab> hourlyrates = hourlyrate.get(vehicleType);
        for(Slab price : hourlyrates){
            Slab slab = price;
            if(price.min <= duration.hrs && price.max >= duration.hrs){
                hourly_rate = (duration.hrs) * (price.price);
                break;
            }

        }
        return daily_rate + hourly_rate;
    }

}
