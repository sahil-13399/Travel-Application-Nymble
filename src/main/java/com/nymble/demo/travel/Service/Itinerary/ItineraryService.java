package com.nymble.demo.travel.Service.Itinerary;

import com.nymble.demo.travel.Exchanges.PackageList;
import com.nymble.demo.travel.dto.TravelPackage;

public interface ItineraryService {
    PackageList getItinerary(TravelPackage travelPackage);
}
