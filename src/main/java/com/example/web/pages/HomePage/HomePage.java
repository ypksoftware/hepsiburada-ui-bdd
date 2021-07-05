package com.example.web.pages.HomePage;

import com.example.web.pageElement.PageElementModel;
import com.example.web.pageElement.WebButton;
import com.example.web.pages.WebMasterPage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.sql.Time;
import java.util.List;

import static com.example.driver.Driver.webDriver;


public class HomePage extends WebMasterPage {

    private static final Log log = LogFactory.getLog(HomePage.class);
    private static HomePage instance;
    //region ELEMENT ITEMS
    private static WebButton btn_ProductSelect = new WebButton(PageElementModel.selectorNames.XPATH, "/html/body/div[3]/main/div[2]/div/div/div/div/div[2]/section/div[1]/div[3]/div/div/div/div/ul/li[1]/div/a/div[2]/h3/div/p/span");
    private static WebButton btn_ProductAddBasket = new WebButton(PageElementModel.selectorNames.ID, "addToCart");
    private static WebButton btn_Category = new WebButton(PageElementModel.selectorNames.XPATH, "//span[contains(text(),'Kitap, Müzik, Film, Hobi')]");
    private static WebButton btn_DroneProduct = new WebButton(PageElementModel.selectorNames.CLASS_NAME,"moria-ProductCard-bwbOzc gAre sacn6ik245m");
    //endregion
    public static synchronized HomePage getInstance() {
        if (instance == null)
            instance = new HomePage();
        return instance;
    }
    //region Scripts Method
    public void isOpenCategory() {
        WebElement btn_Categorys=webDriver.findElement(By.xpath("//span[contains(text(),'Kitap, Müzik, Film, Hobi')]"));
        Actions  action = new Actions(webDriver);
        action.moveToElement(btn_Categorys).build().perform();
        btn_Category.waitFor(5);
        WebElement btn_CategorysGame=webDriver.findElement(By.xpath("//span[contains(text(),'Uzaktan Kumandalı Araçlar')]"));
        btn_CategorysGame.click();
        btn_Category.waitFor(5);
        WebElement btn_Scroll=webDriver.findElement(By.xpath("//a[@title='Drone Yedek Parçaları']//parent::div/div/div[2]"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", btn_Scroll);
        WebElement btn_CategoryDrone = webDriver.findElement(By.xpath("//a[@title='Drone Yedek Parçaları']//parent::div/div/div[2]"));
        btn_Category.waitFor(5);
        btn_CategoryDrone.click();
        btn_Category.waitFor(5);
    }
    public void isCategoryAddBasket() {
        Actions  action = new Actions(webDriver);
        WebElement btn_DroneProduct = webDriver.findElement(By.id("i0"));
        action.moveToElement(btn_DroneProduct).build().perform();
        btn_Category.waitFor(5);
        WebElement btn_AddBasket = webDriver.findElement(By.xpath("//div[contains(text(),'Sepete Ekle')]"));
        btn_Category.waitFor(5);
        btn_AddBasket.click();
        btn_Category.waitFor(5);
        btn_ProductSelect.waitFor(5);
    }
    //endregion
}
