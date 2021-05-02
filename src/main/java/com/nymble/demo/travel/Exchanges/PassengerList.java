/**
 <h1>PackageList Class</h1>
 Contains the variables and
 methods of PackageList class

 @param packageName : type String
 @param packageCapacity : type int
 @param passengerCount : type int
 @param passengerList : type List<Passenger>

  * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.Passenger;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PassengerList {
   private String packageName;
   private int packageCapacity;
   private int passengerCount;
   private List<Passenger> passengerList;
}
