
import org.junit.jupiter.api.Test;

class ElectronicDeviceTest {
	ElectronicDevice device = new ElectronicDevice();
	Library library = new Library();

	/**
	 * 
	 */
	@Test
	void testSetLibrary() {		
		//Test initial value.
		assert device.getLibrary() == null;
		
		//Test adding a library object
		device.setLibrary(library);
		assert device.getLibrary() == library;
	}

	/**
	 * 
	 */
	@Test
	void testSetDeviceId() {
		ElectronicDevice device2 = new ElectronicDevice();
		library.addElectronicDevice(device);
		library.addElectronicDevice(device2);
		device.setLibrary(library);
		device2.setLibrary(library);
		
		//Test initial value.
		assert device.getDeviceId().equals("");
		
		//Set allowed deviceID for device
		device.setDeviceId("12345678");
		assert device.getDeviceId().equals("12345678");
		
		//Test two devices cannot have the same ID
		device2.setDeviceId("12345678");
		assert device2.getDeviceId().equals("");
		
		//Test too short an ID
		device2.setDeviceId("12345");
		assert device2.getDeviceId().equals("");
		
		//Test too long an ID
		device2.setDeviceId("12345678999");
		assert device2.getDeviceId().equals("");
	}

	/**
	 * 
	 */
	@Test
	void testSetDeviceLocation() {
		//Test initial value.
		assert device.getDeviceLocation().equals("");
		
		//Test changing location.
		device.setDeviceLocation("New location");
		assert device.getDeviceLocation().equals("New location");
	}

	/**
	 * 
	 */
	@Test
	void testSetDeviceType() {
		//Test initial value.
		assert device.getDeviceLocation().equals("");
		
		//Test changing device type.
		device.setDeviceLocation("New type");
		assert device.getDeviceLocation().equals("New type");
	}

	/**
	 * 
	 */
	@Test
	void testSetIsAvailable() {
		//Test initial value.
		assert device.isAvailable();
		
		//Test changing device to unavailable.
		device.setIsAvailable(false);
		assert !device.isAvailable();
	}

}
