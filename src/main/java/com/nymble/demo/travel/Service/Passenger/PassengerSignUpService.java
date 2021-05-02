package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.Exceptions.ActivityUnavailable;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;

public interface PassengerSignUpService {
   public void passengerSignUp(Passenger passenger, TravelPackage travelPackage, String activityName) throws ActivityUnavailable;
}
