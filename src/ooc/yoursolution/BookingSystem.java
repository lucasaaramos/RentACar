/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 * @author lucas
 */
public class BookingSystem implements BookingSystemInterface {

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        
        //FeedInterface feed = new Feed();
        
        
        //review....this is wrong!
        
        
        RentACarInterface rent = new RentACar();
        
        String title = in.readLine();
        String nameCar = "";
                
        while(nameCar != null) {
            
            nameCar = in.readLine();
            
            //FeedItem item = new FeedItem(title, content);
            //feed.addItem(item);
            
            RentACar car = new RentACar(nameCar);
            rent.getName(car);
            
        }        
        
        return rent;

    }
    
}
