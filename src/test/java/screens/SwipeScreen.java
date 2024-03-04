package screens;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SwipeScreen extends BaseScreen{

    @AndroidFindBy(uiAutomator = "UiSelector().className(android.widget.TextView).text(\"Swipe horizontal\")")
    private WebElement swipescreen_title;

    private final String swipescreen_titletext="Swipe horizontal";


    public SwipeScreen(AndroidDriver driver){
        super(driver);
    }


    public void titleDisplayed(){

        Assert.assertEquals(this.swipescreen_title.getText(),this.swipescreen_titletext);

    }
}
