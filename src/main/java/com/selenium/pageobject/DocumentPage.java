package com.selenium.pageobject;

import com.selenium.util.BaseUtil;
import com.selenium.util.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DocumentPage extends BaseUtil {

    public DocumentPage() {
        PageFactory.initElements(driver, this);
    }

    String totalItem = "(//li[@role='button'])";

    @FindBy(how = How.CSS, using = "form > input:nth-child(1)")
    WebElement addItemInput;

    @FindBy(how = How.CSS, using = "form > ._2abd6af1")
    WebElement addItemBtn;

    public int getTotalItems(int millisecond) {
        Utils.waitUntil(millisecond);
        List<WebElement> items = driver.findElements(By.xpath(totalItem));
        return  items.size();
    }

    public void enterTextInInputFieldAndAdd(String text,int millisecond) {
        Utils.waitUntil(millisecond);
        addItemInput.sendKeys(text);
        addItemBtn.click();
    }

    public String getItemByIndex(int index){
        return "li:nth-child("+index+")";
    }

    public String getItemToDeleteByIndex(int index){
        return "li:nth-child("+index+") > .delete";
    }

    public void deleteItemByIndex(int index){
        driver.findElement(By.cssSelector(this.getItemToDeleteByIndex(index))).click();
    }

    public boolean isChecked(int index,String require,int millisecond){
        Utils.waitUntil(millisecond);
        boolean value;
        if(require == "checked") value = driver.findElement(By.cssSelector("li:nth-child("+1+") [data-bought=\"true\"]")).isDisplayed();
        else {
            value = driver.findElement(By.cssSelector("li:nth-child(" + 1 + ") [data-bought=\"false\"]")).isDisplayed();
        }
        return value;
    }

    public void clickOnItem(int index,int millisecond){
        Utils.waitUntil(millisecond);
        driver.findElement(By.cssSelector(this.getItemByIndex(index))).click();
    }
}
