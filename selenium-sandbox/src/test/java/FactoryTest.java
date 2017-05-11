import org.testng.annotations.Test;

/**
 * Created by tbalogh on 5/10/17.
 */
public class FactoryTest {

    private final String firstName;

    public FactoryTest(String firstName) {
        this.firstName = firstName;
    }

    @Test
    public void testFirstName() {
        System.out.println(firstName);
    }
}
