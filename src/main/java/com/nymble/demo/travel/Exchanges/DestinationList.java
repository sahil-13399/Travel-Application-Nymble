package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.Activity;
import lombok.Data;

import java.util.List;

@Data
public class DestinationList {
    private String destinationName;
    private List<Activity> activityList;
}
