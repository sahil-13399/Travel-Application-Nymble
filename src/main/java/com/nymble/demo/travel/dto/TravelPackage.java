/**
 <h1>TravelPackage Class</h1>
 Contains the variables and
 methods of TravelPackage class

 @param packageId : type int
 @param packageName : type String
 @param packageCapacity : type int
 @param packageDestinations : type List<Destination>
 @param packagePassenger : type List<Passenger>

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
public class TravelPackage {
    private int packageId;
    private String packageName;
    private int packageCapacity;
    private List<Destination> packageDestinations;
    private List<Passenger> packagePassenger;
}