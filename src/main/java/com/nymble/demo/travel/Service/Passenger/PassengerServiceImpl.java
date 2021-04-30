package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;

import java.util.List;

public class PassengerServiceImpl implements PassengerService {
    @Override
    public PassengerResult getPassenger(TravelPackage travelPackage, int passengerId) {
        PassengerResult passengerResult = null;
        List<Passenger> passengerList = travelPackage.getPackagePassenger();
        for (Passenger passenger : passengerList) {
            if (passenger.getPassengerId() == passengerId) {
                passengerResult = new PassengerResult(
                        passenger.getPassengerName(),
                        passenger.getPassengerNumber(),passenger.getActivityPassengerList());
            }
        }
        return passengerResult;
    }

    @Override
    public PassengerList getAllPassengers(TravelPackage travelPackage) {
        PassengerList passengerList = null;
        List<Passenger> passengers = travelPackage.getPackagePassenger();
        passengerList = new PassengerList(
                travelPackage.getPackageName(),
                travelPackage.getPackageCapacity(),passengers.size(),passengers);
        return passengerList;
    }
}
