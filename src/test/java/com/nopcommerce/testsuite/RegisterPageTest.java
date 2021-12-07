package com.nopcommerce.testsuite;

import com.nopcommerce.pages.HomePage;
import com.nopcommerce.pages.LoginPage;
import com.nopcommerce.pages.RegisterPage;
import com.nopcommerce.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @BeforeMethod//(groups = {"smoke", "sanity", "regression"})
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String expectedMessage = "Register";
        String actualMessage = registerPage.getRegisterText();
        Assert.assertEquals(expectedMessage, actualMessage, "Register text is not displayed");
    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        verifyUserShouldNavigateToRegisterPageSuccessfully();
        registerPage.clickOnRegisterButtonOnRegisterPage();
        registerPage.verifyMandatoryFieldsWithErrorMessageOnRegisterPage();
        /*registerPage.verifyColorCodeOfFirstNameField();
        registerPage.verifyColorCodeOfLastNameField();
        registerPage.verifyColorCodeOfEmailField();
        registerPage.verifyColorCodeOfPasswordField();
        registerPage.verifyColorCodeOfConfirmPasswordField();
         */
    }

    @Test(groups = {"sanity", "regression"})
    public void VerifyThatUserShouldCreateAccountSuccessfully() {
        registerPage.newUserRegistration();
    }

}
