package com.nymble.demo.travel.BalanceUpdate;

import com.nymble.demo.travel.dto.Activity;
import com.nymble.demo.travel.dto.Passenger;

public class PremiumUpdate implements BalanceUpdate{
    @Override
    public float updateBalance(Passenger passenger, Activity activity) {
        return 0;
    }
}
