package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class Homepage {

    private Page homepage;
    private static final String URL = "https://demoqa.com/";
    public Homepage(Page homepage){
        this.homepage=homepage;

    }
    public void navigate() {
        homepage.navigate(URL);
    }
    public void forms()
    {
        homepage.getByRole(AriaRole.HEADING ,new Page.GetByRoleOptions().setName("Forms")).click();
    }
    public void practiceForm(){
        homepage.getByText("Practice Form").click();
    }
}
