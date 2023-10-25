package pricing;

import enums.VehicleType;


public class PricingStrategyContext {
    PricingStrategy pricingStrategy;
    public void setPricingStrategy(PricingStrategy pricingStrategy){
        this.pricingStrategy = pricingStrategy;
    }
    public double calculatePrice(VehicleType vehicleType, Duration duration){
        return pricingStrategy.calculatePrice(vehicleType, duration);
    }
}
