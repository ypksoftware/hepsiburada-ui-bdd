package com.example.web.pages.SearchPage;

import com.example.web.pageElement.PageElementModel;
import com.example.web.pageElement.WebButton;
import com.example.web.pageElement.WebTextBox;
import com.example.web.pages.WebMasterPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class SearchPage extends WebMasterPage {

    private static final Log log = LogFactory.getLog(SearchPage.class);
    private static SearchPage instance;
    //region Items
    private static WebTextBox txt_SearchInHome = new WebTextBox(PageElementModel.selectorNames.CLASS_NAME, "desktopOldAutosuggestTheme-input");
    private static WebButton btn_SearchHome = new WebButton(PageElementModel.selectorNames.CLASS_NAME, "SearchBoxOld-buttonContainer");
    //endregion
    public static synchronized SearchPage getInstance() {
        if (instance == null)
            instance = new SearchPage();
        return instance;
    }
    //region Scripts Method
    public void isSearchHome() {
        btn_SearchHome.click();
    }
    //endregion
}
