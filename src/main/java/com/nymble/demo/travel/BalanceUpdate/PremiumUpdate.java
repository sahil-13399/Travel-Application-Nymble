/**
 <h1>Premium balance Update</h1>
 Premium users do not need to pay for any activity.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */
package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public class PremiumUpdate implements BalanceUpdate{

    /**
     *   Returns 0 as premium users
     *   don't need to pay for activity.
     * @param passenger This is the first paramter to updateBalance method which is an object of Passenger Class
     * @param activity  This is the second paramter to updateBalance method which is an object of Activity Class
     * @return float This returns cost paid for activity. Which is zero in this case
     */

    @Override
    public float updateBalance(Passenger passenger, Activity activity) {
        return 0;
    }
}
