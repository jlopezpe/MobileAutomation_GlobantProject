package screens;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

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

    @AndroidFindBy(className = "android.widget.Button")
    private WebElement AlertOk_button;
    public WebElement getDrag_button() {
        return drag_button;
    }

    public WebElement getGetAlertOk_button() {
        return AlertOk_button;
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

    public void waitElementClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void swipeLeftInsideElement(WebElement element) {
        // Obtener las dimensiones y la posición del elemento
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        Point elementLocation = element.getLocation();

        // Calcular puntos de inicio y final para el swipe dentro del elemento
        int startX = elementLocation.getX() + (int) (elementWidth * 0.8);
        int endX = elementLocation.getX() + (int) (elementWidth * 0.2);
        int startY = elementLocation.getY() + (elementHeight / 2); // Swipe en el centro vertical del elemento
        int endY = startY;

        // Realizar el swipe
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Usar Arrays.asList() para ejecutar la acción de swipe
        driver.perform(Arrays.asList(swipe));
    }

    public void swipeRightInsideElement(WebElement element) {
        // Obtener las dimensiones y la posición del elemento
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();
        Point elementLocation = element.getLocation();

        // Calcular puntos de inicio y final para el swipe dentro del elemento
        int startX = elementLocation.getX() + (int) (elementWidth * 0.2);
        int endX = elementLocation.getX() + (int) (elementWidth * 0.8);
        int startY = elementLocation.getY() + (elementHeight / 2); // Swipe en el centro vertical del elemento
        int endY = startY;

        // Realizar el swipe
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Usar Arrays.asList() para ejecutar la acción de swipe
        driver.perform(Arrays.asList(swipe));
    }

}
