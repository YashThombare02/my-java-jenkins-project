import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void testAdd() {
        Hello h = new Hello();
        assertEquals(10, h.add(2, 3));   // intentionally wrong
    }
}

