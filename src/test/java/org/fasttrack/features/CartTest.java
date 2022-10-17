package org.fasttrack.features;

import org.junit.Test;

public class CartTest extends BaseTest {
    @Test
    public void addASimpleProductToCartAndVerifyThatTheButtonIsDisplayed() {
        cartSteps.navigateToShopPage();
        cartSteps.clickAddToCart();
        cartSteps.checkTheButton();
    }

    @Test
    public void updateProductQuantityFromCartPage()
    {
        cartSteps.navigateToShopPage();
        cartSteps.clickAddToCart();
        cartSteps.clickViewCartButton();
        cartSteps.updateQuantity();
    }

    @Test
    public void removeTheOneProductFromCart() {

        cartSteps.navigateToShopPage();
        cartSteps.clickAddToCart();
        cartSteps.clickViewCartButton();
        cartSteps.clickRemoveButton();
        cartSteps.verifyItemIsRemoved();
    }

    /*@Test
    public void checkThatAProductIsOutOfStock() {
        cartSteps.navigateToShopPage();
        cartSteps.clickReadMoreButton();
    }*/
}
