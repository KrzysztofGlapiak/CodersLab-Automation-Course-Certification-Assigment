import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;


public class Item_Purchase {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        driver.manage().window().maximize();

        WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"_desktop_user_info\"]/div/a/span"));
        loginbutton.click();

        WebElement email = driver.findElement(By.id("field-email"));
        email.clear();
        email.sendKeys("xzixwonvyceimfxotg@hthlm.com");

        WebElement password = driver.findElement(By.id("field-password"));
        password.clear();
        password.sendKeys("selenium123");

        WebElement SignIn = driver.findElement(By.id("submit-login"));
        SignIn.click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php");
        WebElement sweater = driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/div[2]/article/div/div[2]/h3/a"));
        sweater.click();
        WebElement size = driver.findElement(By.id("group_1"));
        size.click();
        WebElement sizeselect = driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")); //Wybieramy rozmiar M
        sizeselect.click();
        Thread.sleep(2000);
        WebElement quantity = driver.findElement(By.xpath("//button[contains(@class, 'btn-touchspin')]"));
        for (int i = 1; i < 5; i++) {
            quantity.click();
        }
        WebElement cart = driver.findElement(By.xpath("//button[contains(@class, 'btn btn-primary add-to-cart')]"));
        cart.click();
        Thread.sleep(1000);
        WebElement addtocart = driver.findElement(By.xpath("//a[contains(text(), 'Proceed to checkout')]"));
        addtocart.click();
        WebElement checkout = driver.findElement(By.xpath("//a[contains(text(), 'Proceed to checkout')]"));
        checkout.click();
        WebElement continuebutton = driver.findElement(By.xpath("//button[contains(@name, 'confirm-addresses')]"));
        continuebutton.click();
        WebElement continuebutton2 = driver.findElement(By.xpath("//button[contains(@name, 'confirmDeliveryOption')]"));
        continuebutton2.click();
        WebElement PayByCheck = driver.findElement(By.id("payment-option-1"));
        PayByCheck.click();
        WebElement termsofservice = driver.findElement(By.id("conditions_to_approve[terms-and-conditions]"));
        termsofservice.click();
        Thread.sleep(1000);
        WebElement placeorder = driver.findElement(By.xpath("//div[@id='payment-confirmation']//button[1]"));
        placeorder.click();

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("C:\\Users\\tass\\OneDrive\\Desktop\\Screenshot\\screenshot.png");
        try {
            FileUtils.copyFile(screenshot, destination);
            System.out.println("Screenshot saved as screenshot in: " + destination.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();

        }
        driver.quit();
    }
}

