package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility
{
    String actualText,expectedText;
    String baseurl = "https://www.saucedemo.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseurl);

    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        // Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

//        clickOnElement(By.id("alertbtn"));      //Click on Alert Button
//        Alert alert = driver.switchTo().alert(); //Creating alert Object reference and switch to alert
//        System.out.println(alert.getText());    //Getting the Text from Alert
//        alert.accept();


        //Verify the text “PRODUCTS”
        actualText=getTextFromElement(By.xpath("//span[@class='title']"));
        expectedText="Products";
        Assert.assertEquals("Products Text Not Matched",expectedText,actualText);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage()
    {
        //Enter “standard_user” username
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");

        //Enter “secret_sauce” password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));

        //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.className("inventory_item"));
        driver.findElements(By.className("inventory_item"));
        System.out.println("Total Product: " + productList.size());
        // Verify the number of products are 6
        int expectSize = 6;
        int actualSize = productList.size();
        Assert.assertEquals(expectSize,actualSize);

    }



    @After
    public void tearDown()
    {
        closeBrowser();
    }
}
