package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class CheckoutSteps extends BaseSteps {

    @Step
    public void navigateToCheckoutPage() {
        homePage.clickCheckoutLink();
    }

    @Step
    public void fillInAllFields() {
        checkoutPage.getFirstNameField().sendKeys("test1");
        checkoutPage.getLastNameField().sendKeys("test1");
        checkoutPage.getAddressField().sendKeys("Zamcei 45");
        checkoutPage.getCityField().sendKeys("Cluj");
        checkoutPage.getPostcodeField().sendKeys("700000");
        checkoutPage.getPhoneField().sendKeys("0747212223");
        checkoutPage.getEmailField().sendKeys("test1@gmail.com");
    }

    @Step
    public void clickPlaceOrder() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Step("Enter FirstName")
    public void inputFirstName(String firstNameField) {
        checkoutPage.getFirstNameField().sendKeys((firstNameField));
    }

    @Step("Enter LastName")
    public void inputLastName(String lastNameField) {
        checkoutPage.getLastNameField().sendKeys((lastNameField));
    }

    @Step("Enter Address")
    public void inputAddress(String addressField) {
        checkoutPage.getAddressField().sendKeys((addressField));
    }

    @Step("Enter City")
    public void inputCity(String cityField) {
        checkoutPage.getCityField().sendKeys((cityField));
    }

    @Step("Enter Postcode")
    public void inputPostcode(String postcodeField) {
        checkoutPage.getPostcodeField().sendKeys((postcodeField));
    }

    @Step("Enter Phone")
    public void inputPhone(String phoneField) {
        checkoutPage.getPhoneField().sendKeys((phoneField));
    }

    @Step("Enter Email")
    public void inputEmail(String emailField) {
        checkoutPage.getEmailField().sendKeys((emailField));
    }

    @Step("Error Message on checkout")
    public String checkoutPageErrorMessage() {
        return checkoutPage.getErrorMessage().getText();
    }

    @Step
    public void checkOrderedReceived()
    {
        Assert.assertEquals("Thank you. Your order has been received.", checkoutResultsPage.getOrderedMessage());
    }
}
