package org.fasttrack.features;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Enclosed.class)
public class CheckoutTest {

    @RunWith(SerenityParameterizedRunner.class)
    public static class ParameterizedCheckoutTest extends BaseTest {
        private String firstNameField;
        private String lastNameField;

        private String addressField;

        private String cityField;
        private String postcodeField;
        private String phoneField;

        private String emailField;

        private String errorMessage;

        public ParameterizedCheckoutTest(String firstNameField, String lastNameField, String addressField, String cityField, String postcodeField, String phoneField, String emailField, String errorMessage) {
            this.firstNameField = firstNameField;
            this.lastNameField = lastNameField;
            this.addressField = addressField;
            this.cityField = cityField;
            this.postcodeField = postcodeField;
            this.phoneField = phoneField;
            this.emailField = emailField;
            this.errorMessage = errorMessage;
        }

        @TestData(columnNames = "FirstName, LastName, Address, City, Postcode, Phone, Email, ErrorMessage")
        public static Collection<Object[]> testData() {
            return Arrays.asList(new Object[][]{{"", "test1", "Zamcei 45", "Cluj", "700000", "0747212223", "test1@gmail.com", "Billing First name is a required field."},
                    {"test1", "", "Zamcei 45", "Cluj", "700000", "0747212223", "test1@gmail.com", "Billing Last name is a required field."},
                    {"test1", "test1", "", "Cluj", "700000", "0747212223", "test1@gmail.com", "Billing Street address is a required field."},
                    {"test1", "test1", "Zamcei 45", "", "700000", "0747212223", "test1@gmail.com", "Billing Town / City is a required field."},
                    {"test1", "test1", "Zamcei 45", "Cluj", "", "0747212223", "test1@gmail.com", "Billing Postcode / ZIP is a required field."},
                    {"test1", "test1", "Zamcei 45", "Cluj", "700000", "", "test1@gmail.com", "Billing Phone is a required field."},
                    {"test1", "test1", "Zamcei 45", "Cluj", "700000", "0747212223", "", "Billing Email address is a required field."}
            });
        }

        @Qualifier
        public String qualifier() {
            return " - " + " FirstName = " + firstNameField + " and " + " LastName = " + lastNameField + " Address = " + addressField + " City = " + cityField + " Postcode = " + postcodeField + " Phone = " + phoneField + " Email = " + emailField + " should display " + errorMessage;
        }

        @Test
        @Title("Checkout with Missing Mandatory Information generates error message")
        public void unsuccessfulCheckoutWithMissingMandatoryInformation() {
            cartSteps.navigateToShopPage();
            cartSteps.clickAddToCart();
            checkoutSteps.navigateToCheckoutPage();
            checkoutSteps.inputFirstName(firstNameField);
            checkoutSteps.inputLastName(lastNameField);
            checkoutSteps.inputAddress(addressField);
            checkoutSteps.inputCity(cityField);
            checkoutSteps.inputPostcode(postcodeField);
            checkoutSteps.inputPhone(phoneField);
            checkoutSteps.inputEmail(emailField);
            checkoutSteps.clickPlaceOrder();
            Serenity.reportThat("Passing invalid information generates error message",
                    () -> assertThat(checkoutSteps.checkoutPageErrorMessage(), is(errorMessage)));
        }
    }

    public static class RegularCheckoutTest extends BaseTest {
        @Test
        public void successfulCheckout() {
            cartSteps.navigateToShopPage();
            cartSteps.clickAddToCart();
            checkoutSteps.navigateToCheckoutPage();
            checkoutSteps.fillInAllFields();
            checkoutSteps.clickPlaceOrder();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            checkoutSteps.checkOrderedReceived();
        }
    }
}
