package com.selenium;

import com.selenium.util.BaseUtil;
import com.selenium.util.Utils;
import com.selenium.util.WebDriverManager;
import org.junit.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class Hooks extends BaseUtil {


    @BeforeClass
    public void initializingDriver() {
        System.out.println("Before");
        driver = getDriver();
        driver.get(Utils.get_element_from_properties_file("baseUrl", "global"));
    }

    @AfterClass
    public void destroyingDriver() {
        System.out.println("After");
        driver.quit();
    }

}
