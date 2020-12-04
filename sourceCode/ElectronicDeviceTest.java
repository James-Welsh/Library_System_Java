import org.junit.jupiter.api.Test;

/**
 * Test class for the ElectronicDevice class.
 * 
 *  @author James Welsh
 */


class ElectronicDeviceTest {
	private ElectronicDevice device = new ElectronicDevice();
	private Library library = new Library();

	/**
	 * Tests both the setLibrary() and getLibrary() methods.
	 * <p>
	 * Tests the initial value, that library cannot be passed as a null object
	 * and that when passed a library object the library data member updates.
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
	 * Tests both the setDeviceId() and the getDeviceId() methods.
	 * <p>
	 * Tests the initial value, an allowed value, an Id identical to that of
	 * a device already in the library, and too shot and too long strings.
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
	 * Tests both the setDeviceLocation() and getDeviceLocation() methods.
	 * <p>
	 * Tests initial value and that when passed a string the deviceLocation
	 * updates.
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
	 * Tests both the setDeviceType() and the getDeviceType() methods.
	 * <p>
	 * Tests initial value and that when passed a string the deviceType
	 * updates.
	 */
	@Test
	void testSetDeviceType() {
		//Test initial value.
		assert device.getDeviceType().equals("");
		
		//Test changing device type.
		device.setDeviceType("New type");
		assert device.getDeviceType().equals("New type");
	}

	/**
	 * Tests both the isAvailable() and setIsAvailable() methods.
	 * <p>
	 * Tests the initial value and then that when passed a new boolean
	 * that isAvailable updates.
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
