package contact;

public class Contact {
	private final String contactId; // final makes it non-updatable
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact(String contactId, String firstName, String lastName, String phone, String address) {
		// Contact ID validation
		if (contactId == null || contactId.length() > 10) {
			throw new IllegalArgumentException("Invalid contact ID");
		}
		// First Name validation
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		// Last Name validation
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		// Phone validation (Must be exactly 10 digits)
		if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		// Address validation
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		
		this.contactId = contactId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
		
		// Getters
		public String getContactId() { return contactId; }
		public String getFirstName() { return firstName; }
		public String getLastName() { return lastName; }
		public String getPhone() { return phone; }
		public String getAddress() { return address; }
		
		// Setters w/ validation (No setter for contactId to ensure it's non-updatable
		public void setFirstName(String firstName) {
			if (firstName == null || firstName.length() > 10) {
				throw new IllegalArgumentException("Invalid first name");
			}
			this.firstName = firstName;
		}
		
		public void setLastName(String lastName) {
			if (lastName == null || lastName.length() > 10) {
				throw new IllegalArgumentException("Invalid last name");
			}
			this.lastName = lastName;
		}
		
		public void setPhone(String phone) {
			if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
				throw new IllegalArgumentException("Invalid phone number");
			}
			this.phone = phone;
		}
		
		public void setAddress(String address) {
			if (address == null || address.length() > 30) {
				throw new IllegalArgumentException("Invalid address");
			}
			this.address = address;
		}	
	
	}
