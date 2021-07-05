package com.example;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import com.thoughtworks.gauge.screenshot.ICustomScreenshotGrabber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomScreenGrabber implements ICustomScreenshotGrabber{

   private static final Logger logger = LoggerFactory.getLogger(CustomScreenGrabber.class);

    // Return a screenshot byte array
    @Override
    public byte[] takeScreenshot() {
        //Gauge.writeMessage("Custom Screengrabber");
        logger.info("Custom Screengrabber");

        WebDriver driver = (WebDriver) DataStoreFactory.getSpecDataStore().get("webdriver");
        logger.info("got web driver at: " + driver.getCurrentUrl());
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
