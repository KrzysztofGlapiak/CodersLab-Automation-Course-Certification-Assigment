import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TreatsForBunny {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-search-engine-choice-screen");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://gryzomania.pl/");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        WebElement Search = driver.findElement(By.id("dgwt-wcas-search-input-1"));
        Search.click();
        Search.clear();
        //Searching for Hay
        Search.sendKeys("Wyrwisusz");
        WebElement SZUKAJ = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div[3]/div/div[2]/div[2]/div/form/div/button"));
        SZUKAJ.click();
        Thread.sleep(2000);
        String HayName = "SIANKO KRÓLEWSKIE 0,5kg WYRWISUSZ SIANO 500g";
        WebElement wyrwisusz = driver.findElement(By.xpath("//*[contains(text(), '" + HayName + "')]"));
        wyrwisusz.click();
        WebElement wyrwisuszquantity = driver.findElement(By.xpath("//*[@id=\"product-407078\"]/div[2]/form/div/input[3]"));
        wyrwisuszquantity.click();
        wyrwisuszquantity.click();
        wyrwisuszquantity.click();
        WebElement AddToCart = driver.findElement(By.name("add-to-cart"));
        AddToCart.click();
        Thread.sleep(3000);
        //Searching for Kiwi
        Search = driver.findElement(By.id("dgwt-wcas-search-input-1"));
        Search.click();
        Search.clear();
        Search.sendKeys("Kiwi");
        SZUKAJ = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div[3]/div/div[2]/div[2]/div/form/div/button"));
        SZUKAJ.click();
        String KiwiName = "KIWI liofilizowane TIVO 20g owoc dla gryzoni";
        WebElement Kiwi = driver.findElement(By.xpath("//*[contains(text(), '" + KiwiName + "')]"));
        try {
            // Szukamy elementu oznaczającego, że produkt jest wyprzedany
            WebElement soldOutMessage = driver.findElement(By.xpath("//*[contains(text(), 'Wyprzedane')]"));

            if (soldOutMessage.isDisplayed()) {
                System.out.println("Smaczek jest wyprzedany. Nie można go dodać do koszyka.");
            }
        } catch (NoSuchElementException e) {
            // Jeśli element nie został znaleziony, to produkt jest dostępny, więc kontynuujemy dodawanie
            WebElement kiwiQuantity = driver.findElement(By.xpath("//*[@id=\"product-397176\"]/div[2]/form/div/input[3]"));
            kiwiQuantity.click();
            kiwiQuantity.click();
//        Kiwi.click();
//        WebElement KiwiQuantity = driver.findElement(By.xpath("//*[@id=\"product-397176\"]/div[2]/form/div/input[3]"));
//        KiwiQuantity.click();
//        KiwiQuantity.click();
            AddToCart = driver.findElement(By.name("add-to-cart"));
            AddToCart.click();
            driver.quit();


//        WebElement Cart = driver.findElement(By.xpath("//*[@id=\"masthead\"]/div/div/div[2]/div/div[3]/div[1]/div/div/a"));
//        Cart.click();
        }
    }
}