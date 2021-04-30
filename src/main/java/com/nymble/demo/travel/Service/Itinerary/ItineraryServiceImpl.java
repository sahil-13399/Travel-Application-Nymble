package com.nymble.demo.travel.Service.Itinerary;

import com.nymble.demo.travel.Exchanges.PackageList;
import com.nymble.demo.travel.Printer.ItineraryPrinter.ItineraryPrinter;
import com.nymble.demo.travel.dto.TravelPackage;
import org.springframework.beans.factory.annotation.Autowired;

public class ItineraryServiceImpl implements ItineraryService {

    @Autowired
    ItineraryPrinter itineraryPrinter;

    @Override
    public PackageList getItinerary(TravelPackage travelPackage) {
        PackageList packageList = new PackageList(travelPackage.getPackageName(),travelPackage.getPackageDestinations());

        itineraryPrinter.printItinerary(packageList);
        return packageList;
    }
}
