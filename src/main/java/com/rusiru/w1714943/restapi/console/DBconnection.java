package com.rusiru.w1714943.restapi.console;


import com.rusiru.w1714943.restapi.console.models.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DBconnection {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private String username = "root";
    private String password ="";

    ArrayList<Vehicle> vehicleList = new ArrayList<>();

    public DBconnection(){
        PreparedStatement preparedStatement= null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/westminster_vehicle_manager", username, password);
            statement = connection.createStatement();


            System.out.println("Number of vehicle slots available: "+ (50-(viewAll()).size()));
        } catch (Exception ex) {
            System.out.println("Connection error...");
        }
    }

    public void addVehicle(Vehicle vehicle){
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement("insert into vehicle values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ");
            preparedStatement.setString(1,vehicle.getPlateNumber());
            preparedStatement.setString(2,vehicle.getMake());
            preparedStatement.setString(3,vehicle.getModel());
            preparedStatement.setString(4,vehicle.getEngineCapacity());
            preparedStatement.setString(5,vehicle.getTransmission());
            preparedStatement.setDouble(6,vehicle.getFuelEfficiency());
            preparedStatement.setDouble(7,vehicle.getRentPerDay());
            preparedStatement.setString(8,vehicle.getSchedule());
            preparedStatement.setString(9,vehicle.getType());
            if(vehicle.getType().equals("car")){
                preparedStatement.setInt(10,((Car)vehicle).getSeatingCapacity());
                preparedStatement.setBoolean(11,((Car)vehicle).isHatchedBack());
                preparedStatement.setBoolean(12,((Car)vehicle).isAirConditioned());
                preparedStatement.setDouble(13,0);
                preparedStatement.setBoolean(14,false);
            }else{
                preparedStatement.setInt(10,0);
                preparedStatement.setBoolean(11,false);
                preparedStatement.setBoolean(12,false);
                preparedStatement.setDouble(13,((Bike)vehicle).getHeight());
                preparedStatement.setBoolean(14,((Bike)vehicle).isHasStorage());
            }
            preparedStatement.executeUpdate();
            System.out.println("Vehicle Added Successfully");
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

    public void deleteVehicle(String plateNo){
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("DELETE  FROM vehicle WHERE plateNumber=?");
            preparedStatement.setString(1,plateNo);
            preparedStatement.executeUpdate();
            System.out.println("Deleting Successful");

        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

    public ArrayList<Vehicle> viewAll(){
        vehicleList.clear();
        try{
            String query = "SELECT * FROM vehicle";
            resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                if(resultSet.getString("type").equals("car")){
                    Car car = new Car(resultSet.getString("plateNumber"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("engineCapacity"),
                            resultSet.getString("transmission"),
                            resultSet.getDouble("fuelEfficiency"),
                            resultSet.getDouble("rentPerDay"),
                            resultSet.getInt("seatingCapacity"),
                            resultSet.getBoolean("isHatchedBack"),
                            resultSet.getBoolean("isAirConditioned"),
                            resultSet.getString("type"));
                            vehicleList.add(car);
                }else if(resultSet.getString("type").equals("bike")){
                    Bike bike = new Bike(resultSet.getString("plateNumber"),
                            resultSet.getString("make"),
                            resultSet.getString("model"),
                            resultSet.getString("engineCapacity"),
                            resultSet.getString("transmission"),
                            resultSet.getDouble("fuelEfficiency"),
                            resultSet.getDouble("rentPerDay"),
                            resultSet.getDouble("height"),
                            resultSet.getBoolean("hasStorage"),
                            resultSet.getString("type"));
                            vehicleList.add(bike);
                }
            }
            return vehicleList;
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
        return vehicleList;
    }



    public void writeToFile(){
        ArrayList<Vehicle> vehicles = viewAll();

        try {
            File file = new File("Vehicles");
            FileWriter fileWriter=new FileWriter(file);

            for(Vehicle vehicle : vehicles){
                fileWriter.write(vehicle.toString() + "\n");
            }
            fileWriter.close();
            System.out.println("Writing to file : SUCCESS!");
        }catch (IOException error){

        }
    }

    public void addBooking(Schedule schedule){
        String plateNumber = schedule.getPlateNumber();

        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement("insert into booking values (?,?,?,?,?,?,?) ");
            preparedStatement.setString(1,schedule.getCusName());
            preparedStatement.setString(2,schedule.getPhoneNo());
            preparedStatement.setString(3,schedule.NIC);
            preparedStatement.setString(4,schedule.getLicenceNo());
            preparedStatement.setString(5,schedule.getPlateNumber());
            preparedStatement.setDate(6,schedule.getPickUp());
            preparedStatement.setDate(7,schedule.getDropOff());

            preparedStatement.executeUpdate();

            preparedStatement = connection.prepareStatement("update vehicle SET vehiSchedule=? WHERE plateNumber=? ");
            preparedStatement.setString(1,"booked");
            preparedStatement.setString(2,schedule.getPlateNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }

    public void updateBookingVehicle(Schedule schedule){


        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement("update vehicle SET vehiSchedule=? WHERE plateNumber=? ");
            preparedStatement.setString(1,"booked");
            preparedStatement.setString(2,schedule.getPlateNumber());
            preparedStatement.executeUpdate();
        }catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }




}


