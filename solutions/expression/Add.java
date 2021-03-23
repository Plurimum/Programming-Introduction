package expression;

public class Add extends Operation {

    public Add(DoubleExpression left, DoubleExpression right) {

        super(left, right);

    }

    protected int evaluate(int left, int right) {
        return left + right;
    }

    public double evaluate(double left, double right) {
        return left + right;
    }
}