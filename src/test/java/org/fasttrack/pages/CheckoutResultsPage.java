package org.fasttrack.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutResultsPage extends PageObject {
    @FindBy(css=".woocommerce-thankyou-order-received")
    private WebElementFacade orderedMessage;

    public String getOrderedMessage() {
        return orderedMessage.getText();
    }
}
