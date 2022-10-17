package org.fasttrack.features;

import org.junit.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void unsuccessfulRegisterWithTooShortPassword() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.fillInAllFields();
        registerSteps.clearFieldPassword();
        registerSteps.setNewPassword("1");
        registerSteps.verifyUserNotLoggedInAfterPass();
    }

    @Test
    public void unsuccessfulRegisterWithEmptyPassword() {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.fillInAllFields();
        registerSteps.clearFieldPassword();
        registerSteps.setNewPassword("");
        registerSteps.clickRegister();
        registerSteps.verifyUserNotLoggedInAfterPassEmpty();
    }

    @Test
    public void unsuccessfulRegisterWithInvalidEmailAddress()
    {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.fillInAllFields();
        registerSteps.clearFieldEmail();
        registerSteps.setNewEmail("email@test");
        registerSteps.clickRegister();
        registerSteps.verifyUserNotLoggedInAfterEmail();
    }



    @Test
    public void successfulRegister()
    {
        registerSteps.navigateToHomepage();
        registerSteps.navigateToRegisterPage();
        registerSteps.fillInAllFields();
        registerSteps.clickRegister();
        registerSteps.verifyUserIsRegistered();
    }
}
