package com.example.web.pageSteps.ProductSteps;

import com.example.driver.DriverFactory;
import com.example.web.pages.ProductPage.ProductPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductStep {
    private static ProductPage webExamplePage = ProductPage.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(ProductStep.class);

    private ProductPage productPage = PageFactory.initElements(DriverFactory.getDriver(), ProductPage.class);
    private WebDriver getWebDriverHome() { return (WebDriver) DataStoreFactory.getSpecDataStore().get("webdriver"); }
    //region Items
    @Step("I add the selected product to the basket")
    public void isFillLoginArea(){
        webExamplePage.isAddBasket();
    }
    //endregion
}

