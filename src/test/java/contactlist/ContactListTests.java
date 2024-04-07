package contactlist;

import core.BaseTests;
import core.MyExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import static controllers.SkbControllers.getUniqueName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.skb.Constants.*;

@ExtendWith(MyExtension.class)
public class ContactListTests extends BaseTests {

    @Test
    @DisplayName("Create a new contact test")
    void createContact() {
        String uniqueLastName = getUniqueName(USER_LASTNAME);
        mainPage.contactCreationModel(USER_FIRSTNAME, uniqueLastName, BASE_ADDRESS);
        WebElement newContactCounter = driver.findElement(By.xpath("//div[@class='gwt-HTML' and @dir='ltr'][contains(text(),'0 - 30 : 251')]"));
        assertEquals("0 - 30 : 251", newContactCounter.getText(), "Contact counter hasn't changed after the user was created");
        WebElement contactID;
        try {
            contactID = driver.findElement(By.xpath(CREATED_CLIENT_ID));
            //Scroll to the created contact's card
            actions.scrollToElement(contactID).perform();
        } catch (NoSuchElementException e) {
            throw new AssertionError("New created contact is not found", e);
        }
        assertTrue(contactID.isDisplayed(), "Created contact's card isn't displayed");
    }

    @Test
    @DisplayName("Unable to create an empty contact test")
    void createEmptyContact() {
        mainPage.createContactButton();
        WebElement countElement = driver.findElement(By.xpath("//div[@class='gwt-HTML' and @dir='ltr'][contains(text(),'0 - 30 : 250')]"));
        assertEquals("0 - 30 : 250", countElement.getText(), "Empty contact was created");
    }

    @Test
    @DisplayName("Update an existing contact test")
    void updateCreatedContact() {
        WebElement userToUpdate = driver.findElement(By.xpath(FIRST_CONTACT_ID));
        userToUpdate.click();
        String expectedName = "NewNewNewName";
        mainPage.updateUserModel(expectedName);
        WebElement updatedName = driver.findElement(By.xpath("//td[@style='font-size:95%;' and contains(text(),'" + expectedName + "')]"));
        String currentName = updatedName.getText();
        String[] parts = currentName.split(" ");
        String firstName = parts[0];
        assertEquals(expectedName,firstName, "Current contact name doesn't match the expected value");
    }

    @Test
    @DisplayName("Generate 50 Contacts test")
    void generateFiftyContacts() {
        mainPage.generateFiftyContactsButton();
        WebElement counter = driver.findElement(By.xpath(FIFTY_CONTACT_COUNTER));
        assertEquals("0 - 30 : 300", counter.getText(), "Contact counter hasn't changed after the user's were generated");
        WebElement lastContactId;
        try {
            lastContactId = driver.findElement(By.xpath("//div[@__idx='299']"));
            //Scroll to the latest generated contact's card
            actions.scrollToElement(lastContactId).perform();
        }
        catch (NoSuchElementException e) {
            throw new AssertionError("Last created contact isn't found", e);
        }
        assertTrue(lastContactId.isDisplayed(), "Last created contact isn't displayed on the screen");

    }
}

