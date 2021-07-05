package com.example.web.pageSteps.LoginSteps;

import com.example.driver.DriverFactory;
import com.example.web.pageElement.PageElementModel;
import com.example.web.pageElement.WebButton;
import com.example.web.pageElement.WebTextBox;
import com.example.web.pages.LoginPage.LoginPage;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginStep {
    private static LoginPage webExamplePage = LoginPage.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(LoginStep.class);

    private LoginPage loginPage = PageFactory.initElements(DriverFactory.getDriver(), LoginPage.class);
    private WebDriver getWebDriverHome() { return (WebDriver) DataStoreFactory.getSpecDataStore().get("webdriver"); }
    //region Items
    private static WebTextBox TXT_SignInEmail = new WebTextBox(PageElementModel.selectorNames.ID, "txtUserName");
    private static WebTextBox TXT_SignInPassword = new WebTextBox(PageElementModel.selectorNames.ID, "txtPassword");
    private static WebButton btn_Login = new WebButton(PageElementModel.selectorNames.ID, "login");
    private static WebButton btn_Account = new WebButton(PageElementModel.selectorNames.ID, "myAccount");
    //endregion
    //region Steps
    @Step("Fill username <username> and password <password>")
    public void isSuccessLogin(String username,String password){
        btn_Account.click();
        btn_Login.click();
        TXT_SignInEmail.waitFor(10);
        TXT_SignInEmail.type(username);
        TXT_SignInPassword.type(password);
    }

    @Step("Click Login Button")
    public void isFillLoginArea(){
        webExamplePage.isSuccessLogin();
    }
    //endregion
}

