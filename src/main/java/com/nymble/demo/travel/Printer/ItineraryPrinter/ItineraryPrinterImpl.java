/**
 <h1>Itinerary Printer</h1>
 Prints out the travel package
 details. Including passenger
 details.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Printer.ItineraryPrinter;

import com.nymble.demo.travel.Exchanges.PackageList;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Destination;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryPrinterImpl implements ItineraryPrinter{

    /**
     *  Prints out the travel package
     *  details. Including passenger
     *  details.
     * @param packageList This is the first parameter to printItinerary method
     *                      which is an object of PackageList Class
     * @return void
     */

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
