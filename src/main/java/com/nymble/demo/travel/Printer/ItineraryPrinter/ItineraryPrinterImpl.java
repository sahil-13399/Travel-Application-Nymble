package com.nymble.demo.travel.Printer.ItineraryPrinter;

import com.nymble.demo.travel.Exchanges.PackageList;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryPrinterImpl implements ItineraryPrinter{

    @Override
    public void printItinerary(PackageList packageList) {
        System.out.println("Package Name: "+packageList.getPackageName());
        List<Destination> destinationList = packageList.getDestinationList();
        for(Destination destination : destinationList) {
            System.out.println("Destination Name:== "+ destination.getDestinationName());
            System.out.println("---------------------");
            List<Activity> activities = destination.getDestinationActivities();
            for(Activity activity : activities) {
                System.out.println("Activity Name: "+activity.getActivityName()+"\nActivity Description: "
                        +activity.getActivityDescription()+"\nActivity Cost: "+activity.getActivityCost()
                        +"\nActivity Capacity: "+activity.getCapacity()+"\n");
            }
        }
    }
}
