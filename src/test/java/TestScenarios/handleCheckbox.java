package TestScenarios;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class handleCheckbox {
    public static void main(String args[]){
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = br.newPage();
        try{
            //This code for handle checkboxes
            page.navigate("https://www.lambdatest.com/selenium-playground/checkbox-demo");
            page.locator("#isAgeSelected").check();
            assertThat(page.locator("#isAgeSelected")).isChecked();
        }
        catch (Exception e) {
            System.out.println("Exception -- > " + e);
        }
        pw.close();
    }
}
