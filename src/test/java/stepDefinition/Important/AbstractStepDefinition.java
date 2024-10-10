package stepDefinition.Important;

import org.openqa.selenium.WebDriver;
import pages.RegisterPage;
import util.PropretyLoader;

public class AbstractStepDefinition {
    protected static WebDriver driver;
    protected static String chromeDriver = PropretyLoader.loadProperty("chromeDriver");
    protected static String geckoDriver = PropretyLoader.loadProperty("geckodriver");
    protected static String homePageUrl = PropretyLoader.loadProperty("homePageUrl");
    public RegisterPage registerPage = new RegisterPage(driver);
}
