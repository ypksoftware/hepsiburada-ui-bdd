package com.example.web.pages.LoginPage;

import com.example.web.pageElement.PageElementModel;
import com.example.web.pageElement.WebButton;
import com.example.web.pageElement.WebTextBox;
import com.example.web.pages.WebMasterPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LoginPage extends WebMasterPage {

    private static final Log log = LogFactory.getLog(LoginPage.class);
    private static LoginPage instance;
    //region Items
    private static WebButton BTN_popUpHome = new WebButton(PageElementModel.selectorNames.CLASS_NAME, "seg-popup-close");
    private static WebButton BTN_signIn = new WebButton(PageElementModel.selectorNames.CLASS_NAME, "btnSignIn");
    private static WebTextBox TXT_SignInEmail = new WebTextBox(PageElementModel.selectorNames.ID, "txtUserName");
    private static WebButton BTN_signInBtnLogin = new WebButton(PageElementModel.selectorNames.ID, "btnLogin");
    //endregion
    public static synchronized LoginPage getInstance() {
        if (instance == null)
            instance = new LoginPage();
        return instance;
    }
    //region Scripts Method
    public void isSuccessHome() {
        BTN_popUpHome.waitFor(1500);
    }
    public void isSuccessLogin() {
        BTN_signInBtnLogin.click();
        BTN_signInBtnLogin.waitFor(10);
    }
    public void isFillLoginArea() {
        BTN_popUpHome.waitFor(2);
        BTN_popUpHome.click();
        BTN_signIn.waitFor(2);
        BTN_signIn.click();
        BTN_signIn.waitFor(2);
        TXT_SignInEmail.type("denemeuser");
    }
    public void isSignIn() {
        BTN_signIn.click();
    }
    //endregion
}
