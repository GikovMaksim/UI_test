package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(String url) {
        driver.get(url);
    }

    @FindBy(xpath = "//input[contains(@title, 'Поиск')]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[contains(@class, 'FPdoLc')]//input[contains(@name, 'btnK')]")
    private WebElement submit;

    public void typeRequest(String query) {
        searchInput.sendKeys(query);
        searchInput.sendKeys(Keys.TAB); // Сбрасывание фокуса с поля ввода
    }

    public void search() {
        submit.click();
    }
}
