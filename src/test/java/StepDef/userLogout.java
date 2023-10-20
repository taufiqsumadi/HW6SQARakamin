package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class userLogout {
    WebDriver driver;
    @Given("user opens the application through a browser")
    public void userOpensTheApplicationThroughABrowser() throws InterruptedException{
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
    }

    @When("user enters a valid username")
    public void userEntersAValidUsername() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
    }

    @And("user enters a valid password")
    public void userEntersAValidPassword() {
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
    }

    @And("user clicks the login button")
    public void userClicksTheLoginButton() throws InterruptedException{
        driver.findElement(By.name("login-button")).click();
        Thread.sleep(1000);
    }

    @And("user clicks the burger icon")
    public void userClicksTheBurgerIcon() {
        driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
    }
    @And("user clicks the logout button")
    public void userClicksTheLogoutButton() {
        driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
    }

    @Then("user will be redirect to login page")
    public void userWillBeRedirectToLoginPage() {
        driver.findElement(By.name("login-button")).isDisplayed();

        driver.close();
        driver.quit();
    }

}
