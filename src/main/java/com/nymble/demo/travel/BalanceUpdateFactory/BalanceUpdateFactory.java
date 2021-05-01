package com.nymble.demo.travel.BalanceUpdateFactory;

import com.nymble.demo.travel.BalanceUpdate.BalanceUpdate;
import com.nymble.demo.travel.BalanceUpdate.GoldUpdate;
import com.nymble.demo.travel.BalanceUpdate.PremiumUpdate;
import com.nymble.demo.travel.BalanceUpdate.StandardUpdate;
import org.springframework.stereotype.Service;

@Service
public class BalanceUpdateFactory {
    public BalanceUpdate getBalanceUpdateObject(String passengerCategory) {
        if (passengerCategory.equals("standard")) {
            return new StandardUpdate();
        } else if (passengerCategory.equals("gold")) {
            return  new GoldUpdate();
        }

        return new PremiumUpdate();
    }
}
