package lk.sithum.CarPark; /**
 * Created by DELL on 8/20/2017.
 */

import java.util.ArrayList;


public class Motorbike extends Vehicle {
    // Unique attribute for Motorbike
    private String engineCapacity;

    // bikes will store all the bike objects
   protected static ArrayList<Motorbike> bikes = new ArrayList();


    public Motorbike(String ID,String brand,DateTime DateandTime,String engineCapacity){
        super(ID,brand,DateandTime);
        this.engineCapacity=engineCapacity;
    }
    public Motorbike(){

    }

    public String getEngineCapacity(){
        return engineCapacity;
    }

    public static void addMotorbike(){

        if((WestminsterCarParkManager.maxCapacity-WestminsterCarParkManager.currentCapacity)>=1){
            System.out.print("Id of the vehicle = ");
            String vehicleId = input.next();
            System.out.print("Brand of the vehicle = ");
            String vehicleBrand = input.next();
            System.out.print("Date of the vehicle entry(DD/MM/YYYY) = ");
            String date = input.next();
            System.out.print("Time of the vehicle entry = ");
            double time = input.nextDouble();
            DateTime datetime = new DateTime(time, date);
            System.out.print("Engine Capacity = ");
            String engineCapacity=input.next();
            System.out.println();

            Motorbike newBike=new Motorbike(vehicleId,vehicleBrand,datetime,engineCapacity);
            bikes.add(newBike);
            WestminsterCarParkManager.currentCapacity++;
        }
        else {
            System.out.println("There is no space in the parking lot");
            System.out.println();
        }
    }

    public static void deleteBike(){
        Motorbike bike=new Motorbike();
        System.out.print("Id of the Motor Bike = ");

        WestminsterCarParkManager.choice=input.next();
        for(int i=0;i<Motorbike.bikes.size();i++){
            bike=Motorbike.bikes.get(i);
            if(bike.getID()==WestminsterCarParkManager.choice){
                System.out.println("Motorbike has been succesfully removed");
                Motorbike.bikes.remove(i);
                WestminsterCarParkManager.currentCapacity--;
                break;
            }

        }

    }
}
