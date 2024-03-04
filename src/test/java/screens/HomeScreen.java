package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomeScreen extends BaseScreen {

    private static final String title_homescreentext="Demo app for the appium-boilerplate";
    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Demo app for the appium-boilerplate\")")
    private WebElement title_homescreen;

    public HomeScreen(AndroidDriver driver){
        super(driver);
    }

    public void titleDisplayed(){

        Assert.assertEquals(this.title_homescreen.getText(),this.title_homescreentext);

    }

}


