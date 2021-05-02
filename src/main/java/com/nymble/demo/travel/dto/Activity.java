/**
 <h1>Activity Class</h1>
 Contains the variables and
 methods of Activity class

 @param activityId : type int
 @param activityName : type String
 @param activityDescription : type String
 @param activityCost : type float

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */
package com.nymble.demo.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    private int activityId;
    private String activityName;
    private String activityDescription;
    private float activityCost;
    private int capacity;

    /**
     * Reduces capacity of the activity by 1
     * @return void
     */
    public void reduceCapacity() {
        capacity -= 1;
    }
}
