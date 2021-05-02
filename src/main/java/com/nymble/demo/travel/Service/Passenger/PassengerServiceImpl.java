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
