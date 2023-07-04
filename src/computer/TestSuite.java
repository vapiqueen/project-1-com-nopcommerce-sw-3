package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TestSuite extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";
    String menu = "computers";

    @Before
    public void setBaseUrl() {

        openBrowser(baseUrl);
    }

    @Test
    public void verifyProudctArrangeInAlphabaticalOrder() {
        //1.1 Click on Computer Menu
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //1.2Click On Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));


        //1.3 Select Sort By position "Name: Z to A"
        selectFromDropDownMenu(By.xpath("//select[@id='products-orderby']"), "Name: Z to A");

        //1.4 Verify the Product will arrange in Descending order.
        String expectedMessage = "Name: Z to A";

        String actualMessage = getTextFromElement(By.xpath("//option[contains(text(),'Name: Z to A')]"));
        Assert.assertEquals("Name:Z to A has not been arranged in descending order.", expectedMessage, actualMessage);
    }


    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Click on Computer Menu
        mouseHoverOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //2.2Click On Desktop
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Desktops']"));

        //2.3Select sort By position"Name:A to Z"
        selectFromDropDownMenu(By.xpath("//select[@id='products-orderby']"), "Name: A to Z");
        Thread.sleep(2000);

        //2.4 Click on "Add To Cart"
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/button[1]"));

        //2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        //String acceptedText= driver.findElement(By.xpath("//a[contain(text(),'Build your own computer']")).getText();
        //Assert.assertEquals("Error in opening the page", expectedText,acceptedText);

        //2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        selectFromDropDownMenu(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");

        //2.7.Select "8GB [+$60.00]" using Select class.
        Thread.sleep(2000);
        selectFromDropDownMenu(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        //2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

        //2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

        //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
       // Thread.sleep(2000);
        //clickOnElement(By.id("product_attribute_5_10"));
        Thread.sleep(2000);
        clickOnElement(By.id("product_attribute_5_12"));

        //2.11 Verify the price "$1,475.00"
        Thread.sleep(2000);
        String expectedMessage = "$1,475.00";
        String actualMessage = driver.findElement(By.xpath("//span[@id='price-value-1']")).getText();
        Assert.assertEquals("Total Price is not accuret", expectedMessage, actualMessage);
        // verifyElementMethod("$1475.00",By.xpath("//span[@id='price-value-1']"),"Total Price is not accurat");

        //2.12 Click on "ADD TO CARD" Button.
        Thread.sleep(2000);
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));

        //2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        expectedMessage = "The product has been added to your shopping cart";
        actualMessage = driver.findElement(By.xpath("//body/div[@id='bar-notification']/div[1]")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        //After that close the bar clicking on the cross button
        Thread.sleep(1000);
        clickOnElement(By.xpath("//span[@class='close'"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(2000);
        mouseHoverOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.15 Verify the message "Shopping cart"
        expectedText = "Shopping cart";
        String actualText = driver.findElement(By.xpath("//span[@class='cart-label']")).getText();
        Assert.assertEquals("Shopping cart text is not visible", expectedText, actualText);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        clickOnElement(By.xpath("//button[@id='updatecart']"));

        //2.17 Verify the Total"$2,950.00"
        expectedText = "$2,950.00";
        actualText = driver.findElement(By.xpath("//tbody/tr[1]/td[6]/span[1]")).getText();
        Assert.assertEquals("Inaccurate displayed amount", expectedText, actualText);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//div[@class='terms-of-service']"));

        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In!”
        expectedText = "Welcome, Please Sign In!";
        actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals("Not redirected to Login page", expectedText, actualText);

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[contains(text(),'Checkout as Guest')]"));

        //2.22 Fill the all mandatory field
        Thread.sleep(1000);
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Aarti");
        driver.findElement(By.name("BillingNewAddress.LastName")).sendKeys("Doshi");

        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("ado@gmail.com");
        driver.findElement(By.id("BillingNewAddress_Company")).sendKeys("FutureTesting");
        driver.findElement(By.id("BillingNewAddress_CountryId")).sendKeys("United Kingdom");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("London");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("123 NiceLand");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("HA3 5AB");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("07894561230");

        //2.22 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()'"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath(""));

       // 2.26 Select Radio Button “Credit Card”
        clickOnElement(By.id("paymentmethod_1"));
        clickOnElement(By.xpath("//button[@name='save' and @class='button-1 payment-method-next-step-button']"));


        //2.27 Select “Master card” From Select credit card dropdown
        selectFromDropDownMenu(By.xpath("/select[@id='CreditCardType']"),"CreditCardType");
        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Aarti Doshi");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "1234  2345 3456");
        sendTextToElement(By.xpath("//select[@id='ExpireMonth']"), "12");
        sendTextToElement(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "123");

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(2000);

        //2.30
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        // Verify “Payment Method” is “Credit Card”
        String expectedPaymenMethod = "Credit Card";
        String actualPaymentMethod = driver.findElement(By.xpath("//li[@class='payment-method']/span[@class='value']")).getText();
        Thread.sleep(1000);
        Assert.assertEquals("not credit card", expectedPaymenMethod, actualPaymentMethod);
        // Verify “Shipping Method” is “Next Day Air”
        String expectedShippingMethod = "Next Day Air";
        String actualShippingMethod = getTextFromElement(By.xpath("//li[@class='shipping-method']/span[@class='value']"));
        Thread.sleep(1000);
        Assert.assertEquals("not next day air", expectedShippingMethod, actualShippingMethod);
        // 2.33 Verify Total is “$2,950.00”
        String expectedTotalAmount = "$2,950.00";
        String actualTotalAmount = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        // 2.34 Click on “CONFIRM”
        Thread.sleep(1000);
        clickOnElement(By.xpath("//button[@class='button-1 confirm-order-next-step-button']"));
        //2.35
        String expectedSuccessfullyProcessed = "Your order has been successfully processed!";
        String actualSuccessfullyProcessed = getTextFromElement(By.xpath("//div[@class='section order-completed']/div[@class='title']/strong"));
        // Verify the message “Your order has been successfully processed!”
        Assert.assertEquals("Not processed", expectedSuccessfullyProcessed, actualSuccessfullyProcessed);
        // 2.36
        clickOnElement(By.xpath("//button[@class='button-1 order-completed-continue-button']"));
        // 2.37
        String expectedWelcomeMessage = "Welcome to our store";
        String actualWelcomeMessage = getTextFromElement(By.xpath("//div[@class='topic-block-title']/h2"));

        Thread.sleep(1000);
        Assert.assertEquals("Not successfully processed", expectedWelcomeMessage, actualWelcomeMessage);
    }
    @After
    public void teardown(){
        closeBrowser();
    }

}
