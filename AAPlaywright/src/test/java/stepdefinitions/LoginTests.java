package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SauceLabsLogin;
import utils.TestContext;



public class LoginTests {
    private final TestContext testContext;
    private final SauceLabsLogin sauceLabsLogin;


    public LoginTests(TestContext testContext) {
      this.testContext = testContext;
      this.sauceLabsLogin = new SauceLabsLogin(testContext.getPage());
    }
    @Given("User logins to Swag labs website")
        public void userLoginsToSwagLabsWebsite() {

        sauceLabsLogin.navigate();
    }
    @When("User enters valid username {string}")
            public void enterUsername(String username){
             sauceLabsLogin.enterUsername(username);
        }

    @And("User enters valid password {string}")
    public void enterPassword(String password){
        sauceLabsLogin.enterPassword(password);
    }
    @Then("User clicks the Login Button")
    public void loginButton(){
        sauceLabsLogin.clickLogin();
    }
    @And("Verify the Page title {string}")
    public void getTitle(String title){
        sauceLabsLogin.getTitle(title);
    }
    @And("Verify the login error {string}")
    public void iShouldSeeTheLoginError(String expectedMessage) {
        String actual = sauceLabsLogin.getErrorMessage();
        Assert.assertEquals(expectedMessage, actual);
    }

}
