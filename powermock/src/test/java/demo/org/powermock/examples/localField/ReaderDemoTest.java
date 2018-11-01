package demo.org.powermock.examples.localField;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.rule.PowerMockRule;


@PrepareForTest({ ReaderDemo.class })
public class ReaderDemoTest {
    @Rule
    public PowerMockRule rule = new PowerMockRule();
    @Test
    public void doSomethingReturnsValueFromBufferedReader() throws Exception {
       
        InputStreamReader inputStreamReaderMock = mock(InputStreamReader.class);
        BufferedReader bufferedReaderMock = mock(BufferedReader.class);
        FileInputStream inputStreamMock= mock(FileInputStream.class);

        PowerMockito.whenNew(BufferedReader.class).
                     withArguments(inputStreamReaderMock).
                     thenReturn(bufferedReaderMock);
        
        PowerMockito.whenNew(FileInputStream.class).
        withAnyArguments().
        thenReturn(inputStreamMock);
        
       PowerMockito.whenNew(InputStreamReader.class).
                     withAnyArguments().thenReturn(inputStreamReaderMock);
        

        final String string = "key=value\n";
       doReturn(string).doReturn(null).when(bufferedReaderMock).readLine();

        // read && Assert
        assertEquals(string, ReaderDemo.read("anything"));
    }
}