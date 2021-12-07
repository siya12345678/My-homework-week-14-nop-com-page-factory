package com.nopcommerce.testsuite;

import com.nopcommerce.pages.*;
import com.nopcommerce.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class ComputerPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    ComputerPage computerPage;
    BuildYourOwnComputer buildYourOwnComputer;

    @BeforeMethod//(groups = {"smoke", "sanity","regression"})
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        computerPage = new ComputerPage();
        buildYourOwnComputer = new BuildYourOwnComputer();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        homePage.clickOnComputersTab();
        computerPage.verifyComputersText();
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        homePage.mouseHoverAndClickOnDesktopUnderComputers();
        computerPage.verifyDesktopsText();
    }

    @Test(dataProvider = "build your own computer", dataProviderClass = TestData.class, groups = {"sanity", "regression"})
    public void VerifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram, String hdd, String os, String software) {
        verifyUserShouldNavigateToDesktopsPageSuccessfully();
        computerPage.clickOnBuildYourOwnComputer();
        buildYourOwnComputer.setSelectProcessor(processor);
        buildYourOwnComputer.setSelectRam(ram);
        buildYourOwnComputer.clickOnHdd(hdd);
        buildYourOwnComputer.clickOnOS(os);
        buildYourOwnComputer.setSelectSoftware(software);
        buildYourOwnComputer.clickOnAddToCart();
        buildYourOwnComputer.verifyMessageProductsAddedToShoppingCart();
    }


}
