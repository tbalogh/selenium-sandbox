import org.testng.annotations.DataProvider;

/**
 * Created by tbalogh on 5/10/17.
 */
public class UserProvider {

    @DataProvider(name = "user-provider")
    public static Object[][] provideUsers() {
        return new Object[][] {
                { "Paul Hoffman", "ph@email.com" },
                { "Richardo Rodrigez", "rr@email.com" },
                { "Michael", "m89@email.com" },
        };
    }

    @DataProvider(name = "name-provider")
    public static Object[][] provideNames() {
        return new Object[][] {
                { "Paul Hoffman" },
                { "Richardo Rodrigez" },
                { "Michael" },
        };
    }
}
