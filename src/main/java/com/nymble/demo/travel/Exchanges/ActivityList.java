/**
 <h1>ActivityList Class</h1>
 Contains the variables and
 methods of ActivityList class

 @param activity : type Activity
 @param vacantSpaces : type int

  * @author  Sahil Samantaray
  * @version 1.0
  * @since   2021-05-01
 */
package com.nymble.demo.travel.Exchanges;

import com.nymble.demo.travel.dto.Activity;
import lombok.Data;
import lombok.NonNull;

@Data
public class ActivityList {
    @NonNull
    private Activity activity;
    @NonNull
    private int vacantSpaces;

    /**
     * Reduces vacant seats of the activity list by 1
     * @return void
     */
    public void reduceVacantSeats() {
        if(vacantSpaces != 0) {
            vacantSpaces -= 1;
        }
    }
}
