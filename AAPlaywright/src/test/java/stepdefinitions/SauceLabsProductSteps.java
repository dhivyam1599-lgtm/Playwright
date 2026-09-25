package stepdefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceLabsLogin;
import pages.SauceLabsProductPage;
import utils.TestContext;

public class SauceLabsProductSteps {

    private final SauceLabsProductPage productPage;
    private final SauceLabsLogin loginpage;

    public SauceLabsProductSteps(
            TestContext testContext) {

        this.productPage = new SauceLabsProductPage(testContext.getPage());
        this.loginpage =  new SauceLabsLogin(testContext.getPage());
    }

    @Given("User logins to Swag Labs Portal")
    public void loginSetup(){
        loginpage.navigate();
        loginpage.enterUsername("standard_user");
        loginpage.enterPassword("secret_sauce");
        loginpage.clickLogin();
    }

    @When("user selects products")
    public void userSelectsProducts() {
        productPage.selectProducts();
    }

    @Then("user should see the products title")
    public void userShouldSeeTheProductsTitle() {
        String title = productPage.verifyProductsTitle();
        System.out.println("Page Title: " + title);
    }

    @When("user filters products by {string}")
    public void userFiltersProductsBy(String optionLabel) {
        productPage.filterDropdown(optionLabel);
    }

   @Then("User selects the first product")
public void getProductByOrder(){
        productPage.selectFirstProduct();
    }

    @Then("User selects the last product")
    public void getLastProduct(){
        productPage.selectLastProduct();
    }

    @Then("products should be displayed in the selected order")
    public void productsShouldBeDisplayedInTheSelectedOrder() {
        productPage.orderProducts();
    }

    @When("user adds {string} to the cart")
    public void userAddsProductToTheCart(String productName) {
        productPage.addToCart(productName);
    }

    @And("User adds the product to cart")
    public void userClicksAddToCart()
    {
        productPage.clickAddToCart();
    }

    @Then("User go backs to Product Page")
    public void userClicksBackToProduct(){
        productPage.backToProducts();
    }
    @And("User removes the product that was added to cart")
    public void userClicksRemove()
    {
        productPage.removeProducts();
    }
}

