package demo.org.powermock.examples.properties;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

import demo.org.powermock.examples.Properties.PropertiesClass;
import demo.org.powermock.staticfinal.ConstsDemo;

import org.powermock.reflect.Whitebox;
@PrepareForTest({PropertiesClass.class} )
public class PropertiesClassTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    @Mock
    private InputStream streamMock;
    String propString="aaa=8888";
	private Properties getProperties() {
		Properties prop = new Properties();	
		prop.setProperty("aaa", "8888");
		prop.setProperty("bbb", "6666");
		return prop;
	}
	//loading from a real property file
	@Ignore
	@Test
	public void testPropertiesClass() {
		PropertiesClass pc= new PropertiesClass();
		assertEquals("111",pc.print("aaa"));
	}
	//loading from a defult file and then modify the properties.
	@Ignore
	@Test
	public void testMockPropertiesClassWithDummy() {
		Properties mockProperties =PowerMockito.mock(Properties.class);
		PropertiesClass propertiesClass = new PropertiesClass();
		Whitebox.setInternalState(propertiesClass, "prop", mockProperties);
        PowerMockito.when(mockProperties.getProperty("aaa")).thenReturn("8888");
		assertEquals("8888",propertiesClass.print("aaa"));
	}
//	@Ignore
//	@Test
//	public void testMockPropertiesClass() {
//		InputStream streamMock = PowerMockito.mock(InputStream.class);
//		PropertiesClass propertiesClass =PowerMockito.mock(PropertiesClass.class);
//		PowerMockito.mockStatic(Class.class);
//		//Class clazz=propertiesClass.getClass();
//		PowerMockito.when(PropertiesClass.class.getClass().getResourceAsStream(Mockito.anyString())).thenReturn(getInputStream());
//		propertiesClass.print("aaa");
//		assertEquals("8888",propertiesClass.print("aaa"));
//	}
	@Ignore
	@Test
	public void testInputSteam() {
		InputStream streamMock = getInputStream();
		System.out.println(streamMock.toString());
	}
	
	private InputStream getInputStream() {
		try {
			InputStream stream =  new   ByteArrayInputStream(propString.getBytes("UTF-8"));
			return stream;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}   
		
	}
 




}
