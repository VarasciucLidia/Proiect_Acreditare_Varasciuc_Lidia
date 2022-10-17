package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class LoginSteps extends BaseSteps {

    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToLoginPage() {
        homePage.clickLoginLink();
    }

    @Step
    public void setUserEmail(String email) {
        myaccountPage.setEmailField(email);
    }

    @Step
    public void setPassword(String password) {
        myaccountPage.setPasswordField(password);
    }

    @Step
    public void clickLogin() {
        myaccountPage.clickLoginButton();
    }

    @Step
    public void clickLogout() {
        myAccountResultsPage.clickLogoutButton();
    }

    @Step
    public void verifyTheLogout()
    {
        Assert.assertEquals(true, myaccountPage.getLoginIsDisplayed());
    }

    @Step
    public void verifyUserIsLoggedIn(String userName) {
         Assert.assertEquals("Hello " + userName+" (not "+userName+"? Log out)", myAccountResultsPage.getWelcomeText());
    }

    @Step
    public void verifyUserNotLoggedIn(String userName){
        Assert.assertEquals("ERROR: Invalid username. Lost your password?", myaccountPage.getErrorMessage());
    }

    @Step
    public void verifyUserNotLoggedInAfterPass(String userName){
        Assert.assertEquals("ERROR: The password field is empty.", myaccountPage.getErrorMessage());
    }

    @Step
    public void verifyUserNotLoggedInAfterUser(String userName){
        Assert.assertEquals("Error: Username is required.", myaccountPage.getErrorMessage());
    }

    @Step
    public void doLogin(String email, String pass){
        navigateToLoginPage();
        setUserEmail(email);
        setPassword(pass);
        clickLogin();
    }
}
