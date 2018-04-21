package lk.sithum.CarPark;

import java.util.ArrayList;


/**
 * Created by DELL on 8/20/2017.
 */
public class Van extends Vehicle {
    // cargoVolume is the unique attribute for a Van
    private String cargoVolume;

    // vans will store the list of Van objects
   protected static ArrayList<Van> vans = new ArrayList();


    public Van(String ID, String brand, DateTime DateandTime, String cargoVolume) {
        super(ID, brand, DateandTime);
        this.cargoVolume = cargoVolume;
    }

    public Van() {

    }

    public String getCargoVolume() {
        return cargoVolume;
    }

    public static void addVan() {

        if ((WestminsterCarParkManager.maxCapacity - WestminsterCarParkManager.currentCapacity) >= 2) {
            System.out.print("Id of the vehicle = ");
            String vehicleId = input.next();
            System.out.print("Brand of the vehicle = ");
            String vehicleBrand = input.next();
            System.out.print("Date of the vehicle entry(DD/MM/YYYY) = ");
            String date = input.next();
            System.out.print("Time of the vehicle entry = ");
            double time = input.nextDouble();
            DateTime datetime = new DateTime(time, date);
            System.out.print("Cargo Volume = ");
            String cargoVolume = input.next();
            System.out.println();

            Van newVan = new Van(vehicleId, vehicleBrand, datetime, cargoVolume);
            vans.add(newVan);
            WestminsterCarParkManager.currentCapacity += 2;
        } else {
            System.out.println("There is no space in the parking lot");
            System.out.println();
        }

    }

    public static void deleteVan() {
        Van van = new Van();
        System.out.print("Id of the van = ");

        WestminsterCarParkManager.choice = input.next();
        for (int i = 0; i < Van.vans.size(); i++) {
            van = Van.vans.get(i);
            if (van.getID() == WestminsterCarParkManager.choice) {
                System.out.println("The van has been successfully removed");
                Van.vans.remove(i);
                WestminsterCarParkManager.currentCapacity -= 2;
                break;
            }
        }

    }


}
