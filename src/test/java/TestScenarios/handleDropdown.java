package TestScenarios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class handleDropdown {

    public static void main(String args[]){
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = br.newPage();
        try{
            //This code for handle dropdown
            page.navigate("https://www.lambdatest.com/selenium-playground/select-dropdown-demo");
            Locator dd  = page.locator("#select-demo");
            
            //Select by value
            dd.selectOption("Monday");
            assertThat(dd).containsText("Monday");

            //Select by label
            dd.selectOption(new SelectOption().setLabel("Friday"));
            assertThat(dd).containsText("Friday");

            //Select by index
            dd.selectOption(new SelectOption().setIndex(1));
            assertThat(dd).containsText("Monday");

            //Select multiple value
            Locator ddm  = page.locator("#multi-select");
            //ddm.selectOption(Pass String array)

            //Select drop down if jquery
            page.navigate("https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo");
            page.locator("span.select2-selection").first().click();
            Locator country = page.locator("span.select2-results ul li",
                    new Page.LocatorOptions().setHasText("India")
                    );
            country.click();


            //Use different example
            Locator xc = page.locator("select[name='files']");
            xc.selectOption("Ruby");





            

        }
        catch (Exception e) {
            System.out.println("Exception -- > " + e);
        }
//        pw.close();
    }
}
