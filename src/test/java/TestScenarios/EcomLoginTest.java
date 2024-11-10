package TestScenarios;

import com.microsoft.playwright.*;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class EcomLoginTest {

    public static void main(String args[]){
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = br.newPage();

        try {
            page.navigate("https://opensource-demo.orangehrmlive.com/");
            System.out.println(page.title());
            page.getByPlaceholder("Username").type("Admin");
            page.getByPlaceholder("Password").type("admin123");
            page.locator("//button[@type='submit']").click();
            assertThat(page).hasTitle("OrangeHRM");
            System.out.println("Test 1");
        }

        catch (Exception e){
            System.out.println(e);
            System.out.println("Test 2");
        }
        System.out.println("Test 3");
        page.clock();
        br.close();
        pw.close();
        System.out.println("Test 4");

    }


}
