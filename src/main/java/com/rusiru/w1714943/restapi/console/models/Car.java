package com.rusiru.w1714943.restapi.console.models;

import java.util.Objects;

public class Car extends Vehicle {
    private int seatingCapacity;
    private boolean isHatchedBack;
    private boolean isAirConditioned;

    public Car(String plateNumber, String make, String model, String engineCapacity, String transmission, double fuelEfficiency, double rentPerDay, int seatingCapacity, boolean isHatchedBack, boolean isAirConditioned, String type) {
        super(plateNumber, make, model, engineCapacity, transmission, fuelEfficiency, rentPerDay, type);
        this.seatingCapacity = seatingCapacity;
        this.isHatchedBack = isHatchedBack;
        this.isAirConditioned = isAirConditioned;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public boolean isHatchedBack() {
        return isHatchedBack;
    }

    public void setHatchedBack(boolean hatchedBack) {
        isHatchedBack = hatchedBack;
    }

    public boolean isAirConditioned() {
        return isAirConditioned;
    }

    public void setAirConditioned(boolean airConditioned) {
        isAirConditioned = airConditioned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return seatingCapacity == car.seatingCapacity &&
                isHatchedBack == car.isHatchedBack &&
                isAirConditioned == car.isAirConditioned;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), seatingCapacity, isHatchedBack, isAirConditioned);
    }

    @Override
    public String toString() {
        return "Car{" +
                "seatingCapacity=" + seatingCapacity +
                ", isHatchedBack=" + isHatchedBack +
                ", isAirConditioned=" + isAirConditioned +
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
