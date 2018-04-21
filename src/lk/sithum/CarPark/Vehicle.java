package lk.sithum.CarPark; /**
 * Created by DELL on 8/20/2017.
 */

import java.util.Scanner;

public abstract class Vehicle {
    // Three atrributes common for all the vehicles (ID,brand and Datetime)
    private String ID;
    private String brand;
    private DateTime DateandTime;

    static Scanner input = new Scanner(System.in);

    public Vehicle(String ID, String brand, DateTime DateandTime) {
        this.ID = ID;
        this.brand = brand;
        this.DateandTime = DateandTime;
    }

    public Vehicle() {

    }

    public String getID() {
        return ID;

    }

    public String getBrand() {
        return brand;
    }

    public DateTime getDateandTime() {
        return DateandTime;
    }

    public static void deleteVehicle() {

        System.out.println("Press C to delete a car");
        System.out.println("Press V to delete a van");
        System.out.println("Press M to delete a motorbike");
        System.out.println();
        WestminsterCarParkManager.choice = input.next();

        switch (WestminsterCarParkManager.choice) {
            case "C":
            case "c":
                Car.deleteCar();
                WestminsterCarParkManager.menu();
                break;

            case "V":
            case "v":
                Van.deleteVan();
                WestminsterCarParkManager.menu();
                break;

            case "M":
            case "m":
                Motorbike.deleteBike();
                WestminsterCarParkManager.menu();
                break;


        }
    }

    public static void printVehicles() {
        System.out.println("Cars Parked");
        System.out.println();
        Car car = new Car();
        for (int i = 0; i < Car.cars.size(); i++) {
            car = Car.cars.get(i);
            System.out.println("Id of the vehicle : " + car.getID());
            System.out.println("Date of entry : " + car.getDateandTime().getDate());
            System.out.println("Time of entry : " + car.getDateandTime().getTime());
            System.out.println();

        }
        System.out.println();
        System.out.println("Vans parked");
        System.out.println();
        Van van = new Van();
        for (int i = 0; i < Van.vans.size(); i++) {
            van = Van.vans.get(i);
            System.out.println("Id of the vehicle : " + van.getID());
            System.out.println("Date of entry : " + van.getDateandTime().getDate());
            System.out.println("Time of entry : " + van.getDateandTime().getTime());
            System.out.println();

        }

        System.out.println();
        System.out.println("Motorbikes parked");
        System.out.println();
        Motorbike bike = new Motorbike();
        for (int i = 0; i < Motorbike.bikes.size(); i++) {
            bike = Motorbike.bikes.get(i);
            System.out.println("Id of the vehicle : " + bike.getID());
            System.out.println("Date of entry : " + bike.getDateandTime().getDate());
            System.out.println("Time of entry : " + bike.getDateandTime().getTime());
            System.out.println();

        }


    }

    // Will show the existance of vehicles as a percentage
    public static void getVehiclePercentage() {
        double carPerecentage = (Car.cars.size() * 100) / (Car.cars.size() + Van.vans.size() + Motorbike.bikes.size());
        double vanPerecentage = (Van.vans.size() * 100) / (Car.cars.size() + Van.vans.size() + Motorbike.bikes.size());
        double bikePerecentage = (Motorbike.bikes.size() * 100) / (Car.cars.size() + Van.vans.size() + Motorbike.bikes.size());
        System.out.println("Percentage of the Cars(%) = " + carPerecentage);
        System.out.println("Percentage of the Vans(%) = " + vanPerecentage);
        System.out.println("Percentage of the Motorbikes(%) = " + bikePerecentage);
    }

