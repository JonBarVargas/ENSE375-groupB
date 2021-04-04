
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;

import org.junit.*;
//TEMPLATE OF TESTS GENERATED BY SELENIUM FIREFOX PLUGIN,
public class seleniumTest {
    String url = "http://automationpractice.com/index.php";
    static WebDriver driver = null;
    String email = "tapopi3251@0pppp.com";
    String password = "password";
    @BeforeClass
    public static void initDrivers(){

        String browser = System.getProperty("browser");
        browser.trim();

        if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        } else{
            driver = new ChromeDriver();
        }
       

    }


    @AfterClass
    public static void closeDriver(){
      driver.quit();
    }

    @Test
    public void websiteTitle(){
      driver.get(url);
      assertEquals(driver.getTitle(),"My Store");
    }


    @Test
    public void signUp(){
        Random r = new Random();
        int random = r.nextInt(100000);
        driver.get(url);
        driver.findElement(By.linkText("Sign in")).click();
    driver.findElement(By.id("email_create")).click();
    driver.findElement(By.id("email_create")).sendKeys("tapopi"+random+"@0pppp.com");
    driver.findElement(By.id("create-account_form")).click();
    driver.findElement(By.cssSelector("#SubmitCreate > span")).click();

    //wait for page to load
    WebElement element;
    WebDriverWait wait = new WebDriverWait(driver, 20);
    element= wait.until(ExpectedConditions.elementToBeClickable(By.id("id_gender1")));

    driver.findElement(By.id("id_gender1")).click();
    driver.findElement(By.id("customer_firstname")).click();
    driver.findElement(By.id("customer_firstname")).sendKeys("John");
    driver.findElement(By.id("customer_lastname")).click();
    driver.findElement(By.id("customer_lastname")).sendKeys("Smith");
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys("password");
    driver.findElement(By.cssSelector(".required:nth-child(4)")).click();
    driver.findElement(By.id("days")).click();
    {
      driver.findElement(By.cssSelector("#days > option:nth-child(6)")).click();
    }
  
    driver.findElement(By.id("months")).click();
    {
        driver.findElement(By.cssSelector("#months > option:nth-child(2)")).click();
    }

    driver.findElement(By.id("years")).click();
    {
        driver.findElement(By.cssSelector("#years > option:nth-child(35)")).click();
    }

    driver.findElement(By.id("newsletter")).click();
    driver.findElement(By.id("optin")).click();
    driver.findElement(By.id("firstname")).click();
    driver.findElement(By.id("company")).click();
    driver.findElement(By.id("company")).sendKeys("Test Company");
    driver.findElement(By.id("address1")).click();
    driver.findElement(By.id("address1")).sendKeys("123 Test Rd.");
    driver.findElement(By.id("city")).click();
    driver.findElement(By.id("city")).sendKeys("Regina");
    driver.findElement(By.id("id_state")).click();
    {
        driver.findElement(By.cssSelector("#id_state > option:nth-child(54)")).click();
    }

    driver.findElement(By.id("postcode")).click();
    driver.findElement(By.id("postcode")).sendKeys("90210");
    driver.findElement(By.cssSelector(".postcode")).click();
    driver.findElement(By.id("phone_mobile")).click();
    driver.findElement(By.id("phone_mobile")).sendKeys("555555555");
    driver.findElement(By.cssSelector(".submit")).click();
    driver.findElement(By.id("alias")).click();
    driver.findElement(By.id("alias")).sendKeys("First Address");
    driver.findElement(By.cssSelector("#submitAccount > span")).click();
    assertEquals(driver.getTitle(),"My account - My Store");
    driver.findElement(By.linkText("Sign out")).click();
  }



  @Test
  public void logIn() {
    driver.get("http://automationpractice.com/index.php");
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement element= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign in")));
    driver.findElement(By.linkText("Sign in")).click();
    element = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys(password);
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
    assertEquals(driver.getTitle(),"My account - My Store");
    driver.findElement(By.linkText("Sign out")).click();
  }




  @Test
  public void addDressToCheckout() {
    driver.get("http://automationpractice.com/index.php");
    driver.manage().window().setSize(new Dimension(1920, 1080));
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Women")));
    driver.findElement(By.linkText("Women")).click();
    driver.findElement(By.cssSelector("li:nth-child(2) > .subcategory-image .replace-2x")).click();
    
    Actions builder = new Actions(driver);
    WebElement hover = driver.findElement(By.cssSelector("li:nth-child(3)  .product_img_link"));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hover);
    builder.moveToElement(hover).perform();
     elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".hovered")));
    By locator = By.cssSelector(".hovered");
    driver.findElement(locator).click();
    elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.exclusive")));
    driver.findElement(By.cssSelector("button.exclusive")).click();
    elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title='Proceed to checkout']")));
    driver.findElement(By.cssSelector("[title='Proceed to checkout']")).click();

    
  }



  @Test
  public void buyDress(){
    addDressToCheckout();
    WebDriverWait wait = new WebDriverWait(driver, 20);
    WebElement elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("html body#order.order.hide-left-column.hide-right-column.lang_en div#page div.columns-container div#columns.container div.row div#center_column.center_column.col-xs-12.col-sm-12 p.cart_navigation.clearfix a.button.btn.btn-default.standard-checkout.button-medium")));
    driver.findElement(By.cssSelector("html body#order.order.hide-left-column.hide-right-column.lang_en div#page div.columns-container div#columns.container div.row div#center_column.center_column.col-xs-12.col-sm-12 p.cart_navigation.clearfix a.button.btn.btn-default.standard-checkout.button-medium")).click();
    elementWait = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys(email);
    driver.findElement(By.id("passwd")).click();
    driver.findElement(By.id("passwd")).sendKeys(password);
    driver.findElement(By.cssSelector("#SubmitLogin > span")).click();


    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("button.button:nth-child(4)")));
    elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button:nth-child(4)")));
    driver.findElement(By.cssSelector("button.button:nth-child(4)")).click();
    elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#uniform-cgv")));
    driver.findElement(By.cssSelector("#uniform-cgv")).click();
    driver.findElement(By.cssSelector("button.button:nth-child(4)")).click();

    elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".bankwire")));
    driver.findElement(By.cssSelector(".bankwire")).click();

    elementWait= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.button-medium")));
    driver.findElement(By.cssSelector("button.button-medium")).click();
    driver.findElement(By.linkText("Sign out")).click();
  }
    }
