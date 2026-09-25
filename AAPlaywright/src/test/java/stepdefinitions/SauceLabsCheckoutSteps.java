package stepdefinitions;
import org.junit.Assert;
import pages.SauceLabCheckOutPage;
import pages.SauceLabsCartPage;
import pages.SauceLabsLogin;
import pages.SauceLabsProductPage;
import utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class SauceLabsCheckoutSteps {

    private final TestContext testContext;
    private final SauceLabsProductPage productPage;
    private final SauceLabsCartPage cartpage;
    private final SauceLabCheckOutPage checkoutPage;
  private final SauceLabsLogin sauceLabsLogin;

    public SauceLabsCheckoutSteps(TestContext testContext) {

        this.testContext = testContext;
        this.cartpage = new SauceLabsCartPage(testContext.getPage());
        this.productPage = new SauceLabsProductPage(testContext.getPage());
        this.checkoutPage = new SauceLabCheckOutPage(testContext.getPage());
        this.sauceLabsLogin = new SauceLabsLogin(testContext.getPage());
    }
    @And("I click the checkout button")
    public void iClickTheCheckoutButton() {
    cartpage.checkout();
    }

    @And("I enter first name {string}, last name {string}, and zip code {string}")
    public void iEnterCheckoutDetails(String firstName, String lastName, String zip) {
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(zip);
    }

    @And("I click the continue button")
    public void iClickTheContinueButton() {
        checkoutPage.clickContinue();
    }

    @And("I click the continue button without entering details")
    public void iClickTheContinueButtonWithoutEnteringDetails() {
        checkoutPage.clickContinue();
    }

    @And("I click the finish button")
    public void iClickTheFinishButton() {
        checkoutPage.clickFinish();
    }


    @Then("I should see the checkout error {string}")
    public void iShouldSeeTheCheckoutError(String expectedMessage) {
        Assert.assertEquals(expectedMessage, checkoutPage.getErrorMessage());
    }


}
