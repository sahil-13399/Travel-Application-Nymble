package com.nymble.demo.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Destination {
    private int destinationId;
    private String destinationName;
    private List<Activity> destinationActivities;
}