    public static void longestParkingVehicle() {
        Car carParkedForTheLongestTime = Car.cars.get(0);
        Van vanParkedForTheLongestTime = Van.vans.get(0);
        Motorbike bikeParkedForTheLongestTime = Motorbike.bikes.get(0);

        for (int i = 1; i < Car.cars.size(); i++) {
            if (Car.cars.get(i).getDateandTime().getTime() < carParkedForTheLongestTime.getDateandTime().getTime()) {
                carParkedForTheLongestTime = Car.cars.get(i);
            }
        }

        for (int i = 1; i < Van.vans.size(); i++) {
            if (Van.vans.get(i).getDateandTime().getTime() < vanParkedForTheLongestTime.getDateandTime().getTime()) {
                vanParkedForTheLongestTime = Van.vans.get(i);
            }
        }

        for (int i = 1; i < Motorbike.bikes.size(); i++) {
            if (Motorbike.bikes.get(i).getDateandTime().getTime() < bikeParkedForTheLongestTime.getDateandTime().getTime()) {
                bikeParkedForTheLongestTime = Motorbike.bikes.get(i);
            }
        }

        Vehicle vehicleParkedForTheLongestTime = carParkedForTheLongestTime;

        if (vanParkedForTheLongestTime.getDateandTime().getTime() <= vehicleParkedForTheLongestTime.getDateandTime().getTime()) {
            vehicleParkedForTheLongestTime = vanParkedForTheLongestTime;
        } else if (bikeParkedForTheLongestTime.getDateandTime().getTime() < vehicleParkedForTheLongestTime.getDateandTime().getTime()) {
            vehicleParkedForTheLongestTime = bikeParkedForTheLongestTime;
        }

        System.out.println("Veicle Id of the vehicle that has been parked for the longest amount of time " +
                "is = " + vanParkedForTheLongestTime.getID());
        System.out.println();
    }

    // Dislay vehicles parked on a specific date
    public static void vehiclesParkedOnaSpecificDay() {
        boolean recordFound = false;
        System.out.print("Enter the day : ");
        int day = input.nextInt();
        System.out.print("Enter the month : ");
        int month = input.nextInt();
        System.out.println("Enter the year : ");
        int year = input.nextInt();

        Car car = new Car();
        for (int i = 0; i < Car.cars.size(); i++) {
            car = Car.cars.get(i);
            int carEntryDay = Integer.parseInt(car.getDateandTime().getDate().substring(0, 2));
            int carEntryMonth = Integer.parseInt(car.getDateandTime().getDate().substring(3, 5));
            int carEntryYear = Integer.parseInt(car.getDateandTime().getDate().substring(6));

            if ((day == carEntryDay && month == carEntryMonth) && year == carEntryYear) {
                recordFound = true;
                System.out.println("Id of the vehicle : " + car.getID());
                System.out.println("Vehicle type : Car");
                System.out.println("Time of entry : " + car.getDateandTime().getTime());
                System.out.println();
            }


        }

        Van van = new Van();
        for (int i = 0; i < Van.vans.size(); i++) {
            van = Van.vans.get(i);
            int vanEntryDay = Integer.parseInt(van.getDateandTime().getDate().substring(0, 2));
            int vanEntryMonth = Integer.parseInt(van.getDateandTime().getDate().substring(3, 5));
            int vanEntryYear = Integer.parseInt(van.getDateandTime().getDate().substring(6));

            if ((day == vanEntryDay && month == vanEntryMonth) && year == vanEntryYear) {
                recordFound = true;
                System.out.println("Id of the vehicle : " + van.getID());
                System.out.println("Vehicle type : Van");
                System.out.println("Time of entry : " + van.getDateandTime().getTime());
                System.out.println();
            }


        }

        Motorbike bike = new Motorbike();
        for (int i = 0; i < Motorbike.bikes.size(); i++) {
            bike = Motorbike.bikes.get(i);
            int bikeEntryDay = Integer.parseInt(bike.getDateandTime().getDate().substring(0, 2));
            int bikeEntryMonth = Integer.parseInt(bike.getDateandTime().getDate().substring(3, 5));
            int bikeEntryYear = Integer.parseInt(bike.getDateandTime().getDate().substring(6));

            if ((day == bikeEntryDay && month == bikeEntryMonth) && year == bikeEntryYear) {
                recordFound = true;
                System.out.println("Id of the vehicle : " + bike.getID());
                System.out.println("Vehicle type : Motorbike");
                System.out.println("Time of entry : " + bike.getDateandTime().getTime());
                System.out.println();
            }


        }


        if (recordFound == false) {
            System.out.println("No vehicles were parked in that day");
            System.out.println();
        }

    }
}
