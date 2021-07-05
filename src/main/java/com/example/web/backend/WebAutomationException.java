package com.example.web.backend;

import com.example.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class WebAutomationException extends RuntimeException{
    public WebAutomationException(String message){
        super(message);
        File scrFile = ((TakesScreenshot) Driver.webDriver).getScreenshotAs(OutputType.FILE);
        String filePath = "screenshots\\screenshot " + WebAutomationContext.getContextValue(ContextKeys.CASENAME) + ".png";
        try {
            FileUtils.copyFile(scrFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String description = "SPRINKLE-UI WEB AUTOMATION FAILED AT STEP: " + WebAutomationContext.getContextValue(ContextKeys.STEPNAME) + " WITH EXCEPTION MESSAGE: " + message;
        WebAutomationContext.addContext(ContextKeys.EXCEPTION, description);
        WebAutomationContext.addContext(ContextKeys.SSLINK, filePath);
        String environment = System.getenv("ENVIRONMENT");
       /* if(false && environment.equalsIgnoreCase("PROD")) {
            if(!JiraUtil.createIssue("RA", WebAutomationContext.getContextValue(ContextKeys.CASENAME), description, filePath, "ringadmin")){
                System.out.println("COULD NOT OPEN JIRA ISSUE");
            }*/
        }

}
