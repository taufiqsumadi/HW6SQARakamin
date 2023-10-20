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

public class productQuantityLimitation {
    WebDriver driver;
    @Given("i can see the available products")
    public void theUserCanSeeTheAvailableProducts() throws InterruptedException{
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

    @And("i adds products to the cart by clicking the Add to Cart")
    public void theUserAddsProductsToTheCartByClickingTheButton() {
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
    }

    @When("i clicks on the cart icon in the top right side")
    public void theUserClicksOnTheCartIconInTheTopRightSide() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }

    @Then("i cannot fill product quantities")
    public void theUsersCannotFillProductQuantities() {
        String webResp = driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText();
        Assert.assertEquals(webResp,"1");
        driver.close();
        driver.quit();
    }
}
