package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class userLogin {
    WebDriver driver;
    @Given("opens the application through a browser")
    public void OpensTheApplicationThroughABrowser() throws InterruptedException{
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("enters a valid username")
    public void EntersAValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("enters a valid password")
    public void EntersAValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("clicks the login button")
    public void ClicksTheLoginButton() throws InterruptedException{
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(1000);
    }

    @Then("should be successfully logged in to the application")
    public void ShouldBeSuccessfullyLoggedInToTheApplication() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed();
        driver.close();
        driver.quit();
    }


    @When("enters a invalid username")
    public void entersAInvalidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("fake-users");
    }

    @And("enters a invalid password")
    public void entersAInvalidPassword() {
        driver.findElement(By.name("password")).sendKeys("wrong-pass");
    }

    @Then("The user receives a notification that the username or password is incorrect")
    public void theUserReceivesANotificationThatTheUsernameOrPasswordIsIncorrect() {
        String notification = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        System.out.println(notification);
        Assert.assertEquals(notification,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
        driver.quit();
    }
}
