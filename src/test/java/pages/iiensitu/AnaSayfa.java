package pages.iiensitu;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AnaSayfa {
    public AnaSayfa(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

@FindBy(xpath = "//button[text()='Log In']")
    public WebElement loginButtonHomePage;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement username;

    @FindBy(xpath="//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement submitButton;
}
