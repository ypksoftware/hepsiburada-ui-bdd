package com.example.web.pageElement;

public class WebLabel extends PageElementModel{

    public WebLabel(selectorNames selectorName, String selectorValue) {
        super(selectorName, selectorValue);
    }

    public String getLabelText(){
        return getWebElement().getText();
    }
}
