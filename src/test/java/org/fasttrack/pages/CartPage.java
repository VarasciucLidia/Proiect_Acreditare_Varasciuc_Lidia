package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CartPage extends PageObject {

    @FindBy(css = ".product-subtotal .woocommerce-Price-amount")
    private WebElementFacade productTotalContainer;

    @FindBy(css = "input[title='Qty']")
    private WebElementFacade quantityField;

    @FindBy(name="update_cart")
    private WebElementFacade updateQuantityButton;

    @FindBy(css = ".remove")
    private WebElementFacade removeProductButton;

    @FindBy(css=".cart-empty")
    private WebElementFacade messageEmptyCart;

    public String getErrorMessage(){
        return messageEmptyCart.getText();
    }

    public void clickRemoveProductButton() {
        clickOn(removeProductButton);
    }

    public void clickUpdateQuantityButton() {
        clickOn(updateQuantityButton);
    }

    public WebElementFacade getQuantityField() {
        return quantityField;
    }

    public String getProductTotalContainer() {
        return productTotalContainer.getText();
    }
}
