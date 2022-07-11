package ChallengesClasses;

public class Addition extends MathOperations {

    public char ADD_OPERATOR = '+';
    private int answer = 0;

    public Addition(int num1, int num2) {
        super(num1, num2);
        calculate();
    }

    private void calculate() {
        this.answer = (int) (super.getNum1() + super.getNum2());
    }
    

    @Override
    public String printAnswer() {
        return String.format("%d %c %d = %d \n", (int) super.getNum1(), this.ADD_OPERATOR, (int) super.getNum2(), this.answer);
    }
}
