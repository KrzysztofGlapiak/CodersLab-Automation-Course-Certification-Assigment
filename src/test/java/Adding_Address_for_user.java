import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertThrows;

//email: xzixwonvyceimfxotg@hthlm.com
//pass: selenium123

public class Adding_Address_for_user {
    WebDriver driver;

    public Adding_Address_for_user() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        this.driver = new ChromeDriver(options);
    }


    @Given("user logged in")
    public void loginasd() {
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
    }

    @When("user clicks \"Create new address\"")
    public void address() {
        WebElement Address = driver.findElement(By.xpath("//*[@id=\"addresses-link\"]/span"));
        Address.click();
        WebElement addaddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div[3]/a/span"));
        addaddress.click();
    }

    @When("^User fills the new address form: (.*), (.*), (.*), (.*), (.*), (.*)")
    public void addressfill(String alias, String address, String city, String zip, String country, String phone) {

        WebElement aliasField = driver.findElement(By.id("field-alias"));
        aliasField.sendKeys(alias);
        WebElement addressField = driver.findElement(By.id("field-address1"));
        addressField.sendKeys(address);
        WebElement cityField = driver.findElement(By.id("field-city"));
        cityField.sendKeys(city);
        WebElement zipField = driver.findElement(By.id("field-postcode"));
        zipField.sendKeys(zip);
        WebElement countryDropdown = driver.findElement(By.id("field-id_country"));
        countryDropdown.click();
        WebElement uk = driver.findElement(By.xpath("//*[@id=\"field-id_country\"]/option[2]"));
        uk.click();
        WebElement phoneField = driver.findElement(By.id("field-phone"));
        phoneField.sendKeys(phone);
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/footer/button"));
        submit.click();
    }

    @Then("new address will be added and will be visible")
    public void new_address_will_be_added_and_will_be_visible() {
        WebElement addedAddress = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/article[@class=\"address\"]/div[1]"));
        String actualAddress = addedAddress.getText();
        String expectedAddress = "Dom\nKrzysztof Glapiak\n123 Main St\nWarsaw\n00-001\nUnited Kingdom\n123456789";
        Assert.assertEquals("Dodany adres nie jest poprawny.", expectedAddress, actualAddress);
    }

    @And("address will be deleted")
    public void address_will_be_deleted() {
        WebElement deleteButton = driver.findElement(By.xpath("//a[@data-link-action='delete-address']"));
        deleteButton.click();
        assertThrows(Exception.class,() -> driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/article[@class=\"address\"]/div[1]"))
        );

    }

    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
}
