package org.fasttrack.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa4.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(id = "menu-item-122")
    private WebElementFacade loginLink;

    @FindBy(css=".header-search-button")
    private WebElementFacade searchLink;

    @FindBy(css=".search-field")
    private WebElementFacade searchField;

    @FindBy(id="menu-item-123")
    private WebElementFacade shopLink;

    @FindBy(id="menu-item-125")
    private WebElementFacade checkoutLink;

    @FindBy(css=".archive-top-big-title")
    private WebElementFacade titleHome;

    public String getTitleHomePage(){
        return titleHome.getText();
    }

    public void clickLoginLink() {
        clickOn(loginLink);
    }

    public void clickSearchLink() {
        clickOn(searchLink);
    }

    public void clickShopLink() { clickOn(shopLink);}

    public void clickCheckoutLink() { clickOn(checkoutLink);}

    public void setSearchField(String keyword)
    {
        typeInto(searchField,keyword);
    }
}
