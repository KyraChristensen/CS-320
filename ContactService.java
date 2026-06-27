package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	//  In-memory storage using a Map for rapid lookup by ID
	private final Map<String, Contact> contacts = new HashMap<>();
	
	// Add contact with a unique ID
	public void addContact(Contact contact) {
		if (contact == null) {
			throw new IllegalArgumentException("Contact cannot be null");
		}
		if (contacts.containsKey(contact.getContactId())) {
			throw new IllegalArgumentException("Contact ID already exists");
		}
		contacts.put(contact.getContactId(), contact);
	}
	
	// Delete contact per contact ID
	public void deleteContact(String contactId) {
		if (!contacts.containsKey(contactId)) {
			throw new IllegalArgumentException("Contact ID not found");
		}
		contacts.remove(contactId);
	}
	
	// Update contact fields per contact ID
	public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setAddress(address);
    }

    // Helper method for testing verification
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}
