package testsuits;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseURL = "https://courses.ultimateqa.com/";
    @Before
    public void setUp() {
        openBrowser(baseURL);
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //Verify the text ‘Welcome Back!’
        String actualText=driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        String expectedText="Welcome Back!";
        Assert.assertEquals("Message not displayed successfully",expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //click on the ‘Sign In’ link
        driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']")).click();
        //Enter invalid username
        driver.findElement(By.xpath("//input[@id='user[email]']")).sendKeys("Maitri.com");
        //Enter invalid password
        driver.findElement(By.xpath("//input[@id='user[password]']")).sendKeys("Maitri123");
        //Click on Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verify the error message ‘Invalid email or password.’
        String actualMessage=driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        String expectedMessage="Invalid email or password.";
        Assert.assertEquals("Message displayed correctly",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
