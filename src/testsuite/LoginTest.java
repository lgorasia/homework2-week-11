package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class LoginTest extends BaseTest {
String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

   @After
    public void tearDown() {
        closeBrowser();
    }

@Test

public void userSholdLoginSuccessfullyWithValidCredentials() {
//locate username
    WebElement usernameField = driver.findElement(By.id("txtUsername"));
    usernameField.sendKeys("Admin");
    //locate password
    WebElement passwordField = driver.findElement(By.id("txtPassword"));
    passwordField.sendKeys("admin123");
//click longin
    WebElement loginClick = driver.findElement(By.id("btnLogin"));
    loginClick.click();
    //This is requirement
    String expectedText = "Welcome";
    // find actual test
    WebElement actualTextElement = driver.findElement(By.xpath("//a[@id='welcome']"));
    String actualfullText = actualTextElement.getText();
String actualText = actualfullText.substring(0,7);
    Assert.assertEquals(expectedText,actualText);
}
@Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully(){
        //click forgot password
    WebElement forgotPasswordTab = driver.findElement(By.linkText("Forgot your password?"));
    forgotPasswordTab.click();
    //this is requirement
    String expectedText = "Forgot Your Password?";
    //actual text
    WebElement actualTextElement = driver.findElement(By.tagName("h1"));
    String actualText = actualTextElement.getText();

    Assert.assertEquals(expectedText,actualText);

}

}
