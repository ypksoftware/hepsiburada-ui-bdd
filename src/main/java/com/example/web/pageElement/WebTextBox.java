package com.example.web.pageElement;

import com.example.web.backend.WebAutomationException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class WebTextBox extends PageElementModel{
    private static final Log log = LogFactory.getLog(WebTextBox.class);

    public WebTextBox(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public void type(String inputText){
        log.info("ABOUT TO TYPE TEXTBOX " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebAutomationException(error);
        }
        try {
            we.sendKeys(inputText);
        } catch (Exception e) {
            String error = "COULD NOT TYPE TEXTBOX: " + getLoggingName() + " TEXT IS: " + inputText;
            log.error(error);
            throw new WebAutomationException(error);
        }
    }

    public void waitUntilVisibleAndType(String inputText, int... timeOut){
        log.info("WAITING FOR TEXTBOX: " + getLoggingName());
        waitUntilVisible(timeOut);
        type(inputText);
    }

    public void clearText(){
        log.info("ABOUT TO CLEAR TEXTBOX " + getLoggingName());
        WebElement we = null;
        try {
            we = getWebElement();
        } catch (NoSuchElementException e){
            String error = "ELEMENT NOT FOUND: " + getLoggingName();
            log.error(error);
            throw new WebAutomationException(error);
        }
        we.clear();
    }
}
