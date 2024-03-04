package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FormsScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Form components\")")
    private WebElement formscreen_title;
    private final String formscreen_titletext="Form components";

    public FormsScreen(AndroidDriver driver){
        super(driver);
    }

    public void titleDisplayed(){

        Assert.assertEquals(this.formscreen_title.getText(),formscreen_titletext);


    }
}
