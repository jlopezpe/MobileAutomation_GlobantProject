package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;

public class BaseScreen {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility="Home")
    private WebElement home_button;
    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Webview\")")
    private WebElement webview_button;

    @AndroidFindBy(accessibility = "Login")
    private WebElement login_button;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forms\"]")
    private WebElement forms_button;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipe_button;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement drag_button;

    public WebElement getDrag_button() {
        return drag_button;
    }

    public WebElement getSwipe_button() {
        return swipe_button;
    }

    public WebElement getForms_button() {
        return forms_button;
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public WebElement getHome_button() {
        return home_button;
    }

    public WebElement getWebview_button() {
        return webview_button;
    }

    public WebElement getLogin_button() {
        return login_button;
    }

    public BaseScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void clickbutton(WebElement element){

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

    }

    public WebElement waitElementVisibility(AndroidDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(element));

    }
}
