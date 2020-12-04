/**
 * Test class for the ElectronicResource class.
 * 
 *  @author James Welsh
 */

import org.junit.jupiter.api.Test;

class ElectronicResourceTest {
	ElectronicResource resource = new ElectronicResource();

	/**
	 * Tests both setElectronicResourceType() and getElectronicResourceType().
	 * <p>
	 * Tests initial value, a value that should be rejected, and all allowed
	 * values for electronicRespurceType.
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
	 * Tests the addDevice() and getCompatableDevices() methods.
	 * <p>
	 * Tests array is empty initially and that it behaves as expected when
	 * multiple devices are added.
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
