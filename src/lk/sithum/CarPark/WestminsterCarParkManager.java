package lk.sithum.CarPark; /**
 * Created by DELL on 8/20/2017.
 */

import java.util.*;

public class WestminsterCarParkManager implements CarParkManager {

    // maximum capacity in the parking lot
    public static final int maxCapacity = 20;

    // gets updated when adding vehicles
    static int currentCapacity = 0;

    // staic varible which takes all the user's choices from the menu
    static String choice = "";


    static Scanner input = new Scanner(System.in);

    public static void main(String args[]) {
        menu();
    }

    // Menu which the user selects his options
    public static void menu() {
        System.out.println("-----Press 1 to add a car-----");
        System.out.println("-----Press 2 to add a van-----");
        System.out.println("-----Press 3 to add a motorbike-----");
        System.out.println("-----Press 4 to delete a vehicle-----");
        System.out.println("-----Press 5 to print the vehicles-----");
        System.out.println("-----Press 6 to get the percentage of the vehicles-----");
        System.out.println("-----Press 7 to see the vehicle that has been parked for the longest amount of time-----");
        System.out.println("-----Press 8 to see vehicles parked on a specific day-----");


        choice = input.next();

        switch (choice) {
            case "1":
                Car.addCar();
                menu();
                break;

            case "2":
                Van.addVan();
                menu();
                break;

            case "3":
                Motorbike.addMotorbike();
                menu();
                break;

            case "4":
                Vehicle.deleteVehicle();
                menu();
                break;
            case "5":
                Vehicle.printVehicles();
                menu();
                break;

            case "6":
                Vehicle.getVehiclePercentage();
                menu();
                break;

            case "7":
                Vehicle.longestParkingVehicle();
                menu();
                break;

            case "8":
                Vehicle.vehiclesParkedOnaSpecificDay();
                menu();
                break;
        }

    }

    // Generate the pay
    public static void generatePay() {
        System.out.print("Enter the vehicle id : ");
        choice = input.next();


        Car car = new Car();
        for (int i = 0; i < Car.cars.size(); i++) {
            car = Car.cars.get(i);

            if (choice == car.getID()) {
                double minutes = Math.round(car.getDateandTime().getTime());
            }

        }


    }


}
