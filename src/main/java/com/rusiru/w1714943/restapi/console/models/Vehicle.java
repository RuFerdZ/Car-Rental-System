package com.rusiru.w1714943.restapi.console.models;

import java.util.Objects;


public abstract class Vehicle implements Comparable<Vehicle>  {

    protected String plateNumber;
    protected String make;
    protected String model;
    protected String engineCapacity;
    protected String transmission;
    protected double fuelEfficiency;
    protected double rentPerDay;
    protected String schedule = null;
    protected String type;

    public Vehicle(String plateNumber, String make, String model, String engineCapacity, String transmission, double fuelEfficiency, double rentPerDay, String type) {
        this.plateNumber = plateNumber;
        this.make = make;
        this.model = model;
        this.engineCapacity = engineCapacity;
        this.transmission = transmission;
        this.fuelEfficiency = fuelEfficiency;
        this.rentPerDay = rentPerDay;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Double.compare(vehicle.fuelEfficiency, fuelEfficiency) == 0 &&
                Double.compare(vehicle.rentPerDay, rentPerDay) == 0 &&
                plateNumber.equals(vehicle.plateNumber) &&
                make.equals(vehicle.make) &&
                model.equals(vehicle.model) &&
                engineCapacity.equals(vehicle.engineCapacity) &&
                transmission.equals(vehicle.transmission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNumber, make, model, engineCapacity, transmission, fuelEfficiency, rentPerDay);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNumber='" + plateNumber + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity='" + engineCapacity + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelEfficiency=" + fuelEfficiency +
                ", rentPerDay=" + rentPerDay +
                '}';
    }

//    public int compareTo(Vehicle obj){
//        return this.getMake()-obj.getMake();
//    }


    @Override
    public int compareTo(Vehicle o) {
        return 1;
    }
}
