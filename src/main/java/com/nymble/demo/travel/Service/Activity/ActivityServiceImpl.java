package com.nymble.demo.travel.Service.Activity;

import com.nymble.demo.travel.Exchanges.ActivityList;
import com.nymble.demo.travel.Exchanges.ActivityPassenger;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ActivityServiceImpl implements ActivityService {
    @Override
    public List<ActivityList> getAllActivities(TravelPackage travelPackage) {
        List<ActivityList> list = new ArrayList<>();
        List<Destination> destinationList = travelPackage.getPackageDestinations();
        HashMap<String,ActivityList> activityHashMap = new HashMap<>();
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
            if(activityList.getVacantSpaces() == 0) {
                list.add(activityList);
            }
        }

        return list;
    }
}
