package com.nopcommerce.testbase;

import com.nopcommerce.propertyreader.PropertyReader;
import com.nopcommerce.utility.Utility;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase extends Utility {
    String browser = PropertyReader.getInstance().getProperty("browser");

    @BeforeMethod (groups = {"sanity", "regression","smoke"})
    public void setUp(){
        selectBrowser(browser);
    }

    @AfterMethod (groups = {"sanity", "regression","smoke"})
    public void tearDown(){
        closeBrowser();
    }
}
