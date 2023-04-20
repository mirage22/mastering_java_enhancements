package com.wengnermiro.examples;

import com.wengnermiro.examples.command.StartCommand;
import com.wengnermiro.examples.command.StopCommand;
import com.wengnermiro.examples.factory.DefaultVehicleFactory;
import com.wengnermiro.examples.factory.VehicleType;
import com.wengnermiro.examples.observer.Driver;

public final class MasteringEnhancementsMain {
    public static void main(String[] args) {
        System.out.println("Mastering Java enhancements like Profi: practical design patterns and anti-patterns?");

        var vehicleFactory = new DefaultVehicleFactory();
        var standardVehicle = vehicleFactory.produce(VehicleType.STANDARD);
        var startCommand = new StartCommand.Builder()
                .addVehicle(standardVehicle)
                .build();
        var stopCommand = new StopCommand(standardVehicle);
        var driverWithCommands = new Driver().addCommand(startCommand).addCommand(stopCommand);
        driverWithCommands.executeCommands("start_stop");
        driverWithCommands.printCommands();

    }
}