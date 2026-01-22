import org.junit.Test;
import static org.junit.Assert.*;

public class HelloTest {

    @Test
    public void testAdd() {
        Hello h = new Hello();
        assertEquals(5, h.add(2, 3));
    }
}
