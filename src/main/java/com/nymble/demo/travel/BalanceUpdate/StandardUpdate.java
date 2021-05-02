/**
 <h1>Standard balance Update</h1>
 Updates the balance for the standard
 passenger category. The standard users
 get no discount.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.Exceptions.BalanceInsufficient;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public class StandardUpdate implements BalanceUpdate{

    /**
     *   Updates the balance for the standard
     *   passenger category. The standard users
     *   get no discount.
     * @param passenger This is the first parameter to updateBalance method which is an object of Passenger Class
     * @param activity  This is the second parameter to updateBalance method which is an object of Activity Class
     * @return float This returns cost paid for activity.
     * @exception BalanceInsufficient exception on insufficient balance
     */

    @Override
    public float updateBalance(Passenger passenger, Activity activity) throws BalanceInsufficient {
        float cost = activity.getActivityCost();
        float balance = passenger.getBalance();
        if(cost > balance) {
            throw new BalanceInsufficient("Insufficient balance to process");
        }
        balance -= cost;
        passenger.setBalance(balance);
        return cost;

    }
}
