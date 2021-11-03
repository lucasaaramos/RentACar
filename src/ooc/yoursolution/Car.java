/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author vanessa
 */
public class Car implements CarInterface {

    /**
     * creating the variables for the car (id - make - rate)
     * create a boolean map to set the amount of days in the month
     * 
     */
    
    private int id;
    private Make make;
    private double rate;
    private Map<Month, Boolean[]> map;

    public Car(int id, Make make, double rate) {
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
    }

    /**
     * including all the days of the month and returning 
     * @return 
     */
    @Override
    public Map createAvailability() {
        map = new HashMap<>();

        map.put(Month.JANUARY, new Boolean[31]);
        map.put(Month.FEBRUARY, new Boolean[28]);
        map.put(Month.MARCH, new Boolean[31]);
        map.put(Month.APRIL, new Boolean[30]);
        map.put(Month.MAY, new Boolean[31]);
        map.put(Month.JUNE, new Boolean[30]);
        map.put(Month.JULY, new Boolean[31]);
        map.put(Month.AUGUST, new Boolean[31]);
        map.put(Month.SEPTEMBER, new Boolean[30]);
        map.put(Month.OCTOBER, new Boolean[31]);
        map.put(Month.NOVEMBER, new Boolean[30]);
        map.put(Month.DECEMBER, new Boolean[31]);

        return map;
    }

    /**
     * getter and setter for Make
     * @return 
     */
    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    /**
     * getter and setter for rate
     * 
     * @return 
     */
    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }

    /**
     * getter and setter for availability
     * @return 
     */
    @Override
    public Map getAvailability() {
        return map;
    }

    @Override
    public void setAvailability(Map availability) {
        this.map = map;
    }

    //returning ID
    @Override
    public int getId() {
        return id;
    }
    
    @Override
    public void setId(int id) {
       this.id = id;
    }
    
    
    
    /**
     * passing the parameters and return availability if it is true
     * day -1 because needs to follow the array that starts at 0
     * @param month
     * @param day
     * @return 
     */
    @Override
    public boolean isAvailable(Month month, int day) {
        Boolean[] availability = map.get(month);
        if (availability[day-1] == null) {
            availability[day-1] = true;
        }
        return availability[day-1];
    }

    /**
     * checking conditions and returning true
     * @param month
     * @param day
     * @return 
     */
    @Override
    public boolean book(Month month, int day) {
        if (map.get(month)[day-1]) {
            map.get(month)[day-1] = false;
            return true;
        }

        return false;
    }
}
