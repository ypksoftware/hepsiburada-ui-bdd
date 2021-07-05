package com.example;

import com.example.driver.DriverFactory;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.AfterSpec;
import com.thoughtworks.gauge.AfterStep;
import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSpec;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.BeforeSuite;
import com.thoughtworks.gauge.ExecutionContext;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutionHooks {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionHooks.class);

    public ExecutionHooks() {
        logger.info("Creating new ExecutionHooks...");
    }

    @BeforeSuite
    public void BeforeSuite() {
        logger.info("In BeforeSuite...");
    }

    @AfterSuite
    public void AfterSuite() {
        logger.info("In AfterSuite...");
    }

    @BeforeSpec
    public void BeforeSpec() {
        logger.info("In BeforeSpec...");

        // store the web driver instance in the Spec data store, to be shared between scenarios in the spec
        DataStoreFactory.getSpecDataStore().put("webdriver", DriverFactory.getDriver());
        logger.info("Created and stored web driver");
    }

    @AfterSpec
    public void AfterSpec() {
        logger.info("In AfterSpec...");

        // shutdown and remove the web driver
        WebDriver webDriver = (WebDriver) DataStoreFactory.getSpecDataStore().get("webdriver");
        if (webDriver != null) {
            webDriver.quit();
            DataStoreFactory.getSpecDataStore().remove("webdriver");
            logger.info("Shutdown and removed web driver");
        }
    }

    @BeforeScenario
    public void BeforeScenario(ExecutionContext context) {
        logger.info("In BeforeScenario...");
        logger.info("About to run {}", context.getCurrentScenario().getName());
    }

    @AfterScenario
    public void AfterScenario(ExecutionContext context) {
        logger.info("In AfterScenario...");
        logger.info("Completed running {}", context.getCurrentScenario().getName());
    }

    @BeforeStep
    public void BeforeStep() {
        logger.info("In BeforeStep...");
    }

    @AfterStep
    public void AfterStep() {
        logger.info("In AfterStep...");
    }
}
