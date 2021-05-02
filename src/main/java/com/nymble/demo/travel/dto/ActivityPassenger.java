/**
 <h1>ActivityPassenger Class</h1>
 Contains the variables and
 methods of ActivityPassenger class

 @param destination : type String
 @param name : type String
 @param price : type float

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
public class ActivityPassenger {
    private String destination;
    private String name;
    private float price;
}
