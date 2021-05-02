/**
 <h1>Passenger Service</h1>
 Generates the details of a single or
 all the passengers based on which method
 is called.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.dto.ActivityPassenger;
import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.Printer.PassengerPrinter.PassengerPrinter;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerServiceImpl implements PassengerService {

    @Autowired
    PassengerPrinter passengerPrinter;

    /**
     *   1. Get the list of passengers from passenger id.
     *   2. Loop through passenger and list and search for that id.
     *   3. When found, compute the latest balance by subtracting the prices of activities.
     *   4. To do this we call the calculateBalance() method.
     *   5. Print the passenger result using passengerPrinter.
     *   6. Return the Passenger Result.
     * @param travelPackage This is the first paramter to getPassenger method which is an object of TravelPackage Class
     * @param passengerId  This is the second paramter to getPassenger method which is of type int
     * @return PassengerResult This returns details of the passenger.
     */

    @Override
    public PassengerResult getPassenger(TravelPackage travelPackage, int passengerId) {
        PassengerResult passengerResult = null;
        List<Passenger> passengerList = travelPackage.getPackagePassenger();

        for (Passenger passenger : passengerList) {
            if (passenger.getPassengerId() == passengerId) {
                float balance = calculateBalance(passenger);
                passengerResult = new PassengerResult(
                        passenger.getPassengerName(),
                        passenger.getPassengerNumber(),balance,passenger.getActivityPassengerList());
            }
        }
        passengerPrinter.passengerPrinter(passengerResult);
        return passengerResult;
    }

    /**
     *   1. Get the balance of the passenger
     *   2. If the balance is -1 return as it's a premium user.
     *   3. Loop through passenger's activity list.
     *   4. Reduce the price the passenger paid for the activity.
     *   5. Return the updated balance.
     * @param passenger This is the first parameter to calculateBalance method which is an object of Passenger Class
     * @return PassengerList This returns details of the passenger.
     */

    private float calculateBalance(Passenger passenger) {
        float balance = passenger.getBalance();
        if(balance == -1) {
            return -1;
        }
        for (ActivityPassenger activityPassenger : passenger.getActivityPassengerList()) {
            balance -= activityPassenger.getPrice();
        }
        passenger.setBalance(balance);
        return balance;
    }

    /**
     *   1. Create an object of Passenger List.
     *   2. This passenger list object contains all passenger details details.
     *   3. Print the details using printItinerary method.
     *   4. Return the passenger list to caller method.
     * @param travelPackage This is the first parameter to getAllPassengers method which is an object of TravelPackage Class
     * @return PassengerList This returns details of the passenger.
     */

    @Override
    public PassengerList getAllPassengers(TravelPackage travelPackage) {
        PassengerList passengerList = null;
        List<Passenger> passengers = travelPackage.getPackagePassenger();
        passengerList = new PassengerList(
                travelPackage.getPackageName(),
                travelPackage.getPackageCapacity(),passengers.size(),passengers);
        passengerPrinter.allPassengersPrinter(passengerList);
        return passengerList;
    }
}
