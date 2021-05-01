package com.nymble.demo.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Activity {
    private int activityId;
    private String activityName;
    private String activityDescription;
    private float activityCost;
    private int capacity;

    public void reduceCapacity() {
        capacity -= 1;
    }
}
