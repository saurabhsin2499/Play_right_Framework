package TestScenarios;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.ScreenshotCaret;
import java.nio.file.Paths;


public class handleScreenshot {

    public static void main(String args[]){
        Playwright pw = Playwright.create();
        Browser br = pw.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        Page page = br.newPage();
        try{
            page.navigate("https://www.lambdatest.com/selenium-playground/simple-form-demo");

            //Screen shot
            Page.ScreenshotOptions ss = new Page.ScreenshotOptions();
            page.screenshot(ss.setPath(Paths.get("/Users/saurabhsingh/Playwrigth Framework/src/test/resources/screenshots/ss1.png")));


            // full page ss
            page.screenshot(ss.setFullPage(true).setPath(Paths.get("/Users/saurabhsingh/Playwrigth Framework/src/test/resources/screenshots/fullScreeShot.png")));

            //locator ss
            Locator demo = page.locator("//*[text()='Book a Demo']");
            Locator.ScreenshotOptions sl = new Locator.ScreenshotOptions();
            demo.screenshot(sl.setPath(Paths.get("/Users/saurabhsingh/Playwrigth Framework/src/test/resources/screenshots/locatorScreeShot.png")));


            //Masking locator

            Locator inputfield = page.locator("#user-message").first();
//            inputfield.type("saurabh");
//            inputfield.scrollIntoViewIfNeeded();
//            page.screenshot(
//                    ss.setMask(Arrays.asList(inputfield))
//                            .setFullPage(false)
//                            .setPath(Paths.get("/Users/saurabhsingh/Playwrigth Framework/src/test/resources/screenshots/maskScreeShot.png"))
//            );

            // Caret show / hide
            inputfield.click();
            page.screenshot(ss
                    .setPath(Paths.get("/Users/saurabhsingh/Playwrigth Framework/src/test/resources/screenshots/caretScreeShot.png"))
                    .setCaret(ScreenshotCaret.HIDE)
                    .setFullPage(false));

        }
        catch (Exception e) {
            System.out.println("Exception -- > " + e);
        }
        pw.close();
    }
}
