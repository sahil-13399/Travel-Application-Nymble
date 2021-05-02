/**
 <h1>Passenger Printer</h1>
 Prints out the passenger
 details.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Printer.PassengerPrinter;

import com.nymble.demo.travel.dto.ActivityPassenger;
import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.dto.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerPrinterImpl implements PassengerPrinter {

    /**
     *  Prints out a single passenger
     *  detail.
     * @param passengerResult This is the first parameter to passengerPrinter method
     *                      which is an object of PassengerResult Class
     * @return void
     */

    @Override
    public void passengerPrinter(PassengerResult passengerResult) {
        if(passengerResult.getBalance() != -1) {
            System.out.println("Passenger Name: " + passengerResult.getPassengerName()
                    + "\nPassenger Number: " + passengerResult.getPassengerNumber()
                    + "\nPassenger Balance: " + passengerResult.getBalance());
        } else {
            System.out.println("Passenger Name: " + passengerResult.getPassengerName()
                    + "\nPassenger Number: " + passengerResult.getPassengerNumber()
                    + "\nPassenger Balance: Not Applicable(Premium Member)");
        }
        System.out.println("-----------------");
        List<ActivityPassenger> activityPassengerList = passengerResult.getPassengerActivityList();
        for(ActivityPassenger activityPassenger : activityPassengerList) {
            System.out.println("Activity Name: " + activityPassenger.getName()
                    + "\nDestination: " + activityPassenger.getDestination()
                    + "\nPrice to customer: " + activityPassenger.getPrice()+"\n");
        }
    }

    /**
     *  Prints out list of passengers in the travel package in
     *  detail.
     * @param passengerList This is the first parameter to passengerPrinter method
     *                      which is an object of PassengerList Class
     * @return void
     */

    @Override
    public void allPassengersPrinter(PassengerList passengerList) {
        System.out.println("Package Name: " + passengerList.getPackageName()
                    + "\nPassenger Capacity: " + passengerList.getPackageCapacity()
                    + "\nPassengers Enrolled: " + passengerList.getPassengerCount());
        System.out.println("------------------");
        for (Passenger passenger : passengerList.getPassengerList()) {
            System.out.println("Passenger Name: " + passenger.getPassengerName()
                        + "\nPassenger Number: " + passenger.getPassengerNumber()+"\n");
        }
    }
}
