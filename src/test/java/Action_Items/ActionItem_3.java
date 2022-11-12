package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import okhttp3.Address;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized","incognito");
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> zipcode;
        zipcode = new ArrayList<>();
        zipcode.add("11239");
        zipcode.add("11218");
        zipcode.add("11237");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        for (int i = 0; i < zipcode.size(); i++) {
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            Thread.sleep(2000);
            driver.findElements(By.xpath("//*[contains(@class, 'menuItemInnerWrapper')]")).get(4).click();

            Thread.sleep(2000);
            WebElement searchBar = driver.findElement(By.xpath("//*[@id='location-search']"));
            searchBar.clear();
            //wait two seconds
            Thread.sleep(2000);
            searchBar.sendKeys(zipcode.get(i));
            driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            //wait two seconds
            Thread.sleep(2000);

            //scroll down 800 pixels
            jse.executeScript("scroll(0,800)");

            ArrayList<WebElement> studioLink = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'wrapperLink')]")));
            if (i == 0) {
                studioLink.get(1).click();
                Thread.sleep(2000);

            }//end of first statement

            else if (i == 1) {
                //scroll down 13000 pixels
                jse.executeScript("scroll(0,1300)");
                studioLink.get(2).click();
                //wait two seconds
                Thread.sleep(2000);
            }//end of second statement

            else if (i == 2) {
                studioLink.get(0).click();
            }//end of third statement

            String location = driver.findElements(By.xpath("//*[contains(@class, 'address')]")).get(1).getText();
            //"\n" which means space result
            String[] splitLocation = location.split("\n");
            System.out.println(splitLocation[0] + "\n" + splitLocation[1]);
            jse.executeScript("scroll(0,700)");
            String schedule = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainerMobile')]")).getText();
            System.out.println(schedule);
            System.out.println();

        }//end of loop

        driver.quit();

        }//end of main

}//end of java class
