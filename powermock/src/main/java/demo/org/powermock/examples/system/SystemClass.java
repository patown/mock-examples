package demo.org.powermock.examples.system;

import java.util.Date;

public class SystemClass {
	public static final long TIME=996;
	int j=0;
	public void callThead() {
		for(int i=0;i<10;i++) {
		try {
			Thread.sleep(TIME);
		} catch (InterruptedException e) {
			//e.printStackTrace();
			break;
		}
		//end for
		j++;
		
		}

	}
	
	
    public long getDoubleTime(){
        return new Date().getTime();
    }
}
