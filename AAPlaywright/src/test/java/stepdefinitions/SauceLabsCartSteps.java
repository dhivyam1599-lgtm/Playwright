package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SauceLabsCartPage;
import pages.SauceLabsLogin;
import pages.SauceLabsProductPage;
import utils.TestContext;

public class SauceLabsCartSteps {

   private final SauceLabsCartPage cartpage;
    private final SauceLabsProductPage productPage;
    private final SauceLabsLogin loginpage;

    public SauceLabsCartSteps(
            TestContext testContext) {
        this.cartpage = new SauceLabsCartPage(testContext.getPage());

        this.productPage = new SauceLabsProductPage(testContext.getPage());
        this.loginpage = new SauceLabsLogin(testContext.getPage());
    }


    @When("User selects ")
    public void selectProduct(String productname){
        productPage.addToCart(productname);
     }
    @Then("User should be able to view the cart page")
    public void verifyPageTitle(){
        String title = cartpage.pageTitle();
        System.out.println("Page Title: " + title);

    }
    @Then("user should see {int} products")
    public void userShouldSeeProducts(int expectedCount) {
        int actualCount = cartpage.countItems();
        System.out.println("Product count: " + actualCount);

        Assert.assertEquals(actualCount, expectedCount);
    }

    @And("User should be able to remove the selected {string} items")
    public void removeItems(String productname)
    {
        cartpage.removeItems(productname);
    }
    @When("User navigates to cart page")
    public void clickCartIcon(){
        cartpage.cart();
    }

    @Then("User Clicks the Checkout Button")
   public void checkout(){
        cartpage.checkout();
    }
    @Then("User Clicks the Continue Button")
    public void clickContinue(){
       cartpage.continueShopping();
    }


}
