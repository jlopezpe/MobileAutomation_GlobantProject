package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

//import static jdk.internal.agent.Agent.getText;

public class LoginScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Login / Sign up Form\")")
    private WebElement loginscreen_title;
    private String titletext_loginscreen="Login / Sign up Form";

    public WebElement getLoginscreen_title() {
        return loginscreen_title;
    }

    public LoginScreen(AndroidDriver driver){
        super(driver);
    }

    public void titleDisplayed(){
        Assert.assertEquals(this.loginscreen_title.getText(),titletext_loginscreen);
    }
}
