package demo.org.powermock.examples.async;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.mockito.Mockito.*;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import demo.org.powermock.async.Client;
import demo.org.powermock.async.Connector;
import demo.org.powermock.async.IListener;

public class TestClient {

    
	String data="SUCCESS";
	@Spy
	private Connector connector;  
	@Captor
	private ArgumentCaptor<IListener> listenerMock;
	
    @Before public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }
	
	@Test
	public void TestClientLogin() {
	Client client=new Client(connector,"localhost");
    Answer<Object> answer = new Answer<Object>() {
    	@Override
		public Object answer(InvocationOnMock invocation) throws Throwable {
    		connector.onMessage(data);
    		return null;
		}
    };
	doAnswer(answer).when(connector).login("localhost");
	client.login();
	Assert.assertTrue(client.getConnected());
	}
    
} 
