package Action_Items;

import Day9_102922.Reusable_Actions;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionItem_6 {
    JavascriptExecutor Jse = (JavascriptExecutor)driver;
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;
    @BeforeSuite
    public void setDriver(){
        driver = Reusable_Actions.setUpDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report.html",true);
    }
    @AfterSuite
    public void quitSession(){
        driver.quit();
        reports.flush(); //writing the logs back to the report
    }

    @Test(priority = 1)
    public void tc001_shouldBeAbleToClickOnMemberOverview() throws InterruptedException {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc001_shouldBeAbleToClickOnMemberOverview");

        //first navigate to HealthFirst Homepage
        driver.navigate().to("https://healthfirst.org");

        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@class = 'active-nav-page']")).click();
        logger.log(LogStatus.PASS, " Successfully click on Member Overview option");

        //we need to verify that we can view the "General Resources" after clicking member overview
         driver.findElement(By.xpath("//*[@class = 'Members Overview']")).click();
         //confirm if after scrolling we are able to view the "General Resources"
        Jse.executeScript("Scroll(0,400)");
        driver.findElement(By.xpath("//*[@class = 'rst-title-company']")).click();

    }//end of test 1

    @Test(dependsOnMethods = "tc001_shouldBeAbleToClickOnMemberOverview")
    public void tc002_makeAPayment() {
        //set the name of the test case to the report by using logger concept
        logger = reports.startTest("tc002_makeAPayment");

        //
        driver.findElement(By.xpath("//*[@class= 'stay-signed-in checkbox-container']")).click();
        logger.log(LogStatus.PASS,"Successfully unchecked on checkbox");

        //we need to verify that signed in option is checked
        boolean isSignInChecked = driver.findElement(By.xpath("//*[@id= 'persistent']")).isSelected();
        System.out.println("The checkbox check condition is: " + isSignInChecked);
        logger.log(LogStatus.INFO,"The checkbox check condition is: " + isSignInChecked);

        //end the logger for test 2
        reports.endTest(logger);
    }//end of test 2

}
