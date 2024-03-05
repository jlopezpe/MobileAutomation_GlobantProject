package screens;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.swing.*;

import java.time.Duration;
import java.util.HashMap;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class SwipeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    private WebElement swipescreen_title;
    private final String swipescreen_titletext="Swipe horizontal";

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@resource-id=\"__CAROUSEL_ITEM_1_READY__\"]")
    private WebElement fullyOpenSource_card;

    public WebElement getGreatCommunity_card() {
        return greatCommunity_card;
    }

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"card\"])[2]")
    private WebElement greatCommunity_card;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup")
    private WebElement dot_fullyOpenSource_card;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"Carousel\"]android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
    private WebElement dot_greatCommunity_card;


    public WebElement getFullyOpenSource_card() {
        return fullyOpenSource_card;
    }

    public SwipeScreen(AndroidDriver driver){
        super(driver);
    }


    public void titleDisplayed(){

        Assert.assertEquals(this.swipescreen_title.getText(),this.swipescreen_titletext);

    }

    public void swipeCardLeft(){

        Assert.assertTrue(getFullyOpenSource_card().isDisplayed());
        swipeLeftInsideElement(this.fullyOpenSource_card);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Espera hasta un máximo de 10 segundos
        //waitElementVisibility(driver,this.getGreatCommunity_card());
        Assert.assertTrue(getGreatCommunity_card().isDisplayed());
        swipeLeftInsideElement(this.fullyOpenSource_card);
        swipeLeftInsideElement(this.fullyOpenSource_card);
        swipeLeftInsideElement(this.fullyOpenSource_card);
        //swipeLeftInsideElement(this.fullyOpenSource_card);
        Assert.assertFalse(getFullyOpenSource_card().isDisplayed());





    }
    

    public void swipeRight(){
        waitElementVisibility(driver,this.greatCommunity_card);
        waitElementClickable(this.greatCommunity_card);
        swipeRightInsideElement(this.greatCommunity_card);
    }



}
