package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Getter
public class RegisterPage extends PageObjects {

    @FindBy(xpath = "//h1[contains(text(),'Signing up is easy!']")
    WebElement Signingupiseasy;

    @FindBy(xpath = "//input[@id='customer.firstName']")
    WebElement firstName;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    WebElement lastName;



    public RegisterPage(WebDriver driver) {
        super(driver);


    }
}
