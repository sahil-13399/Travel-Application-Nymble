package com.nymble.demo.travel.Printer.PassengerPrinter;

import com.nymble.demo.travel.Exchanges.ActivityPassenger;
import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
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
        List<ActivityPassenger> activityPassengerList = passengerResult.getPassengerActivityList();
        for(ActivityPassenger activityPassenger : activityPassengerList) {
            System.out.println("Activity Name: " + activityPassenger.getName()
                    + "\nDestination: " + activityPassenger.getDestination()
                    + "\nPrice to customer: " + activityPassenger.getPrice());
        }
    }

    @Override
    public void allPassengersPrinter(PassengerList passengerList) {

    }
}
