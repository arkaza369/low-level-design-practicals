package price;

import enums.VehicleType;

public interface PricingStrategy {
    public double calculatePrice(VehicleType vehicleType, Duration duration);
}
