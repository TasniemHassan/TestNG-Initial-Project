package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignInPage {
    public SignInPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".sds-heading--1")
    public WebElement heading1;

    @FindBy(css=".sds-page-section__title--sub ")
    public WebElement paragraphUnderSignIn;

    @FindBy(css="input[name='user[email]'")
    public WebElement emailInputBox;

    @FindBy(css = ".sds-label")
            public WebElement emailLabel;

    @FindBy(css="input[name='user[password]'")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[@for='password']")
    public WebElement passwordLabel;

    @FindBy(css = ".sds-helper-text")
    public WebElement minLengthPasswordWarning;

    @FindBy(xpath = "//div[@class='password-help']//a")
    public WebElement forgotPassword;

    @FindBy(xpath = "//div[@class='sds-disclaimer ']")
    public WebElement textUnderForgotPassword;

    @FindBy(xpath = "//button[@class='sds-button']")
    public WebElement signInButton;

    @FindBy(css ="h3[class='social-title sds-heading--3']")
    public WebElement heading3;

    @FindBy(xpath = "//li[@class='social-link']/a")
    public List<WebElement> socialMedia;

    @FindBy(css="a[class='sds-button google-button']")
    public WebElement signInGoogle;

    @FindBy(css = "div[class*='sds-notification sds-notification--error']")
    public WebElement errorMessage;



}
