package stepdefinitions;

import io.cucumber.java.en.When;
import pages.ProductPage;
import utils.TestContext;

public class ProductSteps {

    private final ProductPage productPage;

    public ProductSteps(TestContext testContext) {
        this.productPage = new ProductPage(testContext.getPage());
    }

    @When("user selects the product {string}")
    public void selectProduct(String productName) {
        productPage.selectProduct(productName);
    }
}