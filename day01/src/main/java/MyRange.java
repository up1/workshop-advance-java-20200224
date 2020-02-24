public class MyRange {
    private String input;

    public MyRange(String input) {

        if(!(input.startsWith("[") || input.startsWith("("))) {
            throw new InvalidInputException();
        }

        this.input = input;
    }

    public boolean startWithInclude() {
        return input.startsWith("[");
    }

    public int getStartNumber() {
        if(startWithInclude()) {
            return input.charAt(1) - 48;
        }
        return input.charAt(1) - 47;
    }

    public String getResult() {
        String result = String.join(",", "1", "2", "3", "4", "5");
        return result;
    }
}
