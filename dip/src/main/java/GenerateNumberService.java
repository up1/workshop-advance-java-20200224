import java.util.Random;

public class GenerateNumberService {

    MyRandom random;

    public void setRandom(MyRandom random) {
        this.random = random;
    }

    public int generate() {
        int number = this.random.nextInt(10);
        if(number >=0 && number <= 10) {
            return number;
        }
        throw new RuntimeException("Random fail");
    }

}
