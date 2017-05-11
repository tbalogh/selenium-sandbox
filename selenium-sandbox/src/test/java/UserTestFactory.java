import org.testng.annotations.Factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tbalogh on 5/10/17.
 */
public class UserTestFactory {
    @Factory
    public Object[] createInstances(String name, String email) {
        List<Object> instances = new ArrayList<>();
        instances.addAll(Arrays.asList(
                new FactoryTest("Tomi"),
                new FactoryTest("Tamas")
        ));
        return instances.toArray();
    }
}
