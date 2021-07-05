package com.example.web.pageSteps.HomeSteps;

import com.example.driver.DriverFactory;
import com.example.web.pages.HomePage.HomePage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomeStep {
    private static HomePage webExamplePage = HomePage.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(HomeStep.class);

    private HomePage homePage = PageFactory.initElements(DriverFactory.getDriver(), HomePage.class);
    private WebDriver getWebDriverHome() { return (WebDriver) DataStoreFactory.getSpecDataStore().get("webdriver"); }
    //region Steps
    @Step("I open hepsiburada category")
    public void isOpenCategory(){
        webExamplePage.isOpenCategory();
    }
    @Step("I add the product to the basket")
    public void isCategoryAddBasket(){
        webExamplePage.isCategoryAddBasket();
    }
    //endregion
}

