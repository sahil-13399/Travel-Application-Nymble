package com.nymble.demo.travel.Service.Itinerary;

import com.nymble.demo.travel.Exchanges.PackageList;
import com.nymble.demo.travel.dto.TravelPackage;

public class ItineraryServiceImpl implements ItineraryService {
    @Override
    public PackageList getItinerary(TravelPackage travelPackage) {
        PackageList packageList = new PackageList(travelPackage.getPackageName(),travelPackage.getPackageDestinations());

        return packageList;
    }
}
