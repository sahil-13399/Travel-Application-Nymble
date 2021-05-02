/**
 <h1>Activity Service Test</h1>
 Verify if the available activities
 are being printed correctly or not.

 * @author  Sahil Samantaray
 * @version 1.0
 * @since   2021-05-01
 */

package com.nymble.demo.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nymble.demo.travel.Exchanges.ActivityList;
import com.nymble.demo.travel.Service.Activity.ActivityService;
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
public class ActivityServiceTest {

    @Autowired
    private ActivityService activityService;
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
     *   1. After running the test, the method annotated with @BeforeEach runs.
     *   2. The setUp method uses Jackson ObjectMapper to read JSON values and map it to TravelPackage.
     *   3. Choose the first object in TravelPackage list.
     *   4. Then call the method getAllActivities()
     *   5. Verify the results using assertEquals method
     */

    @Test
    public void printAvailableActivitiesTest() {
        TravelPackage travelPackage = travelPackageList.get(0);
        List<ActivityList> activities = activityService.getAllActivities(travelPackage);
        assertEquals(4 ,activities.get(0).getVacantSpaces());
    }
}
