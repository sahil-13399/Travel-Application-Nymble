/**
 <h1>NoVacancyInActivity exception</h1>
 When the capacity in activity is 0
 and a user tries to register for
 an activity then we throw this exception.

 @exception NoVacancyInActivity exception when activity capacity is 0

  * @author  Sahil Samantaray
  * @version 1.0
  * @since   2021-05-01
 */

package com.nymble.demo.travel.Exceptions;

public class NoVacancyInActivity extends Exception{
    public NoVacancyInActivity(String message) {
        super(message);
    }
}
