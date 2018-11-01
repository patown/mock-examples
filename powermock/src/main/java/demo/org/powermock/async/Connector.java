package demo.org.powermock.async;

public class Connector {
	
	private IListener listener;	

	public void onMessage(String data) {
		listener.onMessage(data);
	}
	public void setListener(IListener listener) {
		this.listener=listener;
	}
	
	public void login(String url) {
		System.out.println("sending login request to "+url);
	}
}
