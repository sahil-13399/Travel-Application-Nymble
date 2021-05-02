package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.BalanceUpdate.BalanceUpdate;
import com.nymble.demo.travel.BalanceUpdateFactory.BalanceUpdateFactory;
import com.nymble.demo.travel.Exceptions.ActivityUnavailable;
import com.nymble.demo.travel.Exceptions.NoVacancyInActivity;
import com.nymble.demo.travel.dto.ActivityPassenger;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PassengerSignUpServiceImpl implements PassengerSignUpService{

    @Autowired
    private BalanceUpdateFactory balanceUpdateFactory;
    private BalanceUpdate balanceUpdate;

    @Override
    public void passengerSignUp(Passenger passenger, TravelPackage travelPackage, String activityName) throws ActivityUnavailable {
        boolean isPresent = false;
        List<Destination> destinationList = travelPackage.getPackageDestinations();
        balanceUpdate = balanceUpdateFactory.getBalanceUpdateObject(
                passenger.getPassengerCategory());
        for(Destination destination : destinationList) {
            List<Activity> activities = destination.getDestinationActivities();
            for(Activity activity : activities) {
                if (activityName.equals(activity.getActivityName())) {
                    try {
                        if(activity.getCapacity() == 0) {
                            throw new NoVacancyInActivity("All seats for this Activity are booked");
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    List<ActivityPassenger> activityPassengers = passenger.getActivityPassengerList();
                    try {
                        activityPassengers.add(new ActivityPassenger(destination.getDestinationName()
                                ,activityName,balanceUpdate.updateBalance(passenger,activity)));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    passenger.setActivityPassengerList(activityPassengers);
                    activity.reduceCapacity();
                    isPresent = true;
                    break;
                }
            }
            if (isPresent) {
                break;
            }
        }
        if(!isPresent) {
            throw new ActivityUnavailable("The Activity is not present");
        }

    }
}
