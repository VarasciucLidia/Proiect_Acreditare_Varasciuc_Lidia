package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends PageObject {
    @FindBy(id = "username")
    private WebElementFacade loginEmailField;

    @FindBy(id = "password")
    private WebElementFacade loginPasswordField;

    @FindBy(css = ".woocommerce-Button")
    private WebElementFacade loginButton;

    @FindBy(css = ".woocommerce-error")
    private WebElementFacade errorMessageElement;

    @FindBy(id = "reg_email")
    private WebElementFacade regEmailField;

    @FindBy(id = "reg_password")
    private WebElementFacade regPasswordField;

    @FindBy(name = "register")
    private WebElementFacade registerButton;

    @FindBy(css=".woocommerce-password-strength")
    private WebElementFacade errorPassword;

    @FindBy(css=".woocommerce-error")
    private WebElementFacade errorEmail;

    public String getPassFieldText() {
        return errorPassword.getText();
    }

    public String getEmailFieldText() {
        return errorEmail.getText();
    }

    public WebElement getEmailField() {
        return regEmailField;
    }

    public WebElement getPasswordField() {
        return regPasswordField;
    }

    public void clickRegisterButton() {
        clickOn(registerButton);
    }

    public void setEmailField(String value) {
        typeInto(loginEmailField, value);
    }

    public void setPasswordField(String value) {
        typeInto(loginPasswordField, value);
    }

    public void clickLoginButton() {
        clickOn(loginButton);
    }

    public String getErrorMessage(){
        return errorMessageElement.getText();
    }

    public boolean getLoginIsDisplayed()
    {
        return loginButton.isDisplayed();
    }
}
