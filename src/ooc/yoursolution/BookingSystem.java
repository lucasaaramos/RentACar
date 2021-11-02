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
        String line = in.readLine();
        RentACarInterface rentACar = new RentACar();
        rentACar.setName(line);
                
        //System.out.println(line);
        List<CarInterface> cars = new ArrayList<>();
            while (in.ready()) {
                line = in.readLine();
                CarInterface car = new Car(line);
                cars.add(car);
            }
        
            rentACar.setCars(cars);

        return rentACar;
    }

}
