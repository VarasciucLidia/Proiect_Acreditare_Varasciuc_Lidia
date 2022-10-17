package org.fasttrack.features;

import org.junit.Test;

public class LoginTest extends BaseTest{


    @Test
    public void loginWithValidCredentialsTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.setUserEmail("admin");
        loginSteps.setPassword("parola11");
        loginSteps.clickLogin();
        loginSteps.verifyUserIsLoggedIn("admin");
    }

    @Test
    public void loginWithInvalidEmail() {
        loginSteps.navigateToLoginPage();
        loginSteps.setUserEmail("1");
        loginSteps.setPassword("1");
        loginSteps.clickLogin();
        loginSteps.verifyUserNotLoggedIn("1");
    }

    @Test
    public void loginWithPasswordEmpty() {
        loginSteps.navigateToLoginPage();
        loginSteps.setUserEmail("admin");
        loginSteps.setPassword("");
        loginSteps.clickLogin();
        loginSteps.verifyUserNotLoggedInAfterPass("admin");
    }

    @Test
    public void loginWithUsernameEmpty() {
        loginSteps.navigateToLoginPage();
        loginSteps.setUserEmail("");
        loginSteps.setPassword("parola11");
        loginSteps.clickLogin();
        loginSteps.verifyUserNotLoggedInAfterUser("");
    }

    @Test
    public void logoutTest()
    {
        loginSteps.navigateToLoginPage();
        loginSteps.setUserEmail("admin");
        loginSteps.setPassword("parola11");
        loginSteps.clickLogin();
        loginSteps.clickLogout();
        loginSteps.verifyTheLogout();

    }


}
