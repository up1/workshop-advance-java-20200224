import org.junit.Test;

import static org.junit.Assert.*;

public class MyRangeFailureTest {

    @Test
    public void ขึ้นต้นด้วยตัวเลข() {
        try {
            MyRange p = new MyRange("1,5]");
            fail();
        } catch (InvalidInputException e) { }
    }

    @Test(expected = InvalidInputException.class)
    public void ขึ้นต้นด้วยตัวเลข2() {
        MyRange p = new MyRange("1,5]");
    }

}