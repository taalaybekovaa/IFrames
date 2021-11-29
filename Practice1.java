package iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice1 {

    @Test

    public void Test() {

        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement textWindow = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textWindow.clear();
        textWindow.sendKeys("Hello Java!");
        driver.switchTo().parentFrame();//parent frame does one parent in the inner html
        WebElement title = driver.findElement(By.tagName("h3"));
        String actualTitle = title.getText().trim();
        String expected = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(actualTitle, expected);

    }
}
