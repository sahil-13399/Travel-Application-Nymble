package com.nymble.demo.travel.Service.Activity;

import com.nymble.demo.travel.Exchanges.ActivityList;
import com.nymble.demo.travel.dto.TravelPackage;

import java.util.List;

public interface ActivityService {
    List<ActivityList> getAllActivities(TravelPackage travelPackage);
}
