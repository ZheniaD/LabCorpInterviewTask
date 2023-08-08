package StepDefinitions;

import PageObjects.AccessDetails;
import PageObjects.CustomerPage;
import Utilities.PropertiesReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class RegistrationPage {

    private static WebDriver driver = Hooks.driver;

    public static WebDriverWait wait;
    String idNumber;

    CustomerPage customerPage = new CustomerPage(driver, wait);
    AccessDetails accessDetails = new AccessDetails(driver,wait);

    @Given("Customer goes to the registration page")
    public void customer_goes_to_the_registration_page() {
        driver.get(PropertiesReader.getValue("url"));
    }
    @Then("Customer enters the following information")
    public void customer_enters_the_following_information(Map<String, String> credentials) {

        customerPage.bnt_done.click();
        customerPage.firstName.sendKeys(credentials.get("fistName"));
       customerPage.lastName.sendKeys(credentials.get("lastName"));
       customerPage.email.sendKeys(credentials.get("email"));
       customerPage.textArea.sendKeys(credentials.get("text"));
       customerPage.phone.sendKeys(credentials.get("phone"));

    }
    @Then("Customer clicks submit button")
    public void customer_clicks_submit_button() {
        customerPage.btn_submit.click();
    }
    @Then("Verify Customer ID is generated")
    public void verify_customer_id_is_generated() {
        idNumber = accessDetails.customerIDField.getText();

    }
    @Then("Check proper customer message “Please Note Down Your CustomerID” is displayed")
    public void check_proper_customer_message_please_note_down_your_customer_id_is_displayed() {

        Assert.assertEquals("Please Note Down Your CustomerID",accessDetails.msg.getText());

    }

    @Then("Check proper customer message {string} is displayed")
    public void checkProperCustomerMessageIsDisplayed(String string) {
        Assert.assertEquals(string,accessDetails.msg.getText());
    }

    @Then("Check the Customer ID is not empty and contains only numbers")
    public void check_the_customer_id_is_not_empty_and_contains_only_numbers() {


        int isDigit = Integer.parseInt(idNumber);

        Boolean isANumber = false;
        try{
            Integer.parseInt(idNumber);
                    isANumber = true;
        }catch (Exception e){
            isANumber = false;
        }

        Assert.assertTrue(isANumber);

        Boolean isNotEmpty = false;

        if (idNumber.isEmpty()){
            isNotEmpty = false;
        }else{
            isNotEmpty = true;
        }
        Assert.assertTrue(isNotEmpty);


    }

}
