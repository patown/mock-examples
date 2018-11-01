package demo.org.powermock.examples.localField;

public class Caller {
    
    public  String call(){
    	LocalClass local=new LocalClass();
    	return local.ask();
    }
    
}
