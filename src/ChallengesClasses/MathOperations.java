package ChallengesClasses;

public class MathOperations {

    private double num1;
    private double num2;
    private double answer;

    public MathOperations(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String printAnswer() {
        return String.format("%s", answer);
    }

    public double getNum1() {
        return this.num1;
    }

    public double getNum2() {
        return this.num2;
    }
}
