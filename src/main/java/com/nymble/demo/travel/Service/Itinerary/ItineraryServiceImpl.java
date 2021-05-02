/**
 <h1>Itinerary Service</h1>
 Generates the itinerary list of
 travel package including destinations
 and the activities in it.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Service.Itinerary;

import com.nymble.demo.travel.Exchanges.PackageList;
import com.nymble.demo.travel.Printer.ItineraryPrinter.ItineraryPrinter;
import com.nymble.demo.travel.dto.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItineraryServiceImpl implements ItineraryService {

    @Autowired
    ItineraryPrinter itineraryPrinter;

    /**
     *   1. Create an object of Package List.
     *   2. This package list object contains travel package details.
     *   3. Print the details using printItinerary method.
     *   4. Return the packageList to caller method.
     * @param travelPackage This is the first parameter to getItinerary method which is an object of TravelPackage Class
     * @return float This returns cost paid for activity.
     */

    @Override
    public PackageList getItinerary(TravelPackage travelPackage) {
        PackageList packageList = new PackageList(travelPackage.getPackageName(),travelPackage.getPackageDestinations());

        itineraryPrinter.printItinerary(packageList);
        return packageList;
    }
}
