package Task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class CheckOut {

    @FindBy (id = "first-name")
    public WebElement txt_firstname;

    @FindBy(id = "last-name")
    public WebElement txt_lastName;

    @FindBy(id = "postal-code")
    public WebElement txt_postalCode;

    @FindBy(id = "continue")
    public WebElement btn_continue;

    @FindBy(className = "header_secondary_container")
    public WebElement headerTitle;

    @FindBy(id = "finish")
    public WebElement btn_finish;

    @FindBy(className = "complete-header")
    public WebElement OrderDone;

    String checkoutTitle = "Checkout: Overview";


   public void CheckoutFlow(String firstName , String lastName , String postalCode) {
       txt_firstname.sendKeys(firstName);
       txt_lastName.sendKeys(lastName);
       txt_postalCode.sendKeys(postalCode);
       btn_continue.click();
       assertEquals(headerTitle.getText(),checkoutTitle);
       btn_finish.click();
       assertEquals(OrderDone.getText(),"Thank you for your order!");

   }



}
