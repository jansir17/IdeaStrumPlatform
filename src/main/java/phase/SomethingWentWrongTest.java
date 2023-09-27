package phase;


import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.options.LoadState;

public class SomethingWentWrongTest {

    public static void main(String[] args) {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new LaunchOptions().setHeadless(false));
//		BrowserContext context = browser.newContext();
        Page page = browser.newPage();
        page.navigate("https://dev.strumplatform.com");
        page.locator("//input[@id='i0116']").type("mehrab.hossain@strumplatform.com");
        page.locator("//input[@id='idSIButton9']").click();
        page.locator("//input[@id='i0118']").type("Betasir776625-");
        page.locator("//input[@id='idSIButton9']").click();
        Locator otpCode = page.locator("#idRichContext_DisplaySign");
        otpCode.waitFor();
        System.out.println(otpCode.innerText());
        page.waitForLoadState(LoadState.NETWORKIDLE);
        page.locator("//input[@id='idSIButton9']").click();
        page.waitForTimeout(7000);

        page.waitForSelector("img[src='/theme/assets/images/strum/Executive.svg']").click();
        page.waitForTimeout(15000);
        ElementHandle bugElement = page.querySelector("//span[@style=\"font-size:medium\"]");
        if (bugElement != null) {

            System.out.println(bugElement.innerText());

        }
        else {System.out.println("Did not find any bugggggSS");}
        browser.close();
    }

}
