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

/**
 *
 * @author vanessa
 */
public class BookingSystem implements BookingSystemInterface {

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        //reading the first line
        String line = in.readLine();
        RentACarInterface rentACar = new RentACar();
        rentACar.setName(line);

        //System.out.println(line);
        //creating arrayList to include cars
        List<CarInterface> cars = new ArrayList<>();
        
        //loop to ready the lines of the file
        while (in.ready()) {
            line = in.readLine();
            //creating a car with the line information
            CarInterface car = new Car(line);
            //adding the car to the class
            cars.add(car);
        }

        //setting the car for rent
        rentACar.setCars(cars);

        return rentACar;
    }

}
