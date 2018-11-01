package demo.org.powermock.async;

public class Client {
	private Connector connector;
	private String server;
	boolean connected=false;
	public Client(Connector connector,String server) {
		this.connector=connector;
		this.server=server;
		this.connector.setListener(new Listener(this));
}

	
	public void setConnected(boolean connected) {
		this.connected=connected;
	}
	public boolean getConnected() {
		return connected;
	}
	public void login() {
		int times=0;
		// sending login request to remote 
		connector.login(server);
		// waiting for response from network
		while(!getConnected() && times <10) {
			try {
				Thread.sleep(100);
				times++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
