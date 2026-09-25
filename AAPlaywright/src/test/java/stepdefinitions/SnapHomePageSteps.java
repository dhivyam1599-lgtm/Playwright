 package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SnapHomePage;
import utils.TestContext;

public class SnapHomePageSteps {

    private final SnapHomePage snapHomePage;

    public SnapHomePageSteps(TestContext testContext) {
        this.snapHomePage = new SnapHomePage(testContext.getPage());
    }

    @Given("user navigates to Snapdeal")
    public void userNavigatesToSnapdeal() {
        snapHomePage.navigateToSnapdeal();
    }

    @When("User selects the product {string}")
    public void searchProduct(String productName) {
        snapHomePage.searchProduct(productName);
    }

}
