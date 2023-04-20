package com.wengnermiro.examples.vehicle;

sealed abstract class CargoVehicle implements Vehicle permits StandardVehicle {

    private final int maxLoadWeight;
    private int loadWeight;

    CargoVehicle(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }


    public void addLoad(int weight){
        this.loadWeight += weight;
    }

    public int getLoadWeight(){
        return loadWeight;
    }

    protected boolean fineLoadWeight() {
        return loadWeight < maxLoadWeight;
    }
}
