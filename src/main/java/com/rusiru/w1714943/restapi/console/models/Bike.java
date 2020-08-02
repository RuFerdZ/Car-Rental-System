package com.rusiru.w1714943.restapi.console.models;

import java.util.Objects;

public class Bike extends Vehicle {
    private double height;
    private boolean hasStorage;

    public Bike(String plateNumber, String make, String model, String engineCapacity, String transmission, double fuelEfficiency, double rentPerDay, double height, boolean hasStorage, String type) {
        super(plateNumber, make, model, engineCapacity, transmission, fuelEfficiency, rentPerDay, type);
        this.height = height;
        this.hasStorage = hasStorage;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isHasStorage() {
        return hasStorage;
    }

    public void setHasStorage(boolean hasStorage) {
        this.hasStorage = hasStorage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Bike bike = (Bike) o;
        return Double.compare(bike.height, height) == 0 &&
                hasStorage == bike.hasStorage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height, hasStorage);
    }

    @Override
    public String toString() {
        return "Bike{" +
                "height=" + height +
                ", hasStorage=" + hasStorage +
                ", plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelEfficiency=" + fuelEfficiency +
                ", rentPerDay=" + rentPerDay +
                '}';
    }
}
