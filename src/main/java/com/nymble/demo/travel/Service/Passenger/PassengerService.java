package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.dto.TravelPackage;

public interface PassengerService {
    PassengerResult getPassenger(TravelPackage travelPackage,int passengerId);
    PassengerList getAllPassengers(TravelPackage travelPackage);
}
