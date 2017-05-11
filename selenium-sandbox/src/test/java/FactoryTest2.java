import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
 * Created by tbalogh on 5/10/17.
 */
public class FactoryTest2 {

    private final String firstName;

    @Factory(dataProvider = "name-provider", dataProviderClass = UserProvider.class)
    public FactoryTest2(String firstName) {
        this.firstName = firstName;
    }

    @Test
    public void testFirstName() {
        System.out.println(firstName);
    }
}
