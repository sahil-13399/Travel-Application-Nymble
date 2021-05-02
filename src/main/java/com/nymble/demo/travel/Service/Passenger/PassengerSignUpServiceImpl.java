/**
 <h1>Passenger Sign Up Service</h1>
 Helps to sign up a user for an
 activity and also updates balance
 according to the category passenger
 belongs to.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

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

    /**
     *   1. Get the list of destinations from travel package.
     *   2. Use the factory class method BalanceUpdateFactory
     *   3. This method will give the correct object based on passenger category.
     *   4. Browse through list of destinations and activities.
     *   5. After the activity name matches check if capacity is 0 or not.
     *   6. If it is 0 then return NoVacancyException.
     *   7. Else add the activity to passenger's activityPassengers list.
     *   8. While doing so we must also take care of balance update and price paid.
     *   9. If activity name is not found then throw ActivityUnavailable exception.

     * @param passenger This is the first parameter to passengerSignUp method which is an object of Passenger Class
     * @param travelPackage  This is the second parameter to passengerSignUp method which is of type TravelPackage
     * @param activityName  This is the second parameter to passengerSignUp method which is of type String
     * @return PassengerResult This returns details of the passenger.
     * @exception ActivityUnavailable exception when activity name is not found.
     * @exception NoVacancyInActivity exception when no vacant seats are there in the activity.
     */

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
