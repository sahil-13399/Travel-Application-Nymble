package com.nymble.demo.travel.Printer.PassengerPrinter;

import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;

public interface PassengerPrinter {
    void passengerPrinter(PassengerResult passengerResult);
    void allPassengersPrinter(PassengerList passengerList);
}
