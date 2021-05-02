/**
 <h1>Activity Service</h1>
 Calculates the number of
 activities that still have spaces
 and number of vacant spaces.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Service.Activity;

import com.nymble.demo.travel.Exchanges.ActivityList;
import com.nymble.demo.travel.dto.ActivityPassenger;
import com.nymble.demo.travel.Printer.ActivityPrinter.ActivityPrinter;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityPrinter activityPrinter;

    /**
     *  1. Get the list of destinations from the travel package
     *  2. Declare a LinkedHashMap which will store the Activities for reference
     *  3. Run for loop through destinations and activities.
     *  4. Save activity list in the map with activity name as the key.
     *  5. Get the passenger list from travel package and loop through it
     *  6. Get the activity passenger list and loop through it.
     *  7. Based on activity name get the activity list and reduce the capacity by 1 using reduceVacantSeats()
     *  8. Loop through the linked hash map and save the activities that are not yet 0.
     *  9. Return the list of activities to caller method.
     * @param travelPackage This is the first parameter to getAllActivities method
     *                      which is list of objects of TravelPackage Class
     * @return List<ActivityList> : This is the list of activities along with vacant spaces.
     */

    @Override
    public List<ActivityList> getAllActivities(TravelPackage travelPackage) {
        List<ActivityList> list = new ArrayList<>();
        List<Destination> destinationList = travelPackage.getPackageDestinations();
        LinkedHashMap<String,ActivityList> activityHashMap = new LinkedHashMap<>();
        for (Destination destination : destinationList) {
            List<Activity> activities = destination.getDestinationActivities();
            for (Activity activity : activities) {
                activityHashMap.putIfAbsent(activity.getActivityName(),new ActivityList(activity,activity.getCapacity()));
            }
        }
        List<Passenger> passengerList = travelPackage.getPackagePassenger();
        for(Passenger passenger : passengerList) {
            List<ActivityPassenger> activityPassengerList = passenger.getActivityPassengerList();
            for(ActivityPassenger activityPassenger : activityPassengerList) {
                ActivityList activityList = activityHashMap.get(activityPassenger.getName());
                activityList.reduceVacantSeats();
                activityHashMap.put(activityPassenger.getName(),activityList);
            }
        }
        for (String activityName : activityHashMap.keySet()) {
            ActivityList activityList = activityHashMap.get(activityName);
            if(activityList.getVacantSpaces() != 0) {
                list.add(activityList);
            }
        }
        activityPrinter.printActivities(list);
        return list;
    }
}
