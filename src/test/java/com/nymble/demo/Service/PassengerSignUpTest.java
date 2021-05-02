/**
 <h1>Passenger SignUp Service Test</h1>
 Verify if a passenger can signUp for an
 activity or not. Also check if the balance
 is being correctly updated and exception
 is being thrown.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nymble.demo.travel.Exceptions.ActivityUnavailable;
import com.nymble.demo.travel.Exchanges.PassengerResult;
import com.nymble.demo.travel.Service.Passenger.PassengerService;
import com.nymble.demo.travel.Service.Passenger.PassengerSignUpService;
import com.nymble.demo.travel.TravelApplication;
import com.nymble.demo.travel.dto.Passenger;
import com.nymble.demo.travel.dto.TravelPackage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = {TravelApplication.class})
public class PassengerSignUpTest {

    @Autowired
    private PassengerService passengerService;
    @Autowired
    private PassengerSignUpService passengerSignUpService;
    private List<TravelPackage> travelPackageList;
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() throws IOException{
        objectMapper = new ObjectMapper();
        travelPackageList = loadTravelPackageDetails(new File("src/test/resources/travel.json"));
    }

    private List<TravelPackage> loadTravelPackageDetails(File file) throws IOException {
        return objectMapper.readValue(file, new TypeReference<List<TravelPackage>>() {
        });
    }

    /**
     * // CHECK IF ACTIVITY GETS ADDED WHEN USER SIGNS UP
     *   1. After running the test, the method annotated with @BeforeEach runs.
     *   2. The setUp method uses Jackson ObjectMapper to read JSON values and map it to TravelPackage.
     *   3. Choose the first object in TravelPackage list.
     *   4. Then choose the first passenger from passenger list in Travel Package
     *   5. Create a string with activity name you want to sign up for
     *   6. Call the method passengerSignUp with appropriate arguments
     *   7. Call the method getPassenger to print the results and get the passenger details
     *   7. Verify the results using assertEquals method
     *
     * @exception ActivityUnavailable : thrown when Activity is not present
     */

    @Test
    public void signUpServiceStandardTest() throws ActivityUnavailable {
        TravelPackage travelPackage = travelPackageList.get(0);
        Passenger passenger = travelPackage.getPackagePassenger().get(0);
        String activityName = "Day tour at Bali";
        passengerSignUpService.passengerSignUp(passenger,travelPackage,activityName);
        PassengerResult passengerResult = passengerService.getPassenger(travelPackage,1);
        assertEquals(3 ,passengerResult.getPassengerActivityList().size());
    }

    /**
     * //CHECK IF GOLD MEMBERS GET A 10% DISCOUNT
     *   1. After running the test, the method annotated with @BeforeEach runs.
     *   2. The setUp method uses Jackson ObjectMapper to read JSON values and map it to TravelPackage.
     *   3. Choose the first object in TravelPackage list.
     *   4. Then choose the first passenger from passenger list in Travel Package
     *   5. Create a string with activity name you want to sign up for
     *   6. Call the method passengerSignUp with appropriate arguments
     *   7. Call the method getPassenger to print the results and get the passenger details
     *   7. Verify the results using assertEquals method, which in this case Gold members
     *      should get 10% discount
     *
     * @exception ActivityUnavailable : thrown when Activity is not present
     */

    @Test
    public void signUpServiceGoldTest() throws ActivityUnavailable {
        TravelPackage travelPackage = travelPackageList.get(0);
        Passenger passenger = travelPackage.getPackagePassenger().get(1);
        String activityName = "Day tour at Bali";
        passengerSignUpService.passengerSignUp(passenger,travelPackage,activityName);
        PassengerResult passengerResult = passengerService.getPassenger(travelPackage,2);
        assertEquals(17.99 ,passengerResult.getPassengerActivityList().get(2).getPrice(),0.01);
    }

    /**
     * // CHECK IF INCORRECT ACTIVITY NAME THROWS AN EXCEPTION
     *   1. After running the test, the method annotated with @BeforeEach runs.
     *   2. The setUp method uses Jackson ObjectMapper to read JSON values and map it to TravelPackage.
     *   3. Choose the first object in TravelPackage list.
     *   4. Then choose the first passenger from passenger list in Travel Package
     *   5. Create a string with activity name you want to sign up for
     *   6. Call the method passengerSignUp with appropriate arguments
     *   7. Verify using assertThrows whether it throws an exception when activity name is not found or not
     *
     * @exception ActivityUnavailable : thrown when Activity is not present
     */

    @Test
    public void signUpServiceExceptionTest() throws ActivityUnavailable {
        TravelPackage travelPackage = travelPackageList.get(0);
        Passenger passenger = travelPackage.getPackagePassenger().get(1);
        String activityName = "Night tour Chennai";
        Exception e = assertThrows(ActivityUnavailable.class,() -> passengerSignUpService.passengerSignUp(passenger,travelPackage,activityName));
        System.out.println(e.getMessage());
    }

}
