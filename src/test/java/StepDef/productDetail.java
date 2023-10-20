package StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class productDetail {
    WebDriver driver;
    @Given("users can see the available products")
    public void usersCanSeeTheAvailableProducts() throws InterruptedException{
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com");
        Thread.sleep(1000);
        driver.findElement(By.name("login-button")).isDisplayed();
        //login username
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        //login password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //click login button
        driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    @When("users clicks on product title")
    public void usersClicksOnProductTitle() throws InterruptedException{
        driver.findElement(By.xpath("//div[normalize-space()='Sauce Labs Backpack']")).click();
        Thread.sleep(1000);
    }

    @Then("users get information detail about product")
    public void usersGetInformationDetailAboutProduct() {
        String productDetail = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']")).getText();
        Assert.assertEquals(productDetail, "Sauce Labs Backpack");

        driver.close();
        driver.quit();
    }
}
