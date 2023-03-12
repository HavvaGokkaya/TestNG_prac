package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.ReusableMethods;

public class QualityPage {

    public QualityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Accept']")
    private WebElement cookies;

    @FindBy(xpath = "//*[text()='Log in']")
    private WebElement loginLink;

    @FindBy(xpath = "//input[@id='login-email']")
    private WebElement emailBox;

    @FindBy(xpath = "//input[@id='login-password']")
    private WebElement passwordBox;

    @FindBy(xpath = "(//*[text()='Login'])[2]")
    private WebElement loginButton;

    public void providerMethod(String mail,String password){
        if (cookies.isDisplayed()){
            cookies.click();
        }
        ReusableMethods.bekle(2);
        loginLink.click();
        emailBox.sendKeys(mail);
        passwordBox.sendKeys(password);
        ReusableMethods.bekle(2);
        loginButton.click();
    }

    public void loginMethod(){
        cookies.click();
        loginLink.click();
        emailBox.sendKeys("anevzatcelik@gmail.com");
        passwordBox.sendKeys("Nevzat152032");
        loginButton.click();
    }

    @FindBy(xpath = "(//div[@class='icon'])[5]")
    public WebElement kullaniciLogo;

    @FindBy(xpath = "(//li[@class='user-dropdown-menu-item'])[5]")
    public WebElement userProfile;

    @FindBy(xpath = "//input[@id='FristName']")
    public WebElement profileNameBox;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement profileLastNameBox;

    @FindBy(xpath = "//iframe[@id='Biography_ifr']")
    public WebElement biographyiframe;

    @FindBy(xpath= "//body[@id='tinymce']")
    public WebElement biographyBox;

    @FindBy(xpath = "//*[.='Save']")
    public WebElement saveBtn;

    @FindBy(xpath = "//*[text()='Top Categories']")
    public WebElement topCategories;
}
