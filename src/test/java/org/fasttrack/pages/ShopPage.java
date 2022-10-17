package org.fasttrack.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShopPage extends PageObject {
    @FindBy(css=".ajax_add_to_cart")
    private WebElementFacade buttonCart;

    @FindBy(css=".wc-forward")
    private WebElementFacade viewCartButton;

    @FindBy(xpath="button[text()='Read more']")
    private WebElementFacade ReadMoreButton;

    @FindBy(css = ".woocommerce-loop-product__title")
    private List<WebElementFacade> listOfProductNames;

    @FindBy(css = ".price .amount")
    private List<WebElementFacade> list_of_products_price;

    @FindBy(css=".orderby")
    private WebElementFacade selectOrder;

    @FindBy(linkText = "→")
    private WebElementFacade nextPage;

    @FindBy(css = ".woocommerce-breadcrumb")
    private WebElementFacade breadcrumbPage;

    @FindBy(linkText = "Home")
    private WebElementFacade homeBreadcrumb;

    public String getBreadCrumbText() {
        return breadcrumbPage.getText();
    }

    public void clickNextPage() {
        clickOn(nextPage);
    }

    public void clickSelectOrder() {
        clickOn(selectOrder);
        Select order=new Select(selectOrder);
        order.selectByValue("price-desc");
    }

    public void clickHomePage() {
        clickOn(homeBreadcrumb);
    }

    public boolean verifyProduct(String keyword) {
        for (WebElementFacade productName : listOfProductNames) {
                  if (productName.getText().equalsIgnoreCase(keyword))
                  {return true;}
        }
        return false;
    }

    public List<WebElementFacade> getListOfProductNames()
    {
        return listOfProductNames;
    }

    public List<WebElementFacade> getListOfProductPrices()
    {
        return list_of_products_price;
    }

    public WebElementFacade getReadMoreButton() {
        return ReadMoreButton;
    }

    public void clickButtonCart() {
        clickOn(buttonCart);
    }

    public void clickViewCartButton() {
        clickOn(viewCartButton);
    }

    public WebElementFacade getViewCartButton() {
        return viewCartButton;
    }
}
