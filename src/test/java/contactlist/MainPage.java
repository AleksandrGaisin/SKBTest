package contactlist;

import core.BaseSeleniumPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.skb.Constants.BASE_URL;

public class MainPage  extends BaseSeleniumPage {

    @FindBy(xpath = "//td[text()=' First Name: ']/following-sibling::td/input[@type='text' and contains(@class, 'gwt-TextBox')]")
    private WebElement firstName;

    @FindBy(xpath = "//td[text()=' Last Name: ']/following-sibling::td/input[@type='text' and contains(@class, 'gwt-TextBox')]")
    private WebElement lastName;

    @FindBy(xpath = "//select[@class = \"gwt-ListBox\"]")
    private WebElement category;

    @FindBy(xpath = "//select[@class = \"gwt-ListBox\"]//option[@value='Friends']")
    private WebElement categoryElement;

    @FindBy(css = "input[type='text'].gwt-DateBox")
    private WebElement openCalendar;

    @FindBy(xpath = "//div[@class='datePickerNextButton datePickerNextButton-up' and @role='button']")
    private WebElement nextMonth;

    @FindBy(xpath = "//div[@class=\"dateBoxPopup\"]//div[@tabindex='0' and @aria-selected='false' and @class='datePickerDay ' and text()='29']")
    private WebElement dateCalendar;

    @FindBy(css = "textarea.gwt-TextArea")
    private WebElement address;

    @FindBy(xpath = "//button[@type='button' and @class='gwt-Button' and text()='Update Contact']")
    private WebElement updateButton;

    @FindBy(xpath = "//button[@type='button' and @class='gwt-Button' and text()='Create Contact']")
    private WebElement createButton;

    @FindBy(xpath = "//button[@type='button' and @class='gwt-Button' and text()='Generate 50 Contacts']")
    private WebElement generateFiftyContacts;

    public MainPage() {
        driver.get(BASE_URL);
        PageFactory.initElements(driver, this);
    }
    @Step("Create a new contact")
    public MainPage contactCreationModel(String firstNameValue, String lastNameValue, String addressValue) {
        firstName.sendKeys(firstNameValue);
        lastName.sendKeys(lastNameValue);
        category.click();
        categoryElement.click();
        openCalendar.click();
        nextMonth.click();
        dateCalendar.click();
        address.sendKeys(addressValue);
        createButton.click();
        return this;
    }
    @Step("Create Contact button click")
    public void createContactButton() {
        createButton.click();
    }

    @Step("Change First name value of the contact and click Update Contact button")
    public MainPage updateUserModel(String newFirstName) {
        firstName.clear();
        firstName.sendKeys(newFirstName);
        updateButton.click();
        return this;
    }
    @Step("Generate 50 Contacts button click")
    public void generateFiftyContactsButton() {
        generateFiftyContacts.click();
    }
}
