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

    @AndroidFindBy(xpath = "//android.widget.ScrollView[@content-desc=\"Swipe-screen\"]/android.view.ViewGroup/android.view.ViewGroup[1]")
    private WebElement swipeVerticalzone;

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"You found me!!!\").index(4)")
    private WebElement youFoundme_text;

    private String foundme_textassert="You found me!!!";

    public WebElement getYouFoundme_text() {
        return youFoundme_text;
    }

    public String getFoundme_textassert() {
        return foundme_textassert;
    }

    public WebElement getYouFoundme_drawing() {
        return youFoundme_drawing;
    }

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.ImageView)")
    private  WebElement youFoundme_drawing;





    public WebElement getFullyOpenSource_card() {
        return fullyOpenSource_card;
    }

    public SwipeScreen(AndroidDriver driver){
        super(driver);
    }


    public void titleDisplayed(){

        Assert.assertEquals(this.swipescreen_title.getText(),this.swipescreen_titletext);

    }

    public void FoundMe(){
        waitElementVisibility(driver,getYouFoundme_text());
        Assert.assertEquals(getYouFoundme_text().getText(),getFoundme_textassert());
        waitElementVisibility(driver,getYouFoundme_drawing());
        Assert.assertTrue(getYouFoundme_drawing().isDisplayed());
    }

    public void swipeCardLeft(){

        Assert.assertTrue(getFullyOpenSource_card().isDisplayed());
        swipeLeftInsideElement(this.fullyOpenSource_card);
        // use this method because isDisplayed() method was always true even if the card was swipped
        isElementNotOnScreen(getFullyOpenSource_card());
        Assert.assertFalse(isElementNotOnScreen(this.fullyOpenSource_card));
    }

    public void swipeRight(){
        waitElementVisibility(driver,this.greatCommunity_card);
        waitElementClickable(this.greatCommunity_card);
        swipeRightInsideElement(this.greatCommunity_card);
        // use this method because isDisplayed() method was always true even if the card was swipped
        isElementNotOnScreen(getGreatCommunity_card());
        Assert.assertFalse(isElementNotOnScreen(this.greatCommunity_card));
    }

    public void swipeUp(){
        //waitElementVisibility(driver,this.swipeVerticalzone);
        //waitElementClickable(this.swipeVerticalzone);
        swipeUpInsideElement(this.swipeVerticalzone);

    }



}
