package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.SwipeScreen;

public class SwipeCardsTest extends BaseTest{

    @BeforeMethod
    public void goingTo_SwipeScreen(){
        HomeScreen homescreen= getHomescreen();
        homescreen.titleDisplayed();
        homescreen.clickbutton(homescreen.getSwipe_button());
    }

    @Test
    public void SwipeCards() throws InterruptedException {

        SwipeScreen swipescreen= getSwipeScreen();
        swipescreen.titleDisplayed();
        swipescreen.swipeCardLeft();
        //swipescreen.swipeRight();
        //Assert.assertTrue((swipescreen.getCardSize()[0].height< swipescreen.getCardSize()[1].height));
        //Assert.assertTrue((swipescreen.getDotSize()[0].height< swipescreen.getDotSize()[0].height));


    }
}
