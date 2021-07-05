package com.example.web.pageSteps.SearchSteps;

import com.example.driver.DriverFactory;
import com.example.web.pageElement.PageElementModel;
import com.example.web.pageElement.WebTextBox;
import com.example.web.pages.SearchPage.SearchPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SearchStep {
    private static SearchPage webExamplePage = SearchPage.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(SearchStep.class);

    private SearchPage searchPage = PageFactory.initElements(DriverFactory.getDriver(), SearchPage.class);
    private WebDriver getWebDriverHome() { return (WebDriver) DataStoreFactory.getSpecDataStore().get("webdriver"); }
    //region Items
    private static WebTextBox txt_SearchInHome = new WebTextBox(PageElementModel.selectorNames.CLASS_NAME, "desktopOldAutosuggestTheme-input");
    //endregion
    //region Steps
    @Step("I search <product> home")
    public void isFillLoginArea(String product){
        txt_SearchInHome.type(product);
        webExamplePage.isSearchHome();
    }
    //endregion
}

