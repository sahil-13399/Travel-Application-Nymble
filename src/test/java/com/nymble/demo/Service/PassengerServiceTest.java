package com.nymble.demo.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nymble.demo.travel.Exchanges.PassengerList;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.Service.Passenger.PassengerService;
import com.nymble.demo.travel.TravelApplication;
import com.nymble.demo.travel.dto.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {TravelApplication.class})
public class PassengerServiceTest {

    @Autowired
    private PassengerService passengerService;
    private List<TravelPackage> travelPackageList;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws IOException {
        objectMapper = new ObjectMapper();
        travelPackageList = loadTravelPackageDetails(new File("src/test/resources/travel.json"));
    }

    private List<TravelPackage> loadTravelPackageDetails(File file) throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<TravelPackage>>() {
        });
    }

    @Test
    public void printOnePassengerTest() {
        PassengerResult passengerResult = passengerService.getPassenger(travelPackageList.get(0),3);
        assertEquals(0.0,passengerResult.getPassengerActivityList().get(0).getPrice());
    }

    @Test
    public void printAllPassengersTest() {
        PassengerList passengerList = passengerService.getAllPassengers(travelPackageList.get(0));
        assertEquals(1,1);
    }
}
