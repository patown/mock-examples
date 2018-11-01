package demo.org.powermock.examples.localField;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;

import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;

@PrepareForTest(Caller.class)
public class CallerTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
	@Test
    public  void testCall() throws Exception{
		String mockString="I am mocked";
    	LocalClass localMock=mock(LocalClass.class);
    	
    	PowerMockito.whenNew(LocalClass.class).withNoArguments()
        .thenReturn(localMock);
        doReturn(mockString).when(localMock).ask();
    	Caller caller= new Caller();
    	assertEquals(caller.call(),mockString);
    	
    }
    
}
