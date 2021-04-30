package com.nymble.demo.travel.dto;

import lombok.Data;

@Data
public class Activity {
    private int activityId;
    private String activityName;
    private String activityDescription;
    private float activityCost;
    private int capacity;
}
