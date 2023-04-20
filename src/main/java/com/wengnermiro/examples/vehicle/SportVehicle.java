package com.wengnermiro.examples.vehicle;

public final class SportVehicle implements Vehicle{

    private final String type;
    private boolean running;

    public SportVehicle(String type) {
        this.type = type;
    }

    public void start() {
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public String toString() {
        return """
                Vehicle{type='%s', running=%b}""".formatted(type, running);
    }
}
