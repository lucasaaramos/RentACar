/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author vanessa
 */
public class RentACar implements RentACarInterface {

    //Creating List to include cars
    private List<Car> cars;
    private String name;

    /**
     * this will return the List and String passed in 
     * @param cars
     * @param name 
     */
    public RentACar(List<Car> cars, String name) {
        this.cars = cars;
        this.name = name;
    }

    /**
     * Getting and setting cars 
     * @return 
     */
    @Override
    public List getCars() {
        return cars;
    }
    
    @Override
    public void setCars(List cars) {
        this.cars = cars;
    }

    /**
     * Getting and setting name 
     * @return 
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    

    /**
     * Checking avaiability
     * check the (Month month, int day, Make make, int lengthOfRent)
     * @param month
     * @param day
     * @param make
     * @param lengthOfRent
     * @return 
     */
    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        int currentDay, check;

        /**
         * checking each car available in the list of cars
         * declaring currentDay as the same as day in the method declared above
         * creating a loop to check if car is available
         * declaring check -> if check is equals to 0 -> return true
         * if car in not available -> check is equals to 1 -> break -> return false at the end
         * 
         */
        for (Car car : cars) {
            if (car.getMake().equals(make)) {
                check = 0;
                currentDay = day;
                for (int i = 0; i < lengthOfRent; i++) {
                    if (!car.isAvailable(month, currentDay++)) {
                        check = 1;
                        break;
                    }
                }

                if (check == 0) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * passing the following parameters:
     * @param month
     * @param day
     * @param make
     * @param lengthOfRent
     * 
     * Using the same structure from the method above
     * in this case, if check is equals to 0 -> return getId from the method in the class Car
     * then return -1
     * 
     * @return 
     */
    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        int currentDay, check;

        for (Car car : cars) {
            if (car.getMake().equals(make)) {
                check = 0;
                currentDay = day;
                for (int i = 0; i < lengthOfRent; i++) {
                    if (!car.isAvailable(month, currentDay++)) {
                        check = 1;
                        break;
                    }
                }

                if (check == 0) {
                    return car.getId();
                }
            }
        }

        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {

        /**
         * check avaiability (month, day, make and lengthOfRent)
         * if not available -> return false
         * otherwise set carId to the info
         * check if the ID of the car in the class car is the same as carId setup here
         * check if the make in the class Car is the same as make in the method
         * @return
         */
        if (!checkAvailability(month, day, make, lengthOfRent)) {
            return false;
        }

        int carId = getCarAvailable(month, day, make, lengthOfRent);

        for (Car car : cars) {
            if (car.getId() == carId && car.getMake() == make) {
                int currentDay = day;
                for (int i = 0; i < lengthOfRent; i++) {
                    car.book(month, currentDay++);
                }
            }
        }

        return true;
    }

    //setting the number os cars using size()
    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    @Override
    public void getName(RentACar car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
