package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartSteps extends BaseSteps {
    @Step
    public void navigateToShopPage() {
        homePage.clickShopLink();
    }

    @Step
    public void clickAddToCart() {
        shopPage.clickButtonCart();
    }

    @Step
    public void clickViewCartButton()
    {
        shopPage.clickViewCartButton();
    }

    @Step
    public void checkTheButton()
    {
        //shopPage.checkViewCartButton();
        Boolean n = shopPage.getViewCartButton().isDisplayed();
        Assert.assertTrue(n);
    }

    @Step
    public void clearQuantityField()
    {
        cartPage.getQuantityField().clear();
    }

    @Step
    public void setNewQuantityField(String newQty) {
        cartPage.getQuantityField().sendKeys(newQty);
    }

    @Step
    public void updateQuantity()
    {
        String initialTotalText = cartPage.getProductTotalContainer();
        String initialTotalWithoutCurrency = initialTotalText.split(" ")[0];
        double initialTotal = Double.parseDouble(initialTotalWithoutCurrency.replace(",", "."));

        clearQuantityField();
        setNewQuantityField("2");
        cartPage.clickUpdateQuantityButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String updatedTotalText = cartPage.getProductTotalContainer();
        String updatedTotalWithoutCurrency = updatedTotalText.split(" ")[0];
        double updatedTotal = Double.parseDouble(updatedTotalWithoutCurrency.replace(",", "."));

        assertThat("Subtotal not updated.", updatedTotal, equalTo(initialTotal * 2));
    }
    @Step
    public void clickRemoveButton()
    {cartPage.clickRemoveProductButton();
    }

    @Step
    public void clickReadMoreButton()
    {shopPage.getReadMoreButton().click();
    }

    @Step
    public void verifyItemIsRemoved(){
        Assert.assertEquals("Your cart is currently empty.", cartPage.getErrorMessage());
    }
}