package demo.org.powermock.examples.localField;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SUT {
    public String doSomething() throws IOException {
        InputStreamReader reader =
                new InputStreamReader(getFileAsStream(null, null));
        BufferedReader bReader =
                new BufferedReader(reader);

        return bReader.readLine();
    }

    private InputStream getFileAsStream(Object resourceResolver, Object iconPath)
            throws FileNotFoundException {
        return new ByteArrayInputStream("".getBytes());
    }
}
