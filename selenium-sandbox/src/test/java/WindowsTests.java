import org.testng.annotations.Test;

/**
 * Created by tbalogh on 5/9/17.
 */
public class WindowsTests {
    @Test(groups = {"windows"})
    public void testWindows1() {
        System.out.println("Windows test 1");
    }

    @Test(groups = {"windows"})
    public void testWindows2() {
        System.out.println("Windows test 2");
    }


    @Test(groups = {"windows.regression"})
    public void testWindows3() {
        System.out.println("Windows test 3");
    }
}
