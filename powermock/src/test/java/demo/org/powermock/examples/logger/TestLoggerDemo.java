package demo.org.powermock.examples.logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.org.powermock.examples.LoggerDemo;

import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.*;
import static org.powermock.api.mockito.PowerMockito.when;



@PrepareForTest({LoggerFactory.class})
public class TestLoggerDemo {
//    @Rule
//    public PowerMockRule rule = new PowerMockRule();
//    private static Logger loggerMock;

//    @Before
//    public  void setup() {
//        mockStatic(LoggerFactory.class);
//        loggerMock = mock(Logger.class);
//        when(LoggerFactory.getLogger(any(Class.class))).thenReturn(loggerMock);
//    }


//    
//    @Test
//    public void testLoggerInfo() {
//    	//when(loggerMock.isDebugEnabled()).thenReturn(true);
//    	LoggerDemo loggerDemo = new LoggerDemo();
//    	loggerDemo.toInt("100");
//    	//notify here is using atLeastOnce() because that loggerMock is static and all the call will be counted. 
//        verify(loggerMock, atLeastOnce()).info(Mockito.anyString());
//    }
//    
//    @Test
//    public void testLoggerDebugEnabled() {
//    	when(loggerMock.isDebugEnabled()).thenReturn(true);
//    	LoggerDemo loggerDemo = new LoggerDemo();
//    	loggerDemo.toInt("100");
//        verify(loggerMock, times(1)).debug(Mockito.anyString());
//    }
//    
//    @Test
//    public void testLoggerError() {
//    	//when(loggerMock.isDebugEnabled()).thenReturn(true);
//    	LoggerDemo loggerDemo = new LoggerDemo();
//    	loggerDemo.toInt("������");
//        verify(loggerMock, times(1)).error(Mockito.anyString());
//    }

}