package page;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.HashMap;
import java.util.Map;

public class GCalculator extends BasePage {
    public GCalculator(WebDriver driver) {
        super(driver);
    }

    Map<Character, Runnable> btnMap = new HashMap<>();

    {
        btnMap.put('0', () -> driver.findElement(By.xpath("//div[text()='0']")).click());
        btnMap.put('1', () -> driver.findElement(By.xpath("//div[text()='1']")).click());
        btnMap.put('2', () -> driver.findElement(By.xpath("//div[text()='2']")).click());
        btnMap.put('3', () -> driver.findElement(By.xpath("//div[text()='3']")).click());
        btnMap.put('4', () -> driver.findElement(By.xpath("//div[text()='4']")).click());
        btnMap.put('5', () -> driver.findElement(By.xpath("//div[text()='5']")).click());
        btnMap.put('6', () -> driver.findElement(By.xpath("//div[text()='6']")).click());
        btnMap.put('=', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'equals')] | //div[contains(@aria-label, 'равно')]")).click());
        btnMap.put('÷', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'divide')] | //div[contains(@aria-label, 'деление')]")).click());
        btnMap.put('×', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'multiply')] | //div[contains(@aria-label, 'умножение')]")).click());
        btnMap.put('(', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'left parenthesis')] | //div[contains(@aria-label, 'открывающая скобка')]")).click());
        btnMap.put(')', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'right parenthesis')] | //div[contains(@aria-label, 'закрывающая скобка')]")).click());
        btnMap.put('-', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'minus')] |//div[contains(@aria-label, 'вычитание')]")).click());
        btnMap.put('+', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'plus')] | //div[contains(@aria-label, 'сложение')]")).click());
        btnMap.put('s', () -> driver.findElement(By.xpath("//div[contains(@aria-label, 'sine')] | //div[contains(@aria-label, 'синус')]")).click());
    }

    public void sendKeys(String value) {
        for (int i = 0; i < value.length(); i++) {
            if (btnMap.containsKey(value.charAt(i))) {
                btnMap.get(value.charAt(i)).run();
            }
        }
    }

    public String getResult() {
        return driver.findElement(By.id("cwos")).getText();
    }

    public String getMemoryString() {
        return driver.findElement(By.xpath("//span[contains(@jsname, 'ubtiRe')]")).getText();
    }

    public void assertResult(String expectedResult) {
        Assert.assertEquals(getResult(), expectedResult);
    }

    public void assertMemoryString(String expectedMemoryString) {
        Assert.assertEquals(getMemoryString(), expectedMemoryString);
    }
}