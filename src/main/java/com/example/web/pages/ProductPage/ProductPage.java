package com.example.web.pages.ProductPage;

import com.example.web.pageElement.PageElementModel;
import com.example.web.pageElement.WebButton;
import com.example.web.pages.WebMasterPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductPage extends WebMasterPage {

    private static final Log log = LogFactory.getLog(ProductPage.class);
    private static ProductPage instance;
    //region Items
    private static WebButton btn_ProductSelect = new WebButton(PageElementModel.selectorNames.XPATH, "/html/body/div[3]/main/div[2]/div/div/div/div/div[2]/section/div[1]/div[3]/div/div/div/div/ul/li[1]/div/a/div[2]/h3/div/p/span");
    private static WebButton btn_ProductAddBasket = new WebButton(PageElementModel.selectorNames.ID, "addToCart");
    private static WebButton btn_Home = new WebButton(PageElementModel.selectorNames.CLASS_NAME, "_1ntKM7_0v9t1WleQh1WQmh false");
    //endregion
    public static synchronized ProductPage getInstance() {
        if (instance == null)
            instance = new ProductPage();
        return instance;
    }
    //region Scripts Method
    public void isAddBasket() {
        btn_ProductSelect.click();
        btn_ProductAddBasket.click();
    }
    public void isCategory() {
        btn_Home.waitFor(10);
    }
    public void isCategoryAddBasket() {
        btn_Home.waitFor(10);
    }
    //endregion
}
