package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(id="billing_first_name")
    private WebElementFacade firstNameField;

    @FindBy(id="billing_last_name")
    private WebElementFacade lastNameField;

    @FindBy(id="billing_address_1")
    private WebElementFacade addressField;

    @FindBy(id="billing_city")
    private WebElementFacade cityField;

    @FindBy(id="billing_postcode")
    private WebElementFacade postcodeField;

    @FindBy(id="billing_phone")
    private WebElementFacade phoneField;

    @FindBy(id="billing_email")
    private WebElementFacade emailField;

    @FindBy(id="place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css=".woocommerce-error")
    private WebElementFacade checkoutError;

    public WebElementFacade getFirstNameField() {
        return firstNameField;
    }

    public WebElementFacade getLastNameField() {
        return lastNameField;
    }

    public WebElementFacade getAddressField() {
        return addressField;
    }

    public WebElementFacade getCityField() {
        return cityField;
    }

    public WebElementFacade getPostcodeField() {
        return postcodeField;
    }

    public WebElementFacade getPhoneField() {
        return phoneField;
    }

    public WebElementFacade getEmailField() {
        return emailField;
    }

    public WebElementFacade getErrorMessage() {
        return checkoutError;
    }

    public void clickPlaceOrderButton() {
        clickOn(placeOrderButton);
    }
}
