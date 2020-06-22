package com.happyreturns.test.tests;

import com.happyreturns.test.BaseSeleniumClass;
import com.happyreturns.test.DriverBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *  CHALLENGE :
 *  For our challenge, we need to create a Selenium test that navigates to Google.com
 *  and performs a search for "Happy Returns".
 *
 *  After the results are displayed, assert that The Happy Returns site with address www.happyreturns.com is the first organic result
 *  returned. We are NOT looking for the ad that is returned, but the first organic result.
 *
 *  Notes : Feel free to create classes, rename this class, approach this challenge however you'd like.
 *  Keep it simple or get fancy with it if you have time.
 *
 *  Time: 30 minutes
 *
 **/


public class SeleniumTests extends DriverBase {

    /**
     * Here is an example test method that navigates
     * to Google.com.
     *
     * To run the tests, type the following in the Terminal:
     * mvn clean verify -Dtest=SeleniumTestsIT
     *
     * **/

    @Test
    public void navigateToGoogleTest() throws Exception {
        BaseSeleniumClass baseSeleniumClass = new BaseSeleniumClass();
        Assert.assertTrue(baseSeleniumClass.navigateToGoogle());

    }
}
