package com.nymble.demo.travel.Printer.PassengerPrinter;

import com.nymble.demo.travel.Exchanges.ActivityPassenger;
import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.dto.Passenger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerPrinterImpl implements PassengerPrinter {

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
