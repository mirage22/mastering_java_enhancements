package com.wengnermiro.examples.factory;

import com.wengnermiro.examples.vehicle.SportVehicle;
import com.wengnermiro.examples.vehicle.StandardVehicle;
import com.wengnermiro.examples.vehicle.Vehicle;

public final class DefaultVehicleFactory implements VehicleFactory<VehicleType> {
    public static int WEIGHT_SECURITY_EQUIPMENTS = 5;
    @Override
    public Vehicle produce(VehicleType type) {
        return switch (type){
            case STANDARD -> {
                var v = new StandardVehicle(10);
                v.addLoad(WEIGHT_SECURITY_EQUIPMENTS);
                yield v;
            }
            case SPORT -> new SportVehicle("super-fast");
        };
    }
}
