package bg.softuni.seleniumwebdrivertests.tests;

import bg.softuni.pages.guest.LoginPage;
import bg.softuni.pages.logged.AddOrderPage;
import bg.softuni.seleniumwebdrivertests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddOrderPageTests extends BaseTest {

    private AddOrderPage addOrderPage;
    private LoginPage loginPage;

    @BeforeEach
    public void preTestsSetup() {
        chromeDriver.navigate().to(LOGIN_URL);

        loginPage = new LoginPage(chromeDriver);

        loginPage.loginUser("oleg4o", "12345");

        chromeDriver.navigate().to(ADD_ORDER_URL);

        addOrderPage = new AddOrderPage(chromeDriver);
    }

    @Test
    public void test_addOrderPage_pageLoadsCorrectly() {

        Assertions.assertEquals(addOrderPage.orderPageTitle, addOrderPage.addOrderTitle.getText());
        Assertions.assertNotNull(addOrderPage.orderNameInput);
        Assertions.assertNotNull(addOrderPage.quantityInput);
        Assertions.assertNotNull(addOrderPage.categoryInput);
        Assertions.assertNotNull(addOrderPage.expiryDateInput);
        Assertions.assertNotNull(addOrderPage.descriptionInput);
        Assertions.assertNotNull(addOrderPage.customerInput);
        Assertions.assertNotNull(addOrderPage.addOrderBtn);
    }

    @Test
    public void test_addOrderPage_validationsWorkCorrectly() {

        addOrderPage.addOrderBtn.click();
        Assertions.assertNotNull(addOrderPage.getOrderNameInputError());
        Assertions.assertNotNull(addOrderPage.getQuantityInputError());
        Assertions.assertNotNull(addOrderPage.getCategoryInputError());
        Assertions.assertNotNull(addOrderPage.getExpiryDateInputError());
        Assertions.assertNotNull(addOrderPage.getDescriptionInputError());
        Assertions.assertNotNull(addOrderPage.getCustomerInputError());
    }
}
