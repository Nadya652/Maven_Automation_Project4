package Action_Items;

import Day9_102922.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ActionItem_5 {

    WebDriver driver;

    @BeforeSuite
    public void setChromeDriver() {

        driver = Reusable_Actions.setUpDriver();
    }//end of set up driver method

    @AfterSuite
    public void quitTheSession() {
        driver.quit();
    }//end of the after suite

    @Test()
    public void findADoctor() throws InterruptedException {
        //navigate to the website
        driver.navigate().to("https://www.uhc.com/");

        //click on find a doctor
        Reusable_Actions.clickAction(driver, "//*[@aria-label='Find a doctor']", "Find a doctor");

        //click no on pop up page
        Reusable_Actions.clickAction(driver, "//*[@id='ip-no']", "clickPopUp");

        //scroll to see the find a doctor
        Reusable_Actions.scrollByView(driver, "//*[@id= 'main-content']", 0, "Main Content");

        //click to find a dentist
        Reusable_Actions.clickAction(driver, "//*[text()='Find a dentist']", "Find a Dentist");

        //switch tabs
        Reusable_Actions.switchtoTab(driver, 1);

        //wait two seconds
        Thread.sleep(2000);

        //click on "employer and individual plans"
        Reusable_Actions.clickAction(driver, "//*[text()='Employer and Individual Plans']", "Employer and Individual Plans");

    } // end of test 1

    @Test(dependsOnMethods = "findADoctor")
    public void zipCode() throws InterruptedException {
        //input zipcode
        Reusable_Actions.sendKeysAction(driver, "//*[@id= 'location']", "11223", "Zip Code");
        // wait two seconds
        Thread.sleep(2000);

        //click on submit
        Reusable_Actions.clickAction(driver, "//*[@type='submit']", "Submit");
        //wait two seconds
        Thread.sleep(2000);

        //click on National Options
        Reusable_Actions.clickActionByIndex(driver, "//*[@class= 'sc-jomqko TEkcT']", 1, "National Options");
        //wait five seconds
        Thread.sleep(5000);

        // click on general dentist
        Reusable_Actions.clickAction(driver, "//*[@id='nodeDescription1']", "general dentist");
        //wait five seconds
        Thread.sleep(5000);

    }// end of test 2

    @Test(dependsOnMethods = "zipCode")
    public void menu() {
        //select a different mileage
        Reusable_Actions.selectByText(driver, "//*[@id='distance']", 0, "Within 50 Miles", "miles dropdown on general dentist page ");
        //class="radiusMiles ng-valid ng-not-empty ng-touched ng-dirty ng-valid-parse ally-focus-within"
        //click on the first doctor
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='provider-name-link']", 0, "First Doctor");

        //click on the save button
        Reusable_Actions.clickActionByIndex(driver, "//*[@data-test-id='saved-provider-button']", 0, "Save button");

        //capture address, miles, & network type
        String info = Reusable_Actions.getTextAction(driver, "//*[@class='outer-container tbl']", "Address, Miles, & Network Type");

        //print the information
        System.out.println(info);

        //close the tab
        driver.close();

    }//test 3

    @Test(dependsOnMethods = "menu")
    public void doctor() throws InterruptedException {
        //switch back to default tab
        Reusable_Actions.switchtoTab(driver, 0);

        //navigate back to website
        driver.navigate().to("https://www.uhc.com/");
        //wait two seconds
        Thread.sleep(2000);
        //enter the word doctor on search field
        Reusable_Actions.sendKeysAction(driver, "//*[@id='search-desktop']", "Doctor", "Search Doctor");
        // click submit on the search
        Reusable_Actions.clickAction(driver, "//*[@id='search__button-desktop']", "submit icon");
        //capture search results
        String searchResult = Reusable_Actions.getTextAction(driver, "//*[@id='search-results-count__header']", "Search Results");

        String[] arrayMessage = searchResult.split(" ");
        System.out.println(arrayMessage[0] + arrayMessage[1] + arrayMessage[2]);
    }// end of test 4

}// end of class


