/**
 <h1>Balance Insufficient exception</h1>
 When the balance is less than cost of
 activity then we throw this exception.

 @exception BalanceInsufficient exception when balance is less than cost

  * @author  Sahil Samantaray
  * @version 1.0
  * @since   2021-05-01
 */
package com.nymble.demo.travel.Exceptions;

public class BalanceInsufficient extends Exception{
    public BalanceInsufficient(String message) {
        super(message);
    }
}
