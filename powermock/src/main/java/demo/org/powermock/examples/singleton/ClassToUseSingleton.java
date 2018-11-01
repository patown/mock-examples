package demo.org.powermock.examples.singleton;

public class ClassToUseSingleton {
    public String invokeSingleton()
    {
        return Singleton.getInstance().printHelloWorld( "Hi!!!" );
    }
}
