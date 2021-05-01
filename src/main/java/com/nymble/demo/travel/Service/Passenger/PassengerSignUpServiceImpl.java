package com.nymble.demo.travel.Service.Passenger;

import com.nymble.demo.travel.BalanceUpdate.BalanceUpdate;
import com.nymble.demo.travel.BalanceUpdateFactory.BalanceUpdateFactory;
import com.nymble.demo.travel.Exchanges.ActivityPassenger;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PassengerSignUpServiceImpl implements PassengerSignUpService{

    @Autowired
    BalanceUpdateFactory balanceUpdateFactory;

    @Override
    public void passengerSignUp(Passenger passenger, TravelPackage travelPackage, String activityName) {
        List<Destination> destinationList = travelPackage.getPackageDestinations();
        BalanceUpdate balanceUpdate = balanceUpdateFactory.getBalanceUpdateObject(
                passenger.getPassengerCategory());
        for(Destination destination : destinationList) {
            List<Activity> activities = destination.getDestinationActivities();
            for(Activity activity : activities) {
                if (activityName.equals(activity.getActivityName())) {
                    List<ActivityPassenger> activityPassengers = passenger.getActivityPassengerList();
                    activityPassengers.add(new ActivityPassenger(destination.getDestinationName()
                            ,activityName,balanceUpdate.updateBalance(passenger,activity)));
                    passenger.setActivityPassengerList(activityPassengers);
                    activity.reduceCapacity();
                    break;
                }
            }
        }
    }
}
