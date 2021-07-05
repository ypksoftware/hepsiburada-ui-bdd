package com.example.driver;

import io.github.bonigarcia.wdm.ChromeDriverManager;
//import io.github.bonigarcia.wdm.FirefoxDriverManager;
//import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    // Get a new WebDriver Instance.
    // There are various implementations for this depending on browser. The required browser can be set as an environment variable.
    // Refer http://getgauge.io/documentation/user/current/managing_environments/README.html
    public static WebDriver getDriver() {

        String browser = System.getenv("BROWSER");
         if (browser == null) {
            FirefoxDriverManager.getInstance().setup();
            return new FirefoxDriver();
        }
        switch (browser)
        {
            default:
                FirefoxDriverManager.getInstance().setup();
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--allow-running-insecure-content");
                FirefoxDriver firefoxDriver = new FirefoxDriver(options);
                return firefoxDriver;
        }
       /*
        switch (browser) {
            case "IE":
                InternetExplorerDriverManager.getInstance().setup();
                return new InternetExplorerDriver();
            case "FIREFOX":
                FirefoxDriverManager.getInstance().setup();
                return new FirefoxDriver();
            case "CHROME":
            default:
	            ChromeDriverManager.getInstance().setup();
	
	            ChromeOptions options = new ChromeOptions();
	            if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
	                options.addArguments("--headless");
	                options.addArguments("--disable-gpu");
	            }
	
	            return new ChromeDriver(options);
        }*/

        /*
         * Note: this is using the webdrivermanager to download the latest ChromeDriver
         * Could just statically cache the binaries if don't have internet access...
         */


       /* FirefoxOptions options = new FirefoxOptions();
        if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
        }

        return new FirefoxDriver(options);*/
    }
}
