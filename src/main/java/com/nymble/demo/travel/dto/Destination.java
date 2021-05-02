/**
 <h1>Destination Class</h1>
 Contains the variables and
 methods of Destination class

 @param destinationId : type int
 @param destinationName : type String
 @param destinationActivities : type List<Activity>

  * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
    private int destinationId;
    private String destinationName;
    private List<Activity> destinationActivities;
}
