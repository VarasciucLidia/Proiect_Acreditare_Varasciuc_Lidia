package org.fasttrack.features;

import org.junit.Test;
import org.openqa.selenium.Keys;

public class SearchProduct extends BaseTest {
    @Test
    public void simpleSearchWithOneKeyword() {
        String keywordSearched="Beanie";
        searchSteps.searchWord(keywordSearched + Keys.ENTER);
        searchSteps.verifyProducts(keywordSearched);
        }

        @Test
        public void clickNextPage()
        {
            searchSteps.clickNextPage();
            searchSteps.verifyTheNextPage();
        }

        @Test
        public void navigateToHomePageFromBreadcrumb()
        {
            searchSteps.clickHomePage();
            searchSteps.verifyTheHomePage();
        }

        @Test
        public void sortItems()
        {
            searchSteps.navigateToShopLink();
            searchSteps.clickSelectOrder();
            searchSteps.SortPrices();
        }
    }

