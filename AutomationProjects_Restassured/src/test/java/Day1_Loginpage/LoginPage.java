package Day1_Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginPage {

	@Test
	 public void loginTest() throws InterruptedException
	
	
	{
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username & password
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click submit
        driver.findElement(By.id("submit")).click();

        // Validate success message
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Thread.sleep(4000);

        Assert.assertEquals(
                actualText,
                "Logged In Successfully",
                "Login not successful"
        );

        driver.quit();
    }
}