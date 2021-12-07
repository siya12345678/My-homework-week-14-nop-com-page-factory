package com.nopcommerce.pages;

import com.nopcommerce.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterPage extends Utility {
    HomePage homePage = new HomePage();

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(text(),'Register')]")
    WebElement verifyRegisterText;

    @FindBy(id = "FirstName")
    WebElement firstNameField;

    @FindBy(id = "LastName")
    WebElement lastNameField;

    @FindBy(id = "Email")
    WebElement emailIdField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@id='register-button']")
    WebElement clickOnRegisterButton;

    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameText;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueAfterRegisterBtn;

    @FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerText;
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameError;
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameError;
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailError;
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordError;
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement confirmPwError;
    @FindBy(xpath = "//label[normalize-space()='Female']")
    WebElement femaleRB;
    @FindBy(xpath = "//select[@name='DateOfBirthDay']")
    WebElement dayDropdown;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthDropdown;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']")
    WebElement yearDropdown;
    @FindBy(xpath = "//div[@class='result' and contains(normalize-space(),'Your registration completed')]")
    WebElement regCompleted;
    @FindBy(xpath = "//span[@class='male']")
    WebElement maleRadio;

    public void selectGender(String gender) {
        Reporter.log("Select Gender : " + femaleRB.toString() + "<br>" + "Select Gender : " + maleRadio.toString() + "<br>");
        if (gender.equalsIgnoreCase("Female")) {
            clickOnElement(femaleRB);
        } else if (gender.equalsIgnoreCase("male")) {
            clickOnElement(maleRadio);
        } else {
            System.out.println("Entered wrong gender");
        }
    }

    public String verifyRegisterText() {
        Reporter.log("Getting register text : " + verifyRegisterText.toString() + "<br>");
        //CustomListeners.test.log(Status.PASS, "Get welcomeText");
        return getTextFromElement(verifyRegisterText);
    }

    public void enterFirstName(String firstname) {
        Reporter.log("Sending firstname : " + firstname.toString() + "<br>");
        sendTextToElement(firstNameField, firstname);
        //CustomListeners.test.log(Status.PASS, "Enter firstname " + firstname);
    }

    public void enterLastName(String lastname) {
        Reporter.log("Sending last name : " + lastname.toString() + "<br>");
        sendTextToElement(lastNameField, lastname);
        // CustomListeners.test.log(Status.PASS, "Enter lastname " + lastname);
    }

    public void enterRegisterEmailId(String email) {
        Reporter.log("Sending email : " + email.toString() + "<br>");
        sendTextToElement(emailIdField, email);
        // CustomListeners.test.log(Status.PASS, "Enter email id to register " + email);
    }

    public void setPassword(String password) {
        Reporter.log("Sending password : " + password.toString() + "<br>");
        sendTextToElement(passwordField, password);
        // CustomListeners.test.log(Status.PASS, "Enter  password " + password);
    }

    public void setConfirmPassword(String confirmPassword) {
        Reporter.log("Sending confirm pw : " + confirmPassword.toString() + "<br>");
        sendTextToElement(confirmPasswordField, confirmPassword);
        //  CustomListeners.test.log(Status.PASS, "Enter confirm password " + confirmPassword);
    }

    public void clickOnRegisterButtonOnRegisterPage() {
        Reporter.log("clicking on register btn: " + clickOnRegisterButton.toString() + "<br>");
        clickOnElement(clickOnRegisterButton);
        //   CustomListeners.test.log(Status.PASS, "Clicking on Register button ");
    }

    public String verifyFirstNameText() {
        String expectedMessage = "Welcome, Please Sign In";
        String actualMessage = getTextFromElement(firstNameText);
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");
        // CustomListeners.test.log(Status.PASS, "Get first name text ");
        Reporter.log("Getting firstname: " + firstNameText.toString() + "<br>");
        return actualMessage;
    }

    public void clickOnContinueAfterRegistration() {
        Reporter.log("clicking on continue btn: " + continueAfterRegisterBtn.toString() + "<br>");
        clickOnElement(continueAfterRegisterBtn);
        // CustomListeners.test.log(Status.PASS, "Clicking on continue button ");
    }

    public String getRegisterText() {
        Reporter.log("Getting register text " + registerText.toString() + "<br>");
        String message = getTextFromElement(registerText);
        return message;
    }

    public void verifyRegistrationCompletedText() {
        Reporter.log("Getting registration completed text " + regCompleted.toString() + "<br>");
        verifyTestMethod("Your registration completed", regCompleted, "Registration completed message not displayed");
    }
