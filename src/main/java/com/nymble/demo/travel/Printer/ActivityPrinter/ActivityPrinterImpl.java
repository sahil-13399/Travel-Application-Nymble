/**
 <h1>Activity Printer</h1>
 Prints out the available
 activities. Along with the
 remaining seats.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */


package com.nymble.demo.travel.Printer.ActivityPrinter;

import com.nymble.demo.travel.Exchanges.ActivityList;
import com.nymble.demo.travel.dto.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityPrinterImpl implements ActivityPrinter{

    /**
     *  Prints out the available
     *  activities. Along with the
     *  remaining seats.
     * @param activityLists This is the first parameter to printActivities method
     *                      which is list of objects of ActivityList Class
     * @return void
     */

    @Override
    public void printActivities(List<ActivityList> activityLists) {
        for (ActivityList activityList : activityLists) {
            Activity activity = activityList.getActivity();
            System.out.println("Activity Name: "+activity.getActivityName()+"\nActivity Description: "
                    +activity.getActivityDescription()+"\nActivity Cost: "+activity.getActivityCost()
            +"\nActivity Capacity: "+activity.getCapacity()+"\nRemaining seats: "+activityList.getVacantSpaces()+"\n");
        }
    }
}
