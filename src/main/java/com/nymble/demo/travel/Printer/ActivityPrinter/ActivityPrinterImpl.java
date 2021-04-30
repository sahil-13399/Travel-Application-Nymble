package com.nymble.demo.travel.Printer.ActivityPrinter;

import com.nymble.demo.travel.Exchanges.ActivityList;
import com.nymble.demo.travel.dto.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityPrinterImpl implements ActivityPrinter{
    @Override
    public void printActivities(List<ActivityList> activityLists) {
        for (ActivityList activityList : activityLists) {
            Activity activity = activityList.getActivity();
            System.out.println("Activity Name: "+activity.getActivityName()+"\nActivity Description"
                    +activity.getActivityDescription()+"\nActivity Cost: "+activity.getActivityCost()
            +"\nActivity Capacity "+activity.getCapacity()+"\nRemaining seats"+activityList.getVacantSpaces());
        }
    }
}
