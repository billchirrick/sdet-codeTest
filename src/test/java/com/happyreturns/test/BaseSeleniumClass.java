package com.happyreturns.test;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class BaseSeleniumClass extends DriverBase {


    /**
     *  CHALLENGE :
     *  For our challenge, we need to create a Selenium test that navigates to Google.com
     *  and performs a search for "Happy Returns".
     *
     *  After the results are displayed, assert that www.happyreturns.com is the first result
     *  returned from Google.
     *
     *  Notes : Feel free to create classes, rename this class, approach this challenge however you'd like.
     *  Keep it simple or get fancy with it if you have time.
     *
     *  Time: 30 minutes
     *
     **/

    public Boolean navigateToGoogle() throws Exception {
        WebDriver driver = getDriver();
        driver.get("https://google.com");
        // send keys "Happy Returns"
        // click search icon
        driver.findElement(By.xpath("//*[text()='Happy Returns']"));
        // validate https://happyreturns.com
        return true;
    }


}
