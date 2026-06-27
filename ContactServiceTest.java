package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import contact.Contact;
import contact.ContactService;

public class ContactServiceTest {
	@Test
    public void testAddContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        service.addContact(contact);
        
        assertNotNull(service.getContact("1"));
        assertEquals("Jane", service.getContact("1").getFirstName());
    }

    @Test
    public void testAddDuplicateContactIdThrowsException() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        Contact contact2 = new Contact("1", "John", "Doe", "1234567890", "123 Main St");
        
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    public void testDeleteContactSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        service.addContact(contact);
        
        service.deleteContact("1");
        assertNull(service.getContact("1"));
    }

    @Test
    public void testDeleteContactNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("999");
        });
    }

    @Test
    public void testUpdateContactFieldsSuccess() {
        ContactService service = new ContactService();
        Contact contact = new Contact("1", "Jane", "Smith", "0987654321", "456 Oak Ave");
        service.addContact(contact);

        service.updateFirstName("1", "Alex");
        service.updateLastName("1", "Jones");
        service.updatePhone("1", "5555555555");
        service.updateAddress("1", "789 Pine Rd");

        Contact updated = service.getContact("1");
        assertEquals("Alex", updated.getFirstName());
        assertEquals("Jones", updated.getLastName());
        assertEquals("5555555555", updated.getPhone());
        assertEquals("789 Pine Rd", updated.getAddress());
    }

    @Test
    public void testUpdateContactNotFoundThrowsException() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("999", "Alex");
        });
    }
}
