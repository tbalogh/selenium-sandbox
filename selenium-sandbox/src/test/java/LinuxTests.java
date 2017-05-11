import org.testng.annotations.Test;

/**
 * Created by tbalogh on 5/9/17.
 */
public class LinuxTests {
    @Test(groups = {"linux"})
    public void testLinux1() {
        System.out.println("Linux test 1");
    }

    @Test(groups = {"linux"})
    public void testLinux2() {
        System.out.println("Linux test 2");
    }


    @Test(groups = {"linux.regression"})
    public void testLinux3() {
        System.out.println("Linux test 3");
    }

}
