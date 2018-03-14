package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailPage {
    @FindBy(xpath = "//div[@class='M j T b hc Zm  Ke']")
    private WebElement sentLetterButton;
    @FindBy(xpath = "//input[@class='on Cv']")
    private WebElement sentToInput;
    @FindBy(xpath = "//input[@class='tn']")
    private WebElement subjectInput;
    @FindBy(xpath = "//div[@class='qn']")
    private WebElement messageInput;
    @FindBy(xpath = "//div[@class='M j T b hc en Ee']")
    private WebElement sentMessage;
    @FindBy(xpath = "//div[@class='V j zd']")
    private WebElement gmailMenu;
    @FindBy(xpath = "//div[@class='dl ql ec']//span")
    private WebElement sendMailsPage;
    @FindBy(xpath = "//div[@class='V j cb cm']")
    private WebElement checkBox;
    @FindBy(xpath = "//div[@class='V j Vd']")
    private WebElement deleteMessageButton;
    @FindBy(xpath = "//div[@class='jf mm']")
    private WebElement noMessageImage;

    public GmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void sentLetter(String sentTo, String subject, String message) {
        sentLetterButton.click();
        sentToInput.sendKeys(sentTo);
        subjectInput.sendKeys(subject);
        messageInput.sendKeys(message);
        sentMessage.click();
    }

    public void deleteMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(gmailMenu));
        gmailMenu.click();
        sendMailsPage.click();
        checkBox.click();
        wait.until(ExpectedConditions.visibilityOf(deleteMessageButton));
        deleteMessageButton.click();
    }

    public Boolean isImageDisplayed() {
        return noMessageImage.isDisplayed();
    }

}
