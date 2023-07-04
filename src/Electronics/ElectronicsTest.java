package Electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setBaseUrl() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        //1.1
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        String actualMessage = "Cell phones";
        WebElement expectMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedMessage1 = expectMessage.getText();
        Assert.assertEquals("Error", actualMessage, expectedMessage1);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']"));
        //2.2
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        //2.3
        String actualMessage = "Cell phones";
        WebElement expectedMessage = driver.findElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        String expectedMessage1 = expectedMessage.getText();
        Assert.assertEquals("Error", actualMessage, expectedMessage1);
        //2.4
        Thread.sleep(2000);
        //clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
        //2.5
        Thread.sleep(2000);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //2.6
        String expectedNokia = "Nokia Lumia 1020";
        String actualNokia = driver.findElement(By.xpath("//body[1]/div[6]/div[3]/div[1]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/div[1]/h1[1]")).getText();
        Assert.assertEquals(expectedNokia, actualNokia);
        //2.7
        String expectedPrice = "$349.00";
        String actualPrice = driver.findElement(By.xpath("//span[normalize-space()='$349.00']")).getText();
        Assert.assertEquals(expectedPrice, actualPrice);

        //2.8
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //2.9
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        //2.10
        String actualNoti = "The product has been added to your shopping cart";
        String expectedNoti = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]")).getText();
        Assert.assertEquals(actualNoti, expectedNoti);

        //2.11
        mouseHoverAndClickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));

        //2.12
        String expectedCartMessage = "Shopping cart";
        String actualCartMessage = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals(expectedCartMessage, actualCartMessage);

        //2.13
        WebElement text = driver.findElement(By.xpath("//input[@class='qty-input']"));
        String expectedText = "2";
        String actualText = text.getAttribute("value");
        Assert.assertEquals(expectedText, actualText);


        //2.14
        String expectedTotalNumber = "$698.00";
        String actualTotalNumber = driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText();
        Assert.assertEquals(expectedTotalNumber, actualTotalNumber);

        //2.15
        selectCheckBox(By.xpath("//input[@id='termsofservice']"));

        //2.16
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17
        String expectedWelcome = "Welcome, Please Sign In!";
        String actualWelcome = getTextFromElement(By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"));
        Assert.assertEquals(expectedWelcome, actualWelcome);

        //2.18
        clickOnElement(By.xpath("//a[normalize-space()='Register']"));

        //2.19
        String expectedRegister = "Register";
        String actualRegister = driver.findElement(By.xpath("//h1[normalize-space()='Register']")).getText();
        Assert.assertEquals(expectedRegister, actualRegister);

        //2.20
        sendTextToElement(By.id("FirstName"), "Aarti");
        sendTextToElement(By.id("LastName"), "Doshi");
        sendTextToElement(By.id("Email"), "hihello123@gmail.com");
        sendTextToElement(By.id("Password"), "fine123");
        sendTextToElement(By.id("ConfirmPassword"), "fine123");

        //2.21
        Thread.sleep(2000);
        clickOnElement(By.id("register-button"));

        //2.22
        String expectedRegistration = "Your registration completed";
        String actualRegistration = driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]")).getText();
        Assert.assertEquals(expectedRegistration, actualRegistration);

        //2.23
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24
        String expectedShopping = "Shopping cart";
        String actualShopping = driver.findElement(By.xpath("//h1[normalize-space()='Shopping cart']")).getText();
        Assert.assertEquals(expectedShopping, actualShopping);


        // 2.24 Click on login
        clickOnElement(By.xpath("//a[normalize-space()='Log in']"));


        // Enter email
        sendTextToElement(By.xpath("//input[@id='Email']"), "iambossy11@gmail.com");
        // password
        sendTextToElement(By.xpath("//input[@id='Password']"), "bossy111");
        // click
        clickOnElement(By.xpath("//button[contains(text(),'Log in')]"));

        // 2.25 click on checkbox “I agree with the terms of service”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='termsofservice']"));


        //2.26Click on “CHECKOUT”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        Thread.sleep(2000);

        selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        Thread.sleep(2000);
        //state
        selectFromDropDownMenu(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Other");
        //city
        sendTextToElement(By.id("BillingNewAddress_City"), "283 High Road");
        //Address
        sendTextToElement(By.id("BillingNewAddress_Address1"), "LeytonStone");
        //Postal code
        sendTextToElement(By.id("BillingNewAddress_ZipPostalCode"), "E11 4HH");
        //Phone number
        sendTextToElement(By.id("BillingNewAddress_PhoneNumber"), "9825868472");


        //2.28 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//input[@id='shippingoption_2']"));

        //2.30 Click on “CONTINUE”
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//input[@id='paymentmethod_1']"));
        Thread.sleep(2000);
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[4]/div[2]/div[1]/button[1]"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectFromDropDownMenu(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Mr Shaikh");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "11111111111111111111");
        selectFromDropDownMenu(By.xpath("//select[@id='ExpireMonth']"), "09");
        selectFromDropDownMenu(By.xpath("//select[@id='ExpireYear']"), "2034");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "007");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        String expectedCard = "Credit Card";
        String actualCard = driver.findElement(By.xpath("//span[contains(text(),'Credit Card')]")).getText();
        Assert.assertEquals(expectedCard, actualCard);

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        String expectedShippingMethod = "2nd Day Air";
        String actualShippingMethod = driver.findElement(By.xpath("//li[@class='shipping-method']/span[@class='value']")).getText();
        Assert.assertEquals(expectedShippingMethod, actualShippingMethod);

        //2.37 Verify Total is “$698.00”
        String expectedTotalPrice = "$698.00";
        String actualTotalPrice = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).getText();
        Assert.assertEquals(expectedTotalPrice, actualTotalPrice);

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        String expectedTest = "Thank you";
        String actualTest = driver.findElement(By.xpath("//h1[text()='Thank you']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //2.40 Verify the message “Your order has been successfully processed!”
        String expectedMsg = "Your order has been successfully processed!";
        String actualMsg = driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']")).getText();
        Assert.assertEquals(expectedMsg, actualMsg);

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));

        //2.42 Verify the text “Welcome to our store”
        String expectedMsg1 = "Welcome to our store";
        String actualMsg1 = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
        Assert.assertEquals(expectedMsg1, actualMsg1);

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44
         String expectedMsg2 = "https://demo.nopcommerce.com/";
         String actualMsg2 = driver.getCurrentUrl();
        Assert.assertEquals(expectedMsg2, actualMsg2);

    }


    @After
    public void tearDown() {
        driver.close();
    }

}


