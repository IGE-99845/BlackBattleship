package iscteiul.ista.blackbattleship;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
        acceptCookies();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptCookiesButton = driver.findElement(By.cssSelector(".ch2-btn.ch2-btn-primary, #ch2-accept-button, [data-ch2-id='accept']"));
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookiesButton.click();
        } catch (Exception e) {
            // Banner não apareceu, continua na mesma
        }
    }

    @Test
    public void search() throws InterruptedException {
        mainPage.searchButton.click();
        Thread.sleep(1000);
        WebElement searchField = driver.findElement(By.cssSelector("[data-test-id='search-input']"));
        searchField.sendKeys("Selenium");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.cssSelector("button[data-test='full-search-button']"));
        submitButton.click();
        Thread.sleep(1000);
        WebElement searchPageField = driver.findElement(By.cssSelector("input[data-test-id='search-input']"));
        assertEquals("Selenium", searchPageField.getAttribute("value"));
    }

    @Test
    public void toolsMenu() {
        mainPage.toolsMenu.click();

        WebElement menuPopup = driver.findElement(By.cssSelector("[data-test='main-submenu-column-title']"));
        assertTrue(menuPopup.isDisplayed());
    }

    @Test
    public void navigationToAllTools() {
        mainPage.seeDeveloperToolsButton.click();
        mainPage.findYourToolsButton.click();

        WebElement productsList = driver.findElement(By.id("products-page"));
        assertTrue(productsList.isDisplayed());
        assertEquals("All Developer Tools and Products by JetBrains", driver.getTitle());
    }
}
