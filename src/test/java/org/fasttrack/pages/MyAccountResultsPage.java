package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAccountResultsPage extends PageObject {
    @FindBy(linkText = "Logout")
    private WebElementFacade logoutButton;

    @FindBy(css = ".woocommerce-MyAccount-content p:first-child")
    private WebElementFacade welcomeTextElement;

    public String getWelcomeText() {
        return welcomeTextElement.getText();
    }

    public void clickLogoutButton() {
        clickOn(logoutButton);
    }
}
