/**
  <h1>Gold balance Update</h1>
  Updates the balance for the gold
  passenger category. The gold users
  get 10% discount.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */
package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.Exceptions.BalanceInsufficient;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public class GoldUpdate implements BalanceUpdate{

    /**
     *   Updates the balance for the gold
     *   passenger category. The gold users
     *   get 10% discount.
     * @param passenger This is the first paramter to updateBalance method which is an object of Passenger Class
     * @param activity  This is the second paramter to updateBalance method which is an object of Activity Class
     * @return float This returns cost paid for activity.
     * @exception BalanceInsufficient exception on insufficient balance
     */

    @Override
    public float updateBalance(Passenger passenger, Activity activity) throws BalanceInsufficient {
        float cost = (float) (0.9 * activity.getActivityCost());
        float balance = passenger.getBalance();
        if(cost > balance) {
            throw new BalanceInsufficient("Insufficient balance to process");
        }
        balance -= cost;
        passenger.setBalance(balance);
        return cost;
    }
}
