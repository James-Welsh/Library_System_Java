

import org.junit.jupiter.api.Test;

class ElectronicResourceTest {
	ElectronicResource resource = new ElectronicResource();

	/**
	 * 
	 */
	@Test
	void testSetElectronicResourceType() {
		//Test initial value.
		assert resource.getElectronicResourceType().equals("");
		
		//Test a value that is not allowed.
		resource.setElectronicResourceType("test");
		assert resource.getElectronicResourceType().equals("");
		
		//Test all allowed values.
		resource.setElectronicResourceType("online paper");
		assert resource.getElectronicResourceType().equals("online paper");
		resource.setElectronicResourceType("pdf");
		assert resource.getElectronicResourceType().equals("pdf");
		resource.setElectronicResourceType("ebook");
		assert resource.getElectronicResourceType().equals("ebook");
	}

	/**
	 * 
	 */
	@Test
	void testAddDevice() {
		ElectronicDevice device1 = new ElectronicDevice();
		ElectronicDevice device2 = new ElectronicDevice();
		
		//Test initial array is empty.
		assert resource.getCompatableDevices().isEmpty();
		
		//Add a new device.
		resource.addDevice(device1);
		assert resource.getCompatableDevices().size() == 1;
		assert resource.getCompatableDevices().get(0) == device1;
		
		//Add another device.
		resource.addDevice(device2);
		assert resource.getCompatableDevices().size() == 2;
		assert resource.getCompatableDevices().get(0) == device1;
		assert resource.getCompatableDevices().get(1) == device2;
		
		//Test adding a null object
		resource.addDevice(null);
		assert resource.getCompatableDevices().size() == 2;
		assert resource.getCompatableDevices().get(0) == device1;
		assert resource.getCompatableDevices().get(1) == device2;
	}
	
	

}
