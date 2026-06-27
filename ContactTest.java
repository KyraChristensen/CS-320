package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import contact.Contact;

public class ContactTest {
	
	@Test
	public void testContactCreationSuccess() {
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertEquals("12345", contact.getContactId());
		assertEquals("John", contact.getFirstName());
		assertEquals("Smith", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Main St", contact.getAddress());
	}
	
	@Test
	public void testContactIdTooLong() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345678901", "John", "Smith", "1234567890", "123 Main St");
			}
		});
	}
	
	@Test
	public void testContactIdNull() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact(null, "John", "Doe", "1234567890", "123 Main St");
			}
		});
	}
	
	@Test
    public void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "JohnJohnJohn", "Doe", "1234567890", "123 Main St");
			}
		});
    }

    @Test
    public void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", null, "Doe", "1234567890", "123 Main St");
			}
		});
    }

    @Test
    public void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", "DoeDoeDoeDoe", "1234567890", "123 Main St");
			}
		});
    }

    @Test
    public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", null, "1234567890", "123 Main St");
			}
		});
    }

    @Test
    public void testPhoneNotExactlyTenDigits() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", "Doe", "12345", "123 Main St");
			}
		});
    }

    @Test
    public void testPhoneContainsNonDigits() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", "Doe", "123456789a", "123 Main St");
			}
		});
    }

    @Test
    public void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", "Doe", null, "123 Main St");
			}
		});
    }

    @Test
    public void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", "Doe", "1234567890", "123 Main Street Anytown USA 12345");
			}
		});
    }

    @Test
    public void testAddressNull() {
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				new Contact("12345", "John", "Doe", "1234567890", null);
			}
		});
    }
    
	@Test
	public void testSetFirstNameSuccess() {
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		contact.setFirstName("Jane");
		assertEquals("Jane", contact.getFirstName());
	}

	@Test
	public void testSetFirstNameTooLong() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setFirstName("JaneJaneJane");
			}
		});
	}

	@Test
	public void testSetFirstNameNull() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setFirstName(null);
			}
		});
	}

	@Test
	public void testSetLastNameSuccess() {
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		contact.setLastName("Doe");
		assertEquals("Doe", contact.getLastName());
	}

	@Test
	public void testSetLastNameTooLong() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setLastName("DoeDoeDoeDoe");
			}
		});
	}

	@Test
	public void testSetLastNameNull() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setLastName(null);
			}
		});
	}

	@Test
	public void testSetPhoneSuccess() {
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		contact.setPhone("0987654321");
		assertEquals("0987654321", contact.getPhone());
	}

	@Test
	public void testSetPhoneNotExactlyTenDigits() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setPhone("12345");
			}
		});
	}

	@Test
	public void testSetPhoneContainsNonDigits() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setPhone("123456789b");
			}
		});
	}

	@Test
	public void testSetPhoneNull() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setPhone(null);
			}
		});
	}

	@Test
	public void testSetAddressSuccess() {
		Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		contact.setAddress("456 Oak Ave");
		assertEquals("456 Oak Ave", contact.getAddress());
	}

	@Test
	public void testSetAddressTooLong() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setAddress("456 Oak Avenue Way Beyond Limit");
			}
		});
	}

	@Test
	public void testSetAddressNull() {
		final Contact contact = new Contact("12345", "John", "Smith", "1234567890", "123 Main St");
		assertThrows(IllegalArgumentException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				contact.setAddress(null);
			}
		});
	}

	@Test
	public void testExactBoundaryLimits() {
		String maxId = "1234567890";      
		String maxFirst = "1234567890";   
		String maxLast = "1234567890";    
		String exactPhone = "1234567890"; 
		String maxAddress = "123456789012345678901234567890"; 
		
		Contact contact = new Contact(maxId, maxFirst, maxLast, exactPhone, maxAddress);
		contact.setFirstName(maxFirst);
		contact.setLastName(maxLast);
		contact.setPhone(exactPhone);
		contact.setAddress(maxAddress);
		
		assertEquals(maxId, contact.getContactId());
	}
}