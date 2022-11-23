package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){

        openBrowser(baseUrl);
    }

    @Test
    public void UserShouldLoginSuccessfullyWithValidCredentials(){

        // Find the username field and send username
        sendTextToElement(By.name("username"), "tomsmith");

        // Find the password field and send password
        sendTextToElement(By.name("password"), "SuperSecretPassword!");

        // Find the login button and click on it
        clickOnElement(By.xpath("//button[@type = 'submit']"));

        //This is from requirement
        String expectedText = "Secure Area";

        // Find the Secure Area text element and get the text
        String actualText = getTextFromElement(By.xpath("//div[@class = 'example']/h2[contains(text(), 'Secure Area')]"));

        // Verify the Secure Area text is displayed
        Assert.assertEquals("Secure Area text is not displayed",expectedText, actualText);

    }

    @Test
    public void verifyTheUsernameErrorMessage(){

        // Find the username field and send username
        sendTextToElement(By.name("username"), "tomsmith2");

        // Find the password field and send password
        sendTextToElement(By.name("password"), "SuperSecretPassword!");

        // Find the login button and click on it
        clickOnElement(By.xpath("//button[@type = 'submit']"));

        //This is from requirement
        String expectedText ="Your username is invalid!\n"+"×";

        // Find the expected text element and get the text
        String actualText = getTextFromElement(By.xpath("//div/div[@id='flash']"));

        // Verify the error message  is displayed
        Assert.assertEquals("Error message  is not displayed",expectedText, actualText);

    }

    @Test
    public void verifyThePasswordErrorMessage(){

        // Find the username field and send username
        sendTextToElement(By.name("username"), "tomsmith");

        // Find the password field and send password
        sendTextToElement(By.name("password"), "SuperSecretPassword");

        // Find the login button and click on it
        clickOnElement(By.xpath("//button[@type = 'submit']"));

        //This is from requirement
        String expectedText ="Your password is invalid!\n"+"×";

        // Find the expected text element and get the text
        String actualText = getTextFromElement(By.xpath("//div/div[@id='flash']"));

        // Verify the error message  is displayed
        Assert.assertEquals("Error message  is not displayed",expectedText, actualText);
    }


    @After
    public void teardown(){

        closeBrowser();
    }

}