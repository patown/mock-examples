package demo.org.powermock.examples.staticfinal;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.powermock.reflect.Whitebox;

import demo.org.powermock.staticfinal.Consts;
import demo.org.powermock.staticfinal.ConstsDemo;
import static org.powermock.api.mockito.PowerMockito.*;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@PrepareForTest({ConstsDemo.class} )
public class ConstsDemoTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
	@BeforeClass	
	public static void setup() throws NoSuchFieldException, IllegalAccessException{
		//setFinalStatic(Consts.class,"TIMEOUT", -1L);
	}
    @Test(expected=Exception.class,timeout=2000L)
    public void testConsts_TIMEOUT() throws Exception {
    	
    	spy(System.class);
    	when(System.currentTimeMillis()).thenCallRealMethod().thenCallRealMethod().thenReturn(Long.MAX_VALUE);
//    	spy(Consts.class);
//        Whitebox.setInternalState(Consts.class, "TIMEOUT", -1L);
        ConstsDemo demo= new ConstsDemo();
        demo.longCall();
    }
    
    
    static void setFinalStatic(Class clazz, String fieldName, Object newValue) throws NoSuchFieldException, IllegalAccessException {
        Field field = clazz.getDeclaredField(fieldName);
        field.setAccessible(true);
        Field modifiers = field.getClass().getDeclaredField("modifiers");
        modifiers.setAccessible(true);
        modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }

}
