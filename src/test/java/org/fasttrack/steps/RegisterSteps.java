package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static org.hamcrest.core.StringContains.containsString;

public class RegisterSteps extends BaseSteps {

    public String emailSent = "test" + System.currentTimeMillis();

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToRegisterPage() {
        homePage.clickLoginLink();
    }

    @Step
    public void fillInAllFields() {
        myaccountPage.getEmailField().sendKeys(emailSent+ "@example.com");
        myaccountPage.getPasswordField().sendKeys("Passw0rd12345?!00000");
    }

    @Step
    public void clickRegister() {
        myaccountPage.clickRegisterButton();
    }

    @Step
    public void clearFieldPassword()
    {
        myaccountPage.getPasswordField().clear();
    }

    @Step
    public void setNewPassword(String password) {
        myaccountPage.getPasswordField().sendKeys(password);
    }

    @Step
    public void clearFieldEmail()
    {
        myaccountPage.getEmailField().clear();
    }

    @Step
    public void setNewEmail(String email) {
        myaccountPage.getEmailField().sendKeys(email);
    }

    @Step
    public void verifyUserNotLoggedInAfterPass()
    {
        Assert.assertEquals("Very weak - Please enter a stronger password.", myaccountPage.getPassFieldText());
    }

    @Step
    public void verifyUserNotLoggedInAfterEmail()
    {
        Assert.assertThat(myaccountPage.getEmailFieldText(), containsString("valid"));
    }

    @Step
    public void verifyUserNotLoggedInAfterPassEmpty()
    {
        Assert.assertEquals("Error: Please enter an account password.", myaccountPage.getEmailFieldText());
    }

    @Step
    public void verifyUserIsRegistered() {
        //Assert.assertEquals("Hello admin (not admin? Log out)From your account dashboard you can view your recent orders, manage your shipping and billing addresses and edit your password and account details.", accountPage.getWelcomeText());
        //Assert.assertTrue(accountPage.getWelcomeText().contains("Hello "));
        Assert.assertEquals("Hello " + emailSent+" (not "+emailSent+"? Log out)", myAccountResultsPage.getWelcomeText());
        //assertTrue(driver.findElement(By.tagName("h1")).getText().contains("Welcome"));
    }

  /*  @Step
    public void iGoToTheRegisterPage() {
        //homePage.clickAccountLink();
        homePage.clickRegisterLink();
    }

    @Step
    public void iFillInAllMandatoryFieldsWithValidDataOnTheRegisterPage() {
        registerPage.getEmailField().sendKeys("test" + System.currentTimeMillis() + "@example.com");
        registerPage.getPasswordField().sendKeys("passw0rd123");
    }*/
}
