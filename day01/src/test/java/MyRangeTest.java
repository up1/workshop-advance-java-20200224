import org.junit.Test;

import static org.junit.Assert.*;

public class MyRangeTest {

    @Test
    public void testcase01() {
        MyRange p = new MyRange("[1,5]");
        String result = p.getResult();
        assertEquals("1,2,3,4,5", result);
    }

    @Test
    public void input_should_start_with_include() {
        // Arrange
        MyRange p = new MyRange("[1,5]");
        // Act
        boolean result = p.startWithInclude();
        // Act
        assertTrue("ต้องเริ่มต้นด้วย [ นะ", result);
    }

    @Test
    public void input_should_start_with_exclude() {
        // Arrange
        MyRange p = new MyRange("(1,5]");
        // Act
        boolean result = p.startWithInclude();
        // Act
        assertFalse("ต้องเริ่มต้นด้วย ( นะ", result);
    }

    @Test
    public void input_start_with_include_and_1_should_be_1() {
        // Arrange
        MyRange p = new MyRange("[1,5]");
        // Act
        int result = p.getStartNumber();
        // Act
        assertEquals(1, result);
    }

    @Test
    public void input_start_with_exclude_and_1_should_be_2() {
        // Arrange
        MyRange p = new MyRange("(1,5]");
        // Act
        int result = p.getStartNumber();
        // Act
        assertEquals(2, result);
    }

}