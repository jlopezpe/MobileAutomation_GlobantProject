package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebviewScreen extends HomeScreen{


    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Next-gen browser and mobile automation test framework for Node.js\"]")
    private WebElement webview_title;
    private final String webview_titleText="Next-gen browser and mobile automation test framework for Node.js";

    public WebviewScreen(AndroidDriver driver){
        super(driver);
    }


    public void titleDisplayed(){
        Assert.assertEquals(this.webview_title.getText(),this.webview_titleText);
    }
}
