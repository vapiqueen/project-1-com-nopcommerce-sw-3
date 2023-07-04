package homepage;

import org.junit.After;
import utilities.Utility;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    String menu = "computers";

    @Before
    public void setBaseUrl(){

        openBrowser(baseUrl);
    }

    public void selectMenu(String menu){
        //This method should click on the menu whatever name is passed as parameter
       List<WebElement>elements =driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//child::li"));
        for (WebElement element:elements) {
            if (element.getText().equalsIgnoreCase(menu)){
                element.click();
                break;
            }

        }

    }
    @Test
    //use selectMenu method to select the Menu and click on it and verify the page navigation
    public void verifyPageNavigation(){
        selectMenu(menu);
         String expectedMessage = "Computers";
         String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Computers']"));
        Assert.assertEquals("Page not navigated",expectedMessage,actualMessage);

    }
    @After
    public void tearDown(){
        closeBrowser();
    }


}
