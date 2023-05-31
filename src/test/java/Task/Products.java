package Task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {
    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[1]")
    public WebElement asc ;

    @FindBy(id = "item_4_title_link")
    public WebElement productBackPack ;

    @FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/div/span/select/option[2]")
    public WebElement desc ;

    @FindBy(id = "item_3_title_link")
    public WebElement productTShirt;

    @FindBy(className = "inventory_list")
    public WebElement listItem;

    @FindBy(id = "item_0_title_link")
    public WebElement productBike;

    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    public WebElement addToCart;

    @FindBy(id = "remove-sauce-labs-bike-light")
    public WebElement RemoveFromCart;

    @FindBy(className = "inventory_item_name")
    public WebElement productAddBackPack;

    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    public WebElement AddToChartBackPackProduct;

    @FindBy (id = "remove-sauce-labs-backpack")
    public WebElement RemoveButtonBackPack;

    @FindBy(className = "shopping_cart_badge")
    public WebElement shopping;

    @FindBy(className = "shopping_cart_link")
    public WebElement shoppingChart;

    @FindBy(id = "checkout")
    public WebElement GoToCheckout;

    @FindBy(id = "react-burger-menu-btn")
    public WebElement btn_burgerM;

    @FindBy(id = "logout_sidebar_link")
    public WebElement btn_logoutSideBar;


    public void asc(){
        asc.click();

    }

    public void desc(){
        desc.click();

    }

    public void listOfItems(){
        listItem.isDisplayed();
    }

    public void AddAndRemove(){
        addToCart.isEnabled();
        addToCart.click();
        RemoveFromCart.isDisplayed();
        RemoveFromCart.click();
        addToCart.isEnabled();



    }

    public void AddToTheChartProduct(){
        AddToChartBackPackProduct.click();
        RemoveButtonBackPack.isDisplayed();
        shopping.isDisplayed();
        shoppingChart.click();
        GoToCheckout.click();

    }

    public void Logout(){
        btn_burgerM.click();
        btn_logoutSideBar.click();

    }










}
