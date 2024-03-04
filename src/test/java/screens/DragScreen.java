package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DragScreen extends BaseScreen{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Drag and Drop\"]")
    private WebElement dragscreen_title;

    private String dragscreen_titletext="Drag and Drop";
    public DragScreen(AndroidDriver driver){

        super(driver);
    }

    public void titleDisplayed(){

        Assert.assertEquals(this.dragscreen_title.getText(),this.dragscreen_titletext);

    }
}
