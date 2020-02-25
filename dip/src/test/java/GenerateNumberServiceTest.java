import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

class StubRandom5 implements MyRandom {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class StubRandom11 implements MyRandom {
    @Override
    public int nextInt(int bound) {
        return 11;
    }
}

class SpyMyRandom implements MyRandom {

    private int counter;

    @Override
    public int nextInt(int bound) {
        this.counter++;
        return 10;
    }

    public void verify(int expectCalled) {
        assertTrue(this.counter == expectCalled);
    }
}

public class GenerateNumberServiceTest {

    @Test
    public void verify_called_myrandom_nextInt() {
        SpyMyRandom spy = new SpyMyRandom();
        GenerateNumberService g = new GenerateNumberService();
        g.setRandom(spy);
        g.generate();
        // Assert
        spy.verify(1);
    }

    @Test
    public void generate_5() {
        MyRandom random = new StubRandom5();
        GenerateNumberService g = new GenerateNumberService();
        g.setRandom(random);
        assertEquals(5, g.generate());
    }

    @Test(expected = RuntimeException.class)
    public void generate_11_should_throw_exception() {
        MyRandom random = new StubRandom11();
        GenerateNumberService g = new GenerateNumberService();
        g.setRandom(random);
        g.generate();
    }
}