package com.selenium.util;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

;

public class WebDriverManager{

//  private static long timeout;
//  private static boolean headless;
//
//  static {
//    headless = Boolean.parseBoolean(Utils.get_element_from_properties_file("chrome.driver.headless","global"));
////    timeout = Long.parseLong(PropertyUtil.getApplicationProperty("implicit.timeout.seconds"));
//  }
//


  public WebDriver getDriver() {

    // setup the chromedriver using WebDriverManager
    io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();

    ChromeOptions options = new ChromeOptions();
    options.setPageLoadStrategy(PageLoadStrategy.EAGER);
    options.setPageLoadTimeout(Duration.ofMinutes(1L));

    // Create driver object for Chrome
    WebDriver driver = new ChromeDriver(options);
    driver.manage().window().maximize();
    return driver;
  }

}
