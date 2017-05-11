import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

/**
 * Created by tbalogh on 5/9/17.
 */
public class MultiThreadTest {

    @Test
    public void test1() {
        System.out.println("test 1: " + Thread.currentThread().getName());
    }

    @Test
    public void test2() {
        System.out.println("test 2: " + Thread.currentThread().getName());
    }

    @Test
    public void test3() {
        System.out.println("test 3: " + Thread.currentThread().getName());
    }

    @Test
    public void test4() {
        System.out.println("test 4: " + Thread.currentThread().getName());
    }
}
