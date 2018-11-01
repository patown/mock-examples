package demo.org.powermock.examples.singleton;

public class  Singleton
{
    //INSTANCE;

    public String printHelloWorld( String value )
    {
        StringBuilder stringBuilder 
             = new StringBuilder( "The string value is: " );

        return stringBuilder.append( value ).toString();
    }
    

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}