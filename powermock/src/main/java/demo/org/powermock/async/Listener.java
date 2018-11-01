package demo.org.powermock.async;

public class Listener implements IListener {
	private Client client;
		public Listener(Client client) {
			this.client=client;
		}
		@Override
		public void onMessage(String data) {
			System.out.println(data);
			if(data.contains("SUCCESS")) {
				client.setConnected(true);
			}
		};
}
