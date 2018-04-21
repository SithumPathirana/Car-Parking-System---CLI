package lk.sithum.CarPark; /**
 * Created by DELL on 8/20/2017.
 */

import java.util.ArrayList;


public class Car extends Vehicle {

    // Two attributes that are unique to Cars
    private int noOfDoors;
    private String color;

    // will store all the car objects
    protected static ArrayList<Car> cars = new ArrayList();


    public Car(String ID, String brand, DateTime DateandTime, int noOfDoors, String color) {
        super(ID, brand, DateandTime);
        this.setNoOfDoors(noOfDoors);
        this.color = color;
    }

    public Car() {

    }

    public int getNoOfDoors() {

        return noOfDoors;
    }

    public String getColor() {
        return color;
    }

    public void setNoOfDoors(int noOfDoors) {
        if (noOfDoors > 0) {
            this.noOfDoors = noOfDoors;
        } else {
            throw new IllegalArgumentException("The number of doors entered was invalid");
        }
    }

    public static void addCar() {

        if ((WestminsterCarParkManager.maxCapacity - WestminsterCarParkManager.currentCapacity) >= 1) {
            System.out.print("Id of the vehicle = ");
            String vehicleId = input.next();
            System.out.print("Brand of the vehicle = ");
            String vehicleBrand = input.next();
            System.out.print("Date of the vehicle entry(DD/MM/YYYY) = ");
            String date = input.next();
            System.out.print("Time of the vehicle entry = ");
            double time = input.nextDouble();
            DateTime datetime = new DateTime(time, date);
            System.out.print("Number of doors = ");
            int doors = input.nextInt();
            System.out.print("Color = ");
            String color = input.next();
            System.out.println();

            Car newCar = new Car(vehicleId, vehicleBrand, datetime, doors, color);
            cars.add(newCar);
            WestminsterCarParkManager.currentCapacity++;
        } else {
            System.out.println("There is no space in the parking lot");
            System.out.println();
        }

    }

    public static void deleteCar() {
        Car car = new Car();
        System.out.print("Id of the car = ");

        WestminsterCarParkManager.choice = input.next();
        for (int i = 0; i < Car.cars.size(); i++) {
            car = Car.cars.get(i);
            if (car.getID() == WestminsterCarParkManager.choice) {
                Car.cars.remove(i);
                System.out.println("The car has been successfully removed");
                WestminsterCarParkManager.currentCapacity--;
                break;
            }

        }


    }

}
