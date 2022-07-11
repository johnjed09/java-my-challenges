/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ChallengesClasses;

public class Division extends MathOperations {

    public char MULTIPLY_OPERATOR = '/';
    private double answer = 0;

    public Division(int num1, int num2) {
        super(num1, num2);
        calculate();
    }

    private void calculate() {
        this.answer = super.getNum1() / super.getNum2();
    }

    @Override
    public String printAnswer() {
        return String.format("%.2f %c %.2f = %.2f \n", super.getNum1(), this.MULTIPLY_OPERATOR, super.getNum2(), this.answer);
    }
}
