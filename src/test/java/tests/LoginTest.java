package tests;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.JsonDataReader;

import java.util.List;
public class LoginTest extends TestBase {
    @Test(priority = 1)
    public void testElementPresence() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button should be displayed");
    }
    @Test(priority = 2, dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedMessage) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (expectedMessage.isEmpty()) {
            Assert.assertTrue(homePage.isSwagLabsTitleDisplayed(), "Swag Labs title should be visible after login");
        } else {
            Assert.assertEquals(loginPage.getErrorMessage(), expectedMessage, "Error message should match expected");
        }
    }
    @DataProvider(name = "loginData")
    public Object[][] getData() {
        List<Object[]> loginData = JsonDataReader.getLoginData("C:\\Users\\Hazem\\Desktop\\QualityEngineer-Automation-Challenge\\src\\test\\resources\\test-data\\loginData.json");
        return loginData.toArray(new Object[0][]);
    }
}