import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by tbalogh on 5/10/17.
 */
public class ParametrizedTest {
    @Parameters({ "first-name" })
    @Test
    public void testFirstName(String firstName) {
        System.out.println(firstName);
    }

    @Parameters({ "name", "email" })
    @Test(dataProvider = "user-provider", dataProviderClass = UserProvider.class)
    public void testFirstName(String name, String email) {
        System.out.println("Name: " + "\t" + name + "\t" + "Email: " + "\t" + email);
    }
}
