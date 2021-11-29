package iFrame;

import utilss.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase {

    @Test

    public void TestCase() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        BrowserUtils.switchByTitle(driver, "SeleniumTesting");
        Assert.assertTrue(driver.getTitle().endsWith("qavalidation"));
        driver.close();
        BrowserUtils.switchByTitle(driver, "iframes");
        // We should switch back to the main window
        driver.switchTo().frame("Frame2");
        WebElement category3 = driver.findElement(By.linkText("Category3"));
        category3.click();
        BrowserUtils.switchByTitle(driver, "SoftwareTesting");
        Assert.assertEquals(driver.getCurrentUrl(), "https://qavalidation.com/category/softwaretesting/");
        driver.quit();

    }
}
