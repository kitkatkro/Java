import java.io.Closeable;
import java.io.IOException;

public class NotNumberElementException extends NumberFormatException implements Closeable {
    public String getMessage() {
        return "Element of matrix isn't a number";
    }

    @Override
    public void close() throws IOException {

    }
}
