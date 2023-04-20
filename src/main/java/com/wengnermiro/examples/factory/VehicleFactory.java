package com.wengnermiro.examples.factory;

import com.wengnermiro.examples.vehicle.Vehicle;

public interface VehicleFactory<T> {
    Vehicle produce(T type);
}
