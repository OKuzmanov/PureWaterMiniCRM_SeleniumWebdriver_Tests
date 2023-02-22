package bg.softuni.seleniumwebdrivertests.tests;

import bg.softuni.pages.guest.LoginPage;
import bg.softuni.pages.logged.AddProductsPage;
import bg.softuni.seleniumwebdrivertests.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AddProductsPageTests extends BaseTest {
    private AddProductsPage addProductsPage;
    private LoginPage loginPage;

    @BeforeEach
    public void preTestsSetup() {
        chromeDriver.navigate().to(LOGIN_URL);

        loginPage = new LoginPage(chromeDriver);

        loginPage.loginUser("oleg4o", "12345");

        chromeDriver.navigate().to(ADD_PRODUCTS_URL);

        addProductsPage = new AddProductsPage(chromeDriver);
    }

    @Test
    public void test_pageLoadsCorrectly() {
        Assertions.assertEquals(addProductsPage.pageTitle, addProductsPage.addProductTitle.getText());
        Assertions.assertNotNull(addProductsPage.typeInput);
        Assertions.assertNotNull(addProductsPage.quantityInput);
        Assertions.assertNotNull(addProductsPage.productionDateInput);
        Assertions.assertNotNull(addProductsPage.addProductBtn);
    }

    @Test
    public void test_validationsWorkCorrectly() {
        addProductsPage.addProductBtn.click();
        Assertions.assertNotNull(addProductsPage.getTypeInputError());
        Assertions.assertNotNull(addProductsPage.getQuantityInputError());
        Assertions.assertNotNull(addProductsPage.getProductionDateInputError());
    }
}
