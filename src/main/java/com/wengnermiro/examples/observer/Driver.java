package com.wengnermiro.examples.observer;

import com.wengnermiro.examples.command.StartCommand;
import com.wengnermiro.examples.command.VehicleCommand;
import com.wengnermiro.examples.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

//Observer, Caching
public class Driver {
    private final List<VehicleCommand> commands = new ArrayList<>();

    public Driver addCommand(VehicleCommand command){
        commands.add(command);
        return this;
    }

    public void executeCommands(final String command){
        commands.forEach(c -> {
            // Records decomposition
            if(c instanceof StartCommand(Vehicle v, AtomicBoolean state)){
                System.out.printf("""
                        %s vehicle:'%s', running:'%b'%n""", c.getClass().getSimpleName(), v.getClass().getSimpleName(), state.get());
            }
            c.process(command);
        });
    }

    public void printCommands() {
        System.out.printf("""
                Considered COMMANDS:%n%s""", commands.stream()
        .map(VehicleCommand::status)
        .collect(Collectors.joining("")));
    }
}
