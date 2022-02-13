import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.BasePage;
import page.GCalculator;

public class CalcTest {
    private static WebDriver driver;
    private BasePage basePage;
    private GCalculator gCalculator;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        basePage = new BasePage(driver);
        gCalculator = new GCalculator(driver);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void checkOperationWithIntegers() {
        String expression = "(1 + 2) × 3 - 40 ÷ 5 =";

        basePage.goTo("http://google.com");
        basePage.typeRequest("Калькулятор");
        basePage.search();
        gCalculator.sendKeys(expression);
        gCalculator.assertMemoryString(expression);
        gCalculator.assertResult("1");
    }

    @Test
    public void checkDivideByZero() {
        String expression = "6 ÷ 0 =";

        basePage.goTo("http://google.com");
        basePage.typeRequest("Калькулятор");
        basePage.search();
        gCalculator.sendKeys(expression);
        gCalculator.assertMemoryString(expression);
        gCalculator.assertResult("Infinity");
    }

    @Test
    public void checkErrorWhenValueIsAbsent() {
        String expression = "sin="; // Скобки добавляются автоматически

        basePage.goTo("http://google.com");
        basePage.typeRequest("Калькулятор");
        basePage.search();
        gCalculator.sendKeys(expression);
        gCalculator.assertMemoryString("sin() =");
        gCalculator.assertResult("Error");
    }
}