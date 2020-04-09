import java.io.Closeable;
import java.io.IOException;

public class MatrixDimensionException extends RuntimeException implements Closeable {
    public String getMessage() {
        return "Matrix dimension isn't 4x4";
    }

    @Override
    public void close() throws IOException {

    }
}
