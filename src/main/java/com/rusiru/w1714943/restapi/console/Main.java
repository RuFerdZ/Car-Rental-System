package com.rusiru.w1714943.restapi.console;


import com.rusiru.w1714943.restapi.console.models.Bike;
import com.rusiru.w1714943.restapi.console.models.Car;
import com.rusiru.w1714943.restapi.console.models.Vehicle;
import com.rusiru.w1714943.restapi.console.models.WestminsterRentalVehicleManager;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@SpringBootApplication
@RestController
public class Main {
    public static Scanner input = new Scanner(System.in);
    public static Validation validation = new Validation();
    public static WestminsterRentalVehicleManager rentalVehicleManager = new WestminsterRentalVehicleManager();

    public static void main(String[] args) {

        try {
            System.out.println("===========================================");
            outer : while(true) {
                System.out.println("===========================================" + "\n" +
                        "|   1 - Add Vehicle" + "\n" +
                        "|   2 - Display Vehicle list" + "\n" +
                        "|   3 - Delete Vehicle" + "\n" +
                        "|   4 - Save/Write to File" + "\n" +
                        "|   5 - Exit" + "\n" +
                        "-------------------------------------------");
                System.out.print("Enter Option : ");
                String choice = input.nextLine();


                while (true) {
                    switch (choice) {
                        case "1":
                            setUpVehicle();
                            break;
                        case "2":
                            rentalVehicleManager.viewVehicle();
                            break;
                        case "3":
                            System.out.print("Enter Plate Number : ");
                            String plateNo = input.next();
                            rentalVehicleManager.deleteVehicle(plateNo);
                            break;
                        case "4":
                            rentalVehicleManager.saveVehicle();
                            break;
                        case "5":
                            System.out.println("Thank you ...." + "\n" + "Program now exiting....");
                            break outer;
                        default:
                            System.out.print("Invalid Character entered," +
                                    "\n" + "Please re-enter choice : ");
                            choice = input.nextLine();
                            System.out.println("===========================================");
                            continue;
                    }
                    System.out.println();

                    input.nextLine();
                    break;
                }
            }
        }catch (Exception error){
            System.out.println("Connection Error : Cannot Connect to the Database - " + error);
            System.out.println("Program Exiting.....");
            System.out.println(error.getMessage());
        }
    }

    public static void setUpVehicle(){
        System.out.print("Add a Car(c) or Bike(b) : ");
        String choice = input.next();
        System.out.println("-------------------------------------------" + "\n"
                + "Enter Vehicle Details :");

        System.out.print("Enter Plate Number(AB1234): ");
        String plateNo = input.next();
        System.out.print("Enter Make : ");
        String make = input.next();
        System.out.print("Enter Model : ");
        String model = input.next();
        System.out.print("Enter Engine Capacity (CC) : ");
        String engineCapacity = input.next();
        System.out.print("Enter Transmission Type(Auto/Manual) : ");
        String transmission = input.next();
        transmission = validation.checkTrueFalse(transmission,"auto","manual");
        System.out.print("Enter Fuel Efficiency(Km/L) : ");
        double fuelEfficiency = input.nextDouble();
        System.out.print("Enter Rent per Day (Rs.) : ");
        double rentPerDay = input.nextDouble();

        while (true){
            if(choice.equalsIgnoreCase("c")){
                System.out.print("Enter Seating Capacity : ");
                int seatingCapacity = input.nextInt();
                System.out.print("Hatched-back(Y/N) : ");
                String hatchedBack = input.next();
                boolean boolHatchedBack = validation.checkTrueFalse(hatchedBack);
                System.out.print("Air Conditioned(Y/N) : ");
                String ac = input.next();
                boolean boolAC =validation.checkTrueFalse(ac);

                Vehicle vehicle = new Car(plateNo,make,model,engineCapacity,transmission,fuelEfficiency,rentPerDay,seatingCapacity,boolHatchedBack,boolAC,"car");
                rentalVehicleManager.addVehicle(vehicle);
                break;


            }else if (choice.equalsIgnoreCase("b")){

                System.out.print("Enter Height(m) : ");
                double height = input.nextDouble();
                System.out.print("Storage available(Y/N) : ");
                String storage = input.next();
                boolean storageProvided = validation.checkTrueFalse(storage);

                Vehicle vehicle = new Bike(plateNo,make,model,engineCapacity,transmission,fuelEfficiency,rentPerDay,height,storageProvided,"bike");
                rentalVehicleManager.addVehicle(vehicle);
                break;


            }else{
                System.out.print("Invalid Choice!!!" + "\n" + "Please re-enter : ");
                choice = input.nextLine();
            }
        }
    }
}
