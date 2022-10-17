package org.fasttrack.steps;

import net.thucydides.core.annotations.Step;
import org.hamcrest.core.StringContains;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchSteps extends BaseSteps {
    @Step
    public void navigateToHomepage() {
        homePage.open();
    }

    @Step
    public void navigateToSearchBar() {
        homePage.clickSearchLink();
    }
    
    @Step
    public void searchWord(String keyword)
    {
        homePage.clickSearchLink();
        homePage.setSearchField(keyword);
    }

    @Step
    public void clickSelectOrder()
    {
        shopPage.clickSelectOrder();
    }

    @Step
    public void verifyProducts(String keyword)
    {
        Assert.assertTrue(shopPage.verifyProduct(keyword));
    }

    @Step
    public void clickNextPage()
    {
        homePage.clickShopLink();
        shopPage.clickNextPage();
    }

    @Step
    public void clickHomePage()
    {
        homePage.clickShopLink();
        shopPage.clickHomePage();
    }

    @Step
    public void navigateToShopLink()
    {
        homePage.clickShopLink();
    }

    @Step
    public void SortPrices()
    {
        String product_name;
        String product_price;
        int int_product_price;
        HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
        for(int i=0;i<shopPage.getListOfProductNames().size();i++) {
            product_name = shopPage.getListOfProductNames().get(i).getText();
            product_price = shopPage.getListOfProductPrices().get(i).getText();
            product_price = product_price.replaceAll("[^0-9]", "");
            int_product_price = Integer.parseInt(product_price);
            map_final_products.put(int_product_price,product_name);
        }

        Set<Integer> allkeys = map_final_products.keySet();
        ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);

        Collections.sort(array_list_values_product_prices);

        int high_price = array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
        int low_price = array_list_values_product_prices.get(0);

        System.out.println("High Product Price is: " + high_price + " Product name is: " + map_final_products.get(high_price));
        System.out.println("Low Product Price is: " + low_price + " Product name is: " + map_final_products.get(low_price));
        assertThat("The names are not equal",
                shopPage.getListOfProductNames().get(0).getText(), is(map_final_products.get(high_price))
        );
    }


    @Step
    public void verifyTheHomePage()
    {
        Assert.assertThat(homePage.getTitleHomePage(), is("BLOG"));
    }

    @Step
    public void verifyTheNextPage()
    {
        Assert.assertThat(shopPage.getBreadCrumbText(), StringContains.containsString("Page 2"));
    }
}
