package com.selenium.pageobject;

import com.selenium.util.BaseUtil;
import com.selenium.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends BaseUtil {
    public LandingPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = ".createButton > ._2abd6af1")
    WebElement create;

    @FindBy(how = How.CSS, using = "input[type=\"text\"]")
    WebElement input;

    @FindBy(how = How.CSS, using = "._2abd6af1")
    WebElement submit;

    public void clickCreateBtn() {
        create.click();
    }

    public void clickInputField() {
        input.click();
    }

    public void enterTextInInputFieldAndSubmit(String text, int millisecond) {
        Utils.waitUntil(millisecond);
        clickInputField();
        input.sendKeys(text);
        submit.click();
    }


}
