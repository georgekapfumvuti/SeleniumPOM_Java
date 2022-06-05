package com.selenium.shopinglist;

import com.selenium.Hooks;
import com.selenium.pageobject.DocumentPage;
import com.selenium.pageobject.LandingPage;
import com.selenium.util.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SL0007 extends Hooks {

    public void check_shopping_list_item_isSelected() {
        DocumentPage documentPage = new DocumentPage();
        LandingPage landingPage = new LandingPage();
        landingPage.clickCreateBtn();
        landingPage.enterTextInInputFieldAndSubmit(Utils.generatingRandomAlphabeticString(), 3000);
        Assert.assertEquals(documentPage.isChecked(1,"unchecked",3000), true);
        documentPage.clickOnItem(1,3000);
        Assert.assertEquals(documentPage.isChecked(1,"checked",3000), true);
    }
}
