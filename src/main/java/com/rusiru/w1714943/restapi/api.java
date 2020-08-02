package com.rusiru.w1714943.restapi;

import com.rusiru.w1714943.restapi.console.DBconnection;
import com.rusiru.w1714943.restapi.console.models.Schedule;
import com.rusiru.w1714943.restapi.console.models.Vehicle;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@SpringBootApplication
@RestController
public class api {
    DBconnection dBconnection = new DBconnection();

    @GetMapping("/getVehicles")
    @ResponseBody
    public List<Vehicle> getVehicle(){
        return dBconnection.viewAll();
    }


    @PostMapping("/getVehicles")
    @ResponseBody
    public void bookVehicle(@RequestBody Schedule schedule){
        System.out.println(schedule);
        dBconnection.addBooking(schedule);
        dBconnection.updateBookingVehicle(schedule);
    }


}
