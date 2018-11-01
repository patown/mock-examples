package demo.org.powermock.staticfinal;

public class ConstsDemo {
	
	public void longCall() throws Exception {
		long begin = System.currentTimeMillis();
		while(true) {
		if(System.currentTimeMillis()-begin > Consts.TIMEOUT) {
			System.out.println("timeout");
			throw new Exception("timeout");
		}
		try {
			Thread.sleep(100);
			System.out.println(Consts.TIMEOUT);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		}
		
	}
}
