package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import utils.TestContext;

public class SauceLabsLogin {

    private static final String HOMEPAGE_URL = "https://www.saucedemo.com";
    private static final String ERROR_MESSAGE   = "[data-test='error']";

    private final Page page;

    public SauceLabsLogin(Page page) {
        this.page = page;
    }


    public void navigate(){
        page.navigate(HOMEPAGE_URL);
    }

    public void enterUsername(String username){
        page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Username")).fill(username);

    }
    public void enterPassword(String password){
        page.getByRole(AriaRole.TEXTBOX,new Page.GetByRoleOptions().setName("Password")).fill(password);

    }
    public void clickLogin(){
        page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Login")).click();
    }
    public void getTitle(String title){
        page.getByTitle(title).isVisible();
    }
    public boolean isLoginButtonVisible() {
        return page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName("Login")
        ).isVisible();
    }
    public String getErrorMessage() {
        if (page.isVisible(ERROR_MESSAGE)) {
            return page.locator(ERROR_MESSAGE).textContent().trim();
        }
        return "";
    }

}