/* I WROTE THIS METHOD AS AN ALTERNATIVE

    public void verifyColorCodeOfFirstNameField() {
        String fNameColorCode = firstNameField.getCssValue("color");
        System.out.println("Color code " + fNameColorCode);
        String expectedColorCode = "rgba(119, 119, 119, 1)";
        Assert.assertEquals(fNameColorCode, expectedColorCode);
    }

    public void verifyColorCodeOfLastNameField() {
        String lNameColorCode = lastNameField.getCssValue("color");
        System.out.println("Color code " + lNameColorCode);
        String expectedColorCode = "rgba(119, 119, 119, 1)";
        Assert.assertEquals(lNameColorCode, expectedColorCode);
    }

    public void verifyColorCodeOfEmailField() {
        String emailColorCode = emailIdField.getCssValue("color");
        System.out.println("Color code " + emailColorCode);
        String expectedColorCode = "rgba(119, 119, 119, 1)";
        Assert.assertEquals(emailColorCode, expectedColorCode);
    }

    public void verifyColorCodeOfPasswordField() {
        String passwordColorCode = passwordField.getCssValue("color");
        System.out.println("Color code " + passwordColorCode);
        String expectedColorCode = "rgba(119, 119, 119, 1)";
        Assert.assertEquals(passwordColorCode, expectedColorCode);
    }

    public void verifyColorCodeOfConfirmPasswordField() {
        String confirmPwColorCode = confirmPasswordField.getCssValue("color");
        System.out.println("Color code " + confirmPwColorCode);
        String expectedColorCode = "rgba(119, 119, 119, 1)";
        Assert.assertEquals(confirmPwColorCode, expectedColorCode);
    }

 */

    public void verifyMandatoryFieldsWithErrorMessageOnRegisterPage() {
        Reporter.log("Verifying first name mandatory  " + firstNameError.toString() + "<br>");
        verifyTestMethod("First name is required.", firstNameError, "First name mandatory error not displayed");
        Reporter.log("Verifying last name mandatory  " + lastNameError.toString() + "<br>");
        verifyTestMethod("Last name is required.", lastNameError, "Last name mandatory error not displayed");
        Reporter.log("Verifying email mandatory  " + emailError.toString() + "<br>");
        verifyTestMethod("Email is required", emailError, "Email mandatory error not displayed");
        Reporter.log("Verifying password mandatory " + passwordError.toString() + "<br>");
        verifyTestMethod("Password is required.", passwordError, "Password mandatory error not displayed");
        Reporter.log("Verifying confirm pw mandatory " + confirmPwError.toString() + "<br>");
        verifyTestMethod("Password is required.", confirmPwError, "Confirm pw mandatory error not displayed");
    }

    public void newUserRegistration() {
        homePage.clickOnRegisterLink();
        selectGender("female");
        Reporter.log("Clicking on Date : " + dayDropdown.toString() + "<br>");
        selectByValueFromDropDown(dayDropdown, "1");
        Reporter.log("Clicking on month : " + monthDropdown.toString() + "<br>");
        selectByValueFromDropDown(monthDropdown, "7");
        Reporter.log("Clicking on year : " + yearDropdown.toString() + "<br>");
        selectByValueFromDropDown(yearDropdown, "1996");
        enterFirstName("James");
        enterLastName("Bonds");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String email = "jamesbond" + timeStamp + "@gmail.com";
        enterRegisterEmailId(email);
        setPassword("JamesBond@123");
        setConfirmPassword("JamesBond@123");
        clickOnRegisterButtonOnRegisterPage();
        verifyRegistrationCompletedText();
    }
}
