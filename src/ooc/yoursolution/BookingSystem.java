/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author vanessa
 */
public class BookingSystem implements BookingSystemInterface {

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {

        /**
         * Declaring variables
         * Creating ArrayList to store cars
         * Read the line
         */ 
        String line, name;
        List<Car> cars = new ArrayList<>();
        name = in.readLine();
        
        /**
         * while loop to check the file and return something
         * split the line to separate variables
         * remember that price is Double
         * remember that numberCars is int 
         */
        while ((line = in.readLine()) != null) {
            String value[] = line.split(":");

            /**
             * declaring [0] as make -> the first info of the text will be car
             * declaring [1] as rate -> the second info of the text will be car
             * declaring [2] as make -> the third info of the text will be car
             */
            Make make = Make.valueOf(value[0]);
            double rate = Double.parseDouble(value[1]);
            int numCars = Integer.parseInt(value[2]);

            /**
             * creating cars 
             * declaring car as number, name of the car(make) and rate
             * adding car to the class Car
             */
            for (int i = 0; i < numCars; i++) {
                Car car = new Car(i, make, rate);
                cars.add(car);
            }
        }

        //declaring and returning
        RentACarInterface rentACarInterface = new RentACar(cars, name);
        return rentACarInterface;
    }
}
