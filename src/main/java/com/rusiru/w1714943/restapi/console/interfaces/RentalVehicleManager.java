package com.rusiru.w1714943.restapi.console.interfaces;

import com.rusiru.w1714943.restapi.console.models.Vehicle;

public interface RentalVehicleManager {
    void addVehicle(Vehicle vehicle);
    void deleteVehicle(String plateNo);
    void viewVehicle();
    void saveVehicle();
}
