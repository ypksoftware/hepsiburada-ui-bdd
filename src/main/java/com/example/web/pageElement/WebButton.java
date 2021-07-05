package com.example.web.pageElement;

import com.example.web.backend.WebAutomationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebButton extends PageElementModel{
    private static final Log log = LogFactory.getLog(WebButton.class);
    public WebButton(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public void click(){
        log.info("ABOUT TO CLICK BUTTON " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebAutomationException(error);
        }
        try {
            we.click();
        } catch (Exception e) {
            String error = "COULD NOT CLICK BUTTON: " + getLoggingName();
            log.error(error);
            throw new WebAutomationException(error);
        }
    }

    public void waitUntilVisibleAndClick(int... timeOut){
        log.info("WAITING FOR CLICK BUTTON " + getLoggingName());
        waitUntilVisible(timeOut);
        click();
    }

    public void clickAndWait(int... timeOut){
        int timeOutI = 5;
        if (timeOut.length != 0){
            timeOutI = timeOut[0];
        }
        click();
        log.info("WAITING AFTER CLICK BUTTON " + getLoggingName() + " WAIT TIME IS: " + timeOutI);
        try {
            Thread.sleep(timeOutI * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
