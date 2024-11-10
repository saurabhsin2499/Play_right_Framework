package TestScenarios;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class handleInputs {

    public static void main(String args[]){
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = br.newPage();
        try{
            /// This code is for show type value in any input field ///
            page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");
            page.locator("input#user-message").type("My name is saurabh");
            page.locator("#showInput").click();
            System.out.println(page.locator("#message").textContent());
            assertThat(page.locator("#message")).hasText("My name is saurabh");


            /*
            This code for fil value in  input field
             */
            page.navigate("https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo");
            page.locator("#textbox").fill("My name is saurabh");
        }
        catch (Exception e){
            System.out.println("Exception -- > "+ e);
        }

        page.close();
        br.close();
        pw.close();
    }
}
