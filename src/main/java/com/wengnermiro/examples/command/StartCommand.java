package com.wengnermiro.examples.command;

import com.wengnermiro.examples.vehicle.SportVehicle;
import com.wengnermiro.examples.vehicle.StandardVehicle;
import com.wengnermiro.examples.vehicle.Vehicle;

import java.util.concurrent.atomic.AtomicBoolean;


//Command can be considered as Adapter
public record StartCommand(Vehicle vehicle, AtomicBoolean executed) implements VehicleCommand {
    public static final class  Builder {
        private Vehicle builderVehicle;

        public Builder addVehicle(Vehicle v){
            this.builderVehicle = v;
            return this;
        }

        public StartCommand build(){
            return new StartCommand(this);
        }
    }
    private StartCommand(Builder builder){
        this(builder.builderVehicle, new AtomicBoolean());
    }

    @Override
    public void process(String command) {
        if(command.contains("start")){
            switch (vehicle){
                case StandardVehicle v when v.getLoadWeight() > 1 ->
                    System.out.printf("""
                        %s with description:'%s', weight:'%d'%n""", v, v.getDescription(), v.getLoadWeight());
                case StandardVehicle v -> System.out.printf("""
                        %s with description:'%s'%n""", v, v.getDescription());
                case SportVehicle v -> System.out.println(v);
                default -> System.out.println("NOTHING");
            }
            executed.set(true);
            vehicle.start();
            System.out.println("START:" + vehicle);
        }
    }

    @Override
    public boolean isExecuted() {
        return executed.get();
    }

    @Override
    public String status() {
        return """
                Command START, vehicle:'%s', status:'%b'%n""".formatted(
                        vehicle.getClass().getSimpleName(), executed.get());
    }
}
