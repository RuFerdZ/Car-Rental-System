package com.rusiru.w1714943.restapi.console.models;

import com.rusiru.w1714943.restapi.console.DBconnection;
import com.rusiru.w1714943.restapi.console.interfaces.RentalVehicleManager;



public class WestminsterRentalVehicleManager implements RentalVehicleManager {

    DBconnection connection = new DBconnection();

    @Override
    public void addVehicle(Vehicle vehicle) {
        if((connection.viewAll().size())>=50){
            System.out.println("Vehicle Slot count Exceeding! Cannot add more vehicles");
        }else{
            connection.addVehicle(vehicle);
        }
    }

    @Override
    public void deleteVehicle(String plateNo) {
        connection.deleteVehicle(plateNo);
    }

    @Override
    public void viewVehicle() {
        for (Vehicle vehicle:connection.viewAll()){
            System.out.println(vehicle.getPlateNumber() + "   "  +  vehicle.getType());
        }
    }

    @Override
    public void saveVehicle() {
        connection.writeToFile();
    }
}
