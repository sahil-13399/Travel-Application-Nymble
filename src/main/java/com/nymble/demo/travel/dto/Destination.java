package com.nymble.demo.travel.dto;

import lombok.Data;

import java.util.List;

@Data
public class Destination {
    private int destinationId;
    private String destinationName;
    private List<Activity> destinationActivities;
}
