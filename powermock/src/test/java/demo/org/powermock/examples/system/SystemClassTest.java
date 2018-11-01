package demo.org.powermock.examples.system;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mockito;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.powermock.api.mockito.PowerMockito.spy;
import org.powermock.api.mockito.PowerMockito;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import static org.powermock.api.mockito.PowerMockito.doThrow;
import static org.junit.Assert.assertEquals;
/**

 * Test class to demonstrate static mocking with PowerMockito.

 */
//@RunWith(PowerMockRunner.class) 
@PrepareForTest( { SystemClass.class})
public class SystemClassTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
		
	@Test
	public void testMockStaticThatThrowsException() throws Exception {

		spy(Thread.class);
		// Expectations

		doThrow(new InterruptedException()).when(Thread.class);
		Thread.sleep(Mockito.anyLong());

		//Test 
		SystemClass systemClass = new SystemClass();

		systemClass.callThead();
		assertEquals(0, systemClass.j);
		
	}

	@Test
	public void testMockTime() throws Exception {
	
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));

	    Date NOW = sdf.parse("2018-06-16 00:00:01");

	    // everytime we call new Date() inside a method of any class
	    // declared in @PrepareForTest we will get the NOW instance 
	    PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(NOW);
		//Test 
		SystemClass systemClass = new SystemClass();
		//long time=systemClass.getDoubleTime();
		assertEquals(systemClass.getDoubleTime(),NOW.getTime());
	}
}
