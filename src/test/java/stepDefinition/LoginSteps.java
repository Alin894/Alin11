package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

import java.sql.Driver;

public class LoginSteps {
    static final String Nume="zzzzz" ;

    WebDriver driver=null;
    @Given("User navigate to the website homepage")
    public void User_navigate_to_the_website_homepage() {
      System.out.println("User Navigates to ui");
      System.setProperty("webdriver.chrome.driver","C:\\Users\\step.DESKTOP-1MAJMCM\\IdeaProjects\\Alin1\\src\\webdriver\\chromedriver.exe");
              driver = new ChromeDriver();
              driver.navigate().to("https://parabank.parasoft.com/ ");
              driver.manage().window().maximize();
    }

    @And("User navigates to Register Page")
    public void userNavigatesToRegisterPage(){
        String RegisterText = driver.findElement(By.partialLinkText("Regis")).getText();
        assertEquals(RegisterText, driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).getText());
        driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a")).click();
        String signingUpIsEasy=driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText();
        assertEquals(signingUpIsEasy,driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1")).getText());
    }

    @When("User give userName")
    public void user_give_userName() {
        driver.findElement(By.id("customer.firstName")).sendKeys("Alin");

    }
    @When("User give lastName")
    public void user_give_lastName(){
        driver.findElement(By.id("customer.lastName")).sendKeys("Virtos");
    }

    @When("User give customer address city")
    public void user_give_cutomer_address_city(){
        driver.findElement(By.id("customer.address.city")).sendKeys("Chisinau" );

    }

    @When("User give customer address state")
    public void user_give_customer_address_state(){
        driver.findElement(By.id("customer.address.state")).sendKeys("Moldova");
    }

    @Then("User press register")
    public void user_press_register(){
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();

    }

    @Then("User have some error messages")
    public void user_have_some_error_messages(){
        String customerAddressErrors=driver.findElement(By.id("customer.address.street")).getText();
        String customerZipCodeErrors=driver.findElement(By.id("customer.address.zipCode")).getText();
        String customerPhoneErrors=driver.findElement(By.id("customer.phoneNumber")).getText();
        String customerSSNErrors=driver.findElement(By.id("customer.ssn")).getText();
        String customerUsernameErrors=driver.findElement(By.id("customer.username.errors")).getText();
        String customerPasswordErrors=driver.findElement(By.id("customer.password")).getText();
        String repeatedPasswordErrors=driver.findElement(By.id("repeatedPassword")).getText();
        assertEquals(customerAddressErrors,driver.findElement(By.id("customer.address.street")).getText());
        assertEquals(customerZipCodeErrors,driver.findElement(By.id("customer.address.zipCode")).getText());
        assertEquals(customerPhoneErrors,driver.findElement(By.id("customer.phoneNumber")).getText());
        assertEquals(customerSSNErrors,driver.findElement(By.id("customer.ssn")).getText());
        assertEquals(customerUsernameErrors,driver.findElement(By.id("customer.username.errors")).getText());
        assertEquals(customerPasswordErrors,driver.findElement(By.id("customer.password")).getText());
        assertEquals(repeatedPasswordErrors,driver.findElement(By.id("repeatedPassword")).getText());

    }

    @Then("User insert fields with valid data")
    public void user_insert_fields_with_valid_data(){

        driver.findElement(By.id("customer.address.street")).sendKeys("Biruinta 30");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("4838");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("68870843");
        driver.findElement(By.id("customer.ssn")).sendKeys("ssn");
        driver.findElement(By.id("customer.username")).sendKeys(Nume);
        driver.findElement(By.id("customer.password")).sendKeys("12345");
        driver.findElement(By.id("repeatedPassword")).sendKeys("12345");
    }

    @Then("User clicks on Register")
    public void userClickOnRegister(){
        driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input")).click();
    }

    @Then("User has account confirmation")
    public void user_has_account_confirmation(){
        assertEquals("Welcome "+Nume,driver.findElement(By.className("title")).getText());
    }

    @Then("User click on Open new account")
        public void user_click_on_open_new_account(){
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a")).click();
        }

        @Then("User select Saving option")
        public void user_select_saving_option(){
        driver.findElement(By.xpath("//*[@id=\"type\"]/option[2]")).click();
        }

        @Then("User press bottom button open new account")
        public void user_press_bottom_button_open_new_account() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value = 'Open New Account'")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"openAccountResult\"]/h1")).isDisplayed();
        }


    @Then("User insert pass")
    public void User_insert_pass()  {
        driver.close();
        driver.quit();
    }
}
