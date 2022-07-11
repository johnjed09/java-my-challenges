package ChallengesClasses;

public class Multiplication extends MathOperations {

    public char MULTIPLY_OPERATOR = '*';
    private double answer = 0;

    public Multiplication(int num1, int num2) {
        super(num1, num2);
        calculate();
    }

    private void calculate() {
        this.answer = (int) (super.getNum1() * super.getNum2());
    }

    @Override
    public String printAnswer() {
        return String.format("%d %c %d = %d \n", (int) super.getNum1(), this.MULTIPLY_OPERATOR, (int) super.getNum2(), (int) this.answer);
    }
}
