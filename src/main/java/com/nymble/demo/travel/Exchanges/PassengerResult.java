/**
 <h1>PassengerResult Class</h1>
 Contains the variables and
 methods of PassengerResult class

 @param passengerName : type String
 @param passengerNumber : type String
 @param balance : type float
 @param passengerActivityList : type List<ActivityPassenger>

  * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.ActivityPassenger;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PassengerResult {

    private String passengerName;
    private String passengerNumber;
    private float balance;
    private List<ActivityPassenger> passengerActivityList;
}
