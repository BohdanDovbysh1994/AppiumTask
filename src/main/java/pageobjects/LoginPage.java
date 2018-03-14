package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    @FindBy(xpath = "//a[@href='https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/']")
    private WebElement logInButton;
    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement loginInput;
    @FindBy(xpath = "//div[@id='identifierNext']")
    private WebElement loginNextButton;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@id='passwordNext']")
    private WebElement passwordNextButton;
    @FindBy(className = "WaidBe")
    private WebElement gmailIcon;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginGmail(String login) {
        logInButton.click();
        loginInput.sendKeys(login);
        loginNextButton.click();
    }

    public void setPasswordInput(String password, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 45);
        wait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }

//    public void openGmailPage() {
//        gmailIcon.click();
//    }

}
