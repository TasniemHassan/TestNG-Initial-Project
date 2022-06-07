package scripts;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import utilities.Driver;

public class Cars_Dot_Com_Test extends Base {

    /*
    Test Case 1: Validate Cars.com Sign in page form
Given user navigates to “https://www.cars.com/”
When user clicks on top right “Sign In” link
Then user should be navigated to “Sign in” page
And user should be able to see heading1 as "Sign in"
And user should be able to see paragraph under “Sign in” header as “New to
Cars.com? Sign up. Are you a dealer?”
And user should be able to see Email input box with “Email” label and enabled
And user should be able to see Password input box with “Password” label and
enabled
And user should be able to see warning under Password input box as “Minimum of
eight characters
And user should be able to a link as “Forgot password?” under the Password input
box
And user should be able to see “By signing in to your profile, you agree to our  Privacy
Statement  and  Terms of Service.” Text
And user should be able to “Sign in” button with its text and be displayed and
enabled”
     */
    @Test(priority = 1, description = "Test Case 1: Validate Cars.com Sign in page form")
    public void signInForm() {
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        Assert.assertEquals(signInPage.heading1.getText(), "Sign in");
        Assert.assertEquals(signInPage.paragraphUnderSignIn.getText(), "New to Cars.com? Sign up. Are you a dealer?");
        Assert.assertTrue(signInPage.emailInputBox.isDisplayed() && signInPage.emailInputBox.isEnabled());
        signInPage.emailLabel.getText().equals("Email");
        Assert.assertTrue(signInPage.passwordInputBox.isDisplayed() && signInPage.passwordInputBox.isEnabled());
        signInPage.passwordLabel.getText().equals("Password");
        Assert.assertTrue(signInPage.minLengthPasswordWarning.getText().equals("Minimum of eight characters"));
        Assert.assertTrue(signInPage.forgotPassword.isDisplayed() && signInPage.forgotPassword.getText().equals("Forgot password?"));
        Assert.assertTrue(signInPage.textUnderForgotPassword.isDisplayed() && signInPage.textUnderForgotPassword.getText().equals("By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service."));
        Assert.assertTrue(signInPage.signInButton.isDisplayed() && signInPage.signInButton.isEnabled() &&
                signInPage.signInButton.getText().equals("Sign in"));
    }
    /*
    Test Case 2: Validate Cars.com Sign in page social media section
Given user navigates to “https://www.cars.com/”
When user clicks on top right “Sign In” link
Then user should be navigated to “Sign in” page
And user should be able to see headings as "Connect with social"
And user should be able to “Sign in with Facebook” link with its text and be
displayed and enabled
And user should be able to “Sign in with Google” link with its text and be displayed
and enabled
And user should be able to “Sign in with Apple” link with its text and be displayed
and enabled
     */
        @Test(priority = 2, description = "Test Case 2: Validate Cars.com Sign in page social media section")
        public void validateSignInPageSocialMediaSection() {
            driver.get("https://www.cars.com/");
            homePage.signInLink.click();
            Assert.assertTrue(signInPage.heading3.isDisplayed() && signInPage.heading3.getText().equals("Connect with social"));
            for (int i = 0; i < 2; i++) {
                Assert.assertTrue(signInPage.socialMedia.get(0).isDisplayed() && signInPage.socialMedia.get(0).isEnabled() &&
                        signInPage.socialMedia.get(0).getText().equals("Sign in with Facebook"));
                Assert.assertTrue(signInPage.socialMedia.get(1).isDisplayed() && signInPage.socialMedia.get(1).isEnabled() &&
                        signInPage.socialMedia.get(1).getText().equals("Sign in with Apple"));
            }
            Assert.assertTrue(signInPage.signInGoogle.isDisplayed() && signInPage.signInGoogle.isEnabled() &&
                    signInPage.signInGoogle.getText().equals("Sign in with Google"));
        }
        /*
    Test Case 3: Validate user cannot sign in to Cars.com with invalid
            credentials
    Given user navigates to “https://www.cars.com/”
    When user clicks on top right “Sign In” link
    Then user should be navigated to “Sign in” page
    When user enters johndoe@gmail.com to the Email input box
    And user enters abcd1234 to the Password input box
    And user clicks on the “Sign in” button
    Then user should not be logged in and displayed an error message on the top of the
    form as below
“We were unable to sign you in.
    Your email or password was not recognized. Try again soon.”

         */
    @Test(priority = 3, description= "Test Case 3: Validate user cannot sign in to Cars.com with invalid credentials")
    public void canNotSignIn(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();
        signInPage.emailInputBox.sendKeys(" johndoe@gmail.com" + Keys.RETURN);
        signInPage.passwordInputBox.sendKeys("abcd1234" + Keys.RETURN);
        signInPage.signInButton.click();
        System.out.println(signInPage.errorMessage.getText());
        Assert.assertTrue(signInPage.errorMessage.isDisplayed() && signInPage.errorMessage.getText().equals("We were unable to sign you in.\n"+
                "Your email or password was not recognized. Try again soon."));

    }

}


