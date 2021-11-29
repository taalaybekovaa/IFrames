package iFrame;

import utilss.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NestedFramePractice {

    @Test
    public void nestedFrameValidation() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0);//switching by index
        WebElement middleFrame = driver.findElement(By.name("frame_middle"));
        driver.switchTo().frame(middleFrame);
        WebElement middleText = driver.findElement(By.id("content"));
        String actual = middleText.getText();
        String expected = "MIDDLE";
        Assert.assertEquals(actual, expected);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame_bottom");
        WebElement bottom = driver.findElement(By.tagName("body"));
        Assert.assertEquals(bottom.getText().trim(), "BOTTOM");
    }

    @Test
    public void printRightAndLeft() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(0);
        WebElement leftFrame = driver.findElement(By.xpath("//frame[@name='frame-left']"));
        driver.switchTo().frame(leftFrame);
        WebElement textLeft = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]"));
        System.out.println(BrowserUtils.getText(textLeft));
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.tagName("body"));
        WebElement textRight = driver.findElement(By.xpath("//body[contains(text(),'RIGHT')]"));
        System.out.println(BrowserUtils.getText(textRight));

    }
}
