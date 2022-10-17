package org.fasttrack.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.steps.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class BaseTest {

    @Managed(uniqueSession = true)
    protected static WebDriver driver;

    @Steps
    protected LoginSteps loginSteps;

    @Steps
    protected RegisterSteps registerSteps;

    @Steps
    protected SearchSteps searchSteps;

    @Steps
    protected CartSteps cartSteps;

    @Steps
    protected CheckoutSteps checkoutSteps;

    @Before
    public void init(){
        driver.manage().window().maximize();
        driver.get("http://qa4.fasttrackit.org:8008/");
    }
}
