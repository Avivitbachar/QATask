package Task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(id = "user-name")
    public WebElement txt_userName;
    @FindBy(id = "password")
    public WebElement txt_password;
    @FindBy(id = "login-button")
    public WebElement btn_login;




    public void positiveUser(String standard_user , String secret_sauce){
        txt_userName.sendKeys(standard_user);
        txt_password.sendKeys(secret_sauce);
        btn_login.click();
    }

    public void NegativeUser(String locked_out_user,String secret_sauce){
        txt_userName.sendKeys(locked_out_user);
        txt_password.sendKeys(secret_sauce);
        btn_login.click();
    }








}
