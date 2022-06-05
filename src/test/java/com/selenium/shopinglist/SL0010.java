package com.selenium.shopinglist;

import com.selenium.Hooks;
import com.selenium.pageobject.DocumentPage;
import com.selenium.pageobject.LandingPage;
import com.selenium.util.Utils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SL0010 extends Hooks {

    public void delete_unchecked_item_in_list() {
        DocumentPage documentPage = new DocumentPage();
        LandingPage landingPage = new LandingPage();
        landingPage.clickCreateBtn();
        landingPage.enterTextInInputFieldAndSubmit(Utils.generatingRandomAlphabeticString(), 3000);
        Assert.assertEquals(documentPage.getTotalItems(3000), 7);
        documentPage.deleteItemByIndex(1);
        Assert.assertEquals(documentPage.getTotalItems(3000), 6);
    }
}
