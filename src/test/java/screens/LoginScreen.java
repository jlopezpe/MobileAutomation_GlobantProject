package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.UUID;

//import static jdk.internal.agent.Agent.getText;

public class LoginScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Login / Sign up Form\")")
    private WebElement loginscreen_title;
    private String titletext_loginscreen="Login / Sign up Form";

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Sign up\")")
    private WebElement SignUp_button;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement email_field;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement password_field;
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement repeatPassword_field;

    private static final String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final SecureRandom random = new SecureRandom();

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-SIGN UP\"]/android.view.ViewGroup")
    private WebElement signingUp_button;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement signed_upAlert;

    private final String alert_message="Signed Up!";

    public WebElement getSigned_upAlert() {
        return signed_upAlert;
    }

    public WebElement getSignUp_button() {
        return SignUp_button;
    }

    public WebElement getLoginscreen_title() {
        return loginscreen_title;
    }

    public LoginScreen(AndroidDriver driver){
        super(driver);
    }

    public void titleDisplayed(){
        Assert.assertEquals(this.loginscreen_title.getText(),titletext_loginscreen);
    }

    public WebElement getSigningUp_button() {
        return signingUp_button;
    }

    public void write_SignUp_info(){

        //using globant brand only for academy goals
        String randomEmail = "MobileTesting+" + UUID.randomUUID().toString().substring(0, 8)+ "@globant.com";
        email_field.sendKeys(randomEmail);

        String password_created= password_generator(10);

        password_field.sendKeys(password_created);

        repeatPassword_field.sendKeys(password_created);

    }

    public static String password_generator(int length) {
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(passwordSet.length());
            password.append(passwordSet.charAt(index));
        }
        return password.toString();
    }

    public void verification_SignUp(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signedUpAlert = wait.until(ExpectedConditions.visibilityOf(this.getSigned_upAlert()));

        Assert.assertEquals(this.getSigned_upAlert().getText(),alert_message);
    }
}
