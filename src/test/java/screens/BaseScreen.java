package screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import static tests.BaseTest.driver;

public class BaseScreen {

    protected AndroidDriver driver;

    public BaseScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
}
