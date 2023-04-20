package com.wengnermiro.examples.vehicle;

public final class StandardVehicle extends CargoVehicle{

    private boolean running;

    public StandardVehicle(int maxLoadWeight) {
        super( maxLoadWeight);
    }

    void setRunning(){
        this.running = true;
    }


    @Override
    public void start() {
        if(fineLoadWeight()){
            this.running =true;
        } else {
            System.out.println("not started, heavy load");
        }
    }

    @Override
    public void stop() {
        if(running){
            running = false;
        }
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public String getDescription(){
        return "StandardVehicle";
    }

    @Override
    public String toString() {
        return "StandardVehicle{" +
               "running=" + running +
               '}';
    }
}
