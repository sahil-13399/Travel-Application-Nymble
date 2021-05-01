package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.Exchanges.ActivityPassenger;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;

import java.util.List;

public class PassengerSignUpServiceImpl implements PassengerSignUpService{

    @Override
    public void passengerSignUp(Passenger passenger, TravelPackage travelPackage, String activityName) {
        List<Destination> destinationList = travelPackage.getPackageDestinations();
        for(Destination destination : destinationList) {
            List<Activity> activities = destination.getDestinationActivities();
            for(Activity activity : activities) {
                if (activityName.equals(activity.getActivityName())) {
                    List<ActivityPassenger> activityPassengers = passenger.getActivityPassengerList();
                    activityPassengers.add(new ActivityPassenger(destination.getDestinationName()
                            ,activityName,0));
                    break;
                }
            }
        }
    }
}
