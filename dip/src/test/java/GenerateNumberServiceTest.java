import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

class StubRandom5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class StubRandom11 extends Random {
    @Override
    public int nextInt(int bound) {
        return 11;
    }
}

public class GenerateNumberServiceTest {
    @Test
    public void generate_5() {
        Random random = new StubRandom5();
        GenerateNumberService g = new GenerateNumberService();
        g.setRandom(random);
        assertEquals(5, g.generate());
    }

    @Test(expected = RuntimeException.class)
    public void generate_11_should_throw_exception() {
        Random random = new StubRandom11();
        GenerateNumberService g = new GenerateNumberService();
        g.setRandom(random);
        g.generate();
    }
}