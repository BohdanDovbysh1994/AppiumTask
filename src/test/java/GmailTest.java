import driver.DriverObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.GmailPage;
import pageobjects.LoginPage;

public class GmailTest {
    private LoginPage loginPage;
    private GmailPage gmailPage;

    @BeforeMethod
    public void setUp() {
        loginPage = new LoginPage(DriverObject.getDriver());
        gmailPage = new GmailPage(DriverObject.getDriver());
    }

    @Test
    public void test() {
        DriverObject.getDriver().get("https://www.google.com/intl/ru/gmail/about/");
        loginPage.loginGmail("homeworkbohdan@gmail.com");
        loginPage.setPasswordInput("719113719113", DriverObject.getDriver());
        gmailPage.sentLetter("dovbysh.bohdan@gmail.com", "test2", "Test2");
        gmailPage.deleteMessage(DriverObject.getDriver());
        Assert.assertTrue(gmailPage.isImageDisplayed());
    }

    @AfterMethod
    public void closeDr() {
        DriverObject.releaseThread();
    }
}
