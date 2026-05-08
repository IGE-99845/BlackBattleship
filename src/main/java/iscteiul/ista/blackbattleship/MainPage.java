package iscteiul.ista.blackbattleship;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.jetbrains.com/
public class MainPage {
    @FindBy(xpath = "//*[@data-test-marker='Products']")
    public WebElement seeDeveloperToolsButton;

    @FindBy(xpath = "//*[@data-test='main-menu']//*[@data-test='suggestion-link']")
    public WebElement findYourToolsButton;

    @FindBy(css = "button[aria-label='Products: Open submenu']")
    public WebElement toolsMenu;

    @FindBy(css = "[data-test='site-header-search-action']")
    public WebElement searchButton;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
