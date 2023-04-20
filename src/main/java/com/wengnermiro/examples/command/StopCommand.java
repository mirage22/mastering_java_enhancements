package com.wengnermiro.examples.command;

import com.wengnermiro.examples.vehicle.Vehicle;

public final class  StopCommand implements VehicleCommand {

    private final Vehicle vehicle;
    private boolean executed;

    public StopCommand(Vehicle vehicle){
        this.vehicle = vehicle;
    }

    @Override
    public void process(String command) {
        if(command.contains("stop")){
            vehicle.stop();
            executed = true;
            System.out.println("STOP:" + vehicle);
        }
    }

    @Override
    public boolean isExecuted() {
        return executed;
    }

    @Override
    public String status() {
        return """
                Command STOP, vehicle:'%s', status:'%b'%n""".formatted(vehicle.getClass().getSimpleName(), executed);
    }
}
