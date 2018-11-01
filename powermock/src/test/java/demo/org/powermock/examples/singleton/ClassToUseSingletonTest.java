package demo.org.powermock.examples.singleton;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.powermock.reflect.Whitebox;
import static org.junit.Assert.assertEquals;

import org.junit.Rule;




@PrepareForTest(Singleton.class )
public class ClassToUseSingletonTest{ 
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    @Test
    public void testSingeton() throws Exception {
    	Singleton mockSingleton =  PowerMockito.mock(Singleton.class);

        Class clazz = Whitebox.getInnerClassType(Singleton.class, "SingletonInstance");
        Whitebox.setInternalState(clazz, "INSTANCE", mockSingleton);
        PowerMockito.when( mockSingleton.printHelloWorld( Mockito.anyString() ) )
                    .thenReturn( "Mocked!!" );

        assertEquals( "Mocked!!", 
                      new ClassToUseSingleton().invokeSingleton() );


    }
}
