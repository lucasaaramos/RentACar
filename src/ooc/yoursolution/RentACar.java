/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author vanessa
 */
public class RentACar implements RentACarInterface {

    private String name;
    private List<CarInterface> cars;

    @Override
    public List<CarInterface> getCars() {
        return this.cars;
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        for (CarInterface car : getCars()) {
            if (car.getMake().equals(make)) {
                Map<Month, boolean[]> availability = car.getAvailability();
                boolean[] days = availability.get(month);
                if (day + lengthOfRent <= month.getNumberOfDays()) {
                    return checkAvailability(days, day, day + lengthOfRent);

                } else {
                    return checkAvailability(days, day, month.getNumberOfDays())
                            && checkAvailability(availability.get(month.getNext()), 1, day + lengthOfRent - month.getNumberOfDays());
                }
            }
        }
        return false;
    }

    private boolean checkAvailability(boolean[] days, int firstDay, int lastDay) {
        boolean available = true;
        for (int i = firstDay - 1; i < lastDay; i++) {
            available = available && days[i];
        }
        return available;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    @Override
    public void getName(RentACar car) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
