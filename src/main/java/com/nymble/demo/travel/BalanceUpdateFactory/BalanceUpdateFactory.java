/**
 <h1>Balance Update Factory</h1>
 Creates an object of BalanceUpdate class based
 on the passenger category and returns to caller
 method

 @author  Sahil Samantaray
  * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.travel.BalanceUpdateFactory;

import com.nymble.demo.travel.BalanceUpdate.BalanceUpdate;
import com.nymble.demo.travel.BalanceUpdate.GoldUpdate;
import com.nymble.demo.travel.BalanceUpdate.PremiumUpdate;
import com.nymble.demo.travel.BalanceUpdate.StandardUpdate;
import org.springframework.stereotype.Service;

@Service
public class BalanceUpdateFactory {

    /**
     *   It is a factory method which creates
     *   an object for the caller method and returns it.
     * @param passengerCategory This is the first parameter to getBalanceUpdateObject
     * method which is an object of String Class
     * @return BalanceUpdate This returns an object of Balance update.
     */

    public BalanceUpdate getBalanceUpdateObject(String passengerCategory) {
        if (passengerCategory.equals("standard")) {
            return new StandardUpdate();
        } else if (passengerCategory.equals("gold")) {
            return  new GoldUpdate();
        }

        return new PremiumUpdate();
    }
}
