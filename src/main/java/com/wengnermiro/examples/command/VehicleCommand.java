package com.wengnermiro.examples.command;

public sealed interface VehicleCommand permits StartCommand, StopCommand {
    void process(String command);
    boolean isExecuted();
    String status();


}
