package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.Exceptions.BalanceInsufficient;
import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public class GoldUpdate implements BalanceUpdate{
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
